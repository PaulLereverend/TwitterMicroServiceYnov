package main

import (
	"encoding/json"
	"log"
	"net/http"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/sqlite"
)

//Tweet model
type Tweet struct {
	ID      uint `gorm:"primary_key"`
	IDUser  string
	IDTweet string
}

//Response model
type Response struct {
	ResCode string
	Data    string
}

//DB variable globale de la bdd
var DB *gorm.DB

func main() {
	db, err := gorm.Open("sqlite3", "tweet_user.db")
	if err != nil {
		panic("failed to connect database")
	} else {
		DB = db
	}
	defer db.Close()

	// Migrate the schema
	db.AutoMigrate(&Tweet{})

	http.HandleFunc("/tweet/all", getTweets)
	http.HandleFunc("/tweet/save", saveTweet)
	http.HandleFunc("/tweet/delete", unsaveTweet)
	log.Fatal(http.ListenAndServe(":8080", nil))
}

func getTweets(w http.ResponseWriter, r *http.Request) {
	if r.Method == "GET" {
		//recup l'id user
		idUser := r.FormValue("id_user")

		//recup tout les tweets de l'utilisateur
		var tweets []Tweet
		DB.Where("id_user = ?", idUser).Find(&tweets)

		responseJSON(w, http.StatusOK, tweets)
	} else {
		responseJSON(w, http.StatusNotFound, nil)
	}
}

func saveTweet(w http.ResponseWriter, r *http.Request) {
	if r.Method == "POST" {
		idUser := r.FormValue("id_user")
		idTweet := r.FormValue("id_tweet")
		// crée le lien entre l'utilisateur et le tweet
		newData := DB.Create(&Tweet{IDUser: idUser, IDTweet: idTweet})

		responseJSON(w, http.StatusOK, newData)
	} else {
		responseJSON(w, http.StatusNotFound, nil)
	}
}

func unsaveTweet(w http.ResponseWriter, r *http.Request) {
	if r.Method == "DELETE" {
		idUser := r.FormValue("id_user")
		idTweet := r.FormValue("id_tweet")

		//recup le lien entre l'utilisateur et le tweet souhaintant être supprimée
		var tweet Tweet
		DB.Where("id_user = ?", idUser).Where("id_tweet = ?", idTweet).Find(&tweet)

		//s'il y a bien un lien entre l'utilisateur et le tweet de trouvé alors on supprime
		if tweet.ID != 0 {
			//supprime le lien entre l'utilisateur et le tweet
			delData := DB.Delete(&tweet)
			responseJSON(w, http.StatusOK, delData)
		} else {
			responseJSON(w, http.StatusBadRequest, nil)
		}
	} else {
		responseJSON(w, http.StatusNotFound, nil)
	}
}

func responseJSON(w http.ResponseWriter, status int, payload interface{}) {
	response, err := json.Marshal(payload)
	if err != nil {
		w.WriteHeader(http.StatusInternalServerError)
		w.Write([]byte(err.Error()))
		return
	}
	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(status)
	w.Write([]byte(response))
}
