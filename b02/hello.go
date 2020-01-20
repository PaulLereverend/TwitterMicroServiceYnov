package main

import (
	"encoding/json"
	"fmt"
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

//DB variable globale de la bdd
var DB *gorm.DB

func main() {
	db, err := gorm.Open("sqlite3", "test.db")
	if err != nil {
		panic("failed to connect database")
	} else {
		DB = db
	}
	defer db.Close()

	// Migrate the schema
	db.AutoMigrate(&Tweet{})

	http.HandleFunc("/getweets", getTweets)
	http.HandleFunc("/savetweet", saveTweet)
	http.HandleFunc("/unsavetweet", unsaveTweet)
	log.Fatal(http.ListenAndServe(":8080", nil))
}

func getTweets(w http.ResponseWriter, r *http.Request) {
	if r.Method == "GET" {
		//recup l'id user
		idUser := r.FormValue("id_user")

		//recup tout les tweets de l'utilisateur
		var tweets []Tweet
		DB.Where("id_user = ?", idUser).Find(&tweets)

		//encode en JSON les réponses
		pagesJSON, err := json.Marshal(tweets)
		if err != nil {
			log.Fatal("Cannot encode to JSON ", err)
		}
		fmt.Fprintf(w, fmt.Sprintf("%s", pagesJSON))
	}
}

func saveTweet(w http.ResponseWriter, r *http.Request) {
	if r.Method == "POST" {
		idUser := r.FormValue("id_user")
		idTweet := r.FormValue("id_tweet")
		// crée le lien entre l'utilisateur et le tweet
		DB.Create(&Tweet{IDUser: idUser, IDTweet: idTweet})
		fmt.Fprintf(w, "Add new TweetUser : {IDUser %s IDTweet %s}", idUser, idTweet)
	}
}

func unsaveTweet(w http.ResponseWriter, r *http.Request) {
	if r.Method == "DELETE" {
		idUser := r.FormValue("id_user")
		idTweet := r.FormValue("id_tweet")

		//recup le lien entre l'utilisateur et le tweet souhaintant être supprimée
		var tweet Tweet
		DB.Where("id_user = ?", idUser).Where("id_tweet = ?", idTweet).Find(&tweet)

		//supprime le lien entre l'utilisateur et le tweet
		DB.Delete(&tweet)
		fmt.Fprintf(w, "Delete TweetUser : {IDUser %s IDTweet %s}", idUser, idTweet)
	}
}
