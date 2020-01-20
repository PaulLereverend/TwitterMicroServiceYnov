package main

import (
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
var i = 0

func main() {
	fmt.Println("Hello, world. 2")

	db, err := gorm.Open("sqlite3", "test.db")
	if err != nil {
		panic("failed to connect database")
	} else {
		DB = db
	}
	defer db.Close()

	// Migrate the schema
	db.AutoMigrate(&Tweet{})

	i++
	// Create
	db.Create(&Tweet{IDUser: "L1212", IDTweet: fmt.Sprintf("%s%d", "qsd43", i)})

	// Read
	// var tweet Tweet
	// db.Find(&tweet)
	// db.First(&tweet, 1) // find tweet with id 1
	// db.First(&tweet, "id_tweet = ?", "L1212") // find tweet with IDTweet l1212
	// fmt.Println(&tweet)

	// Update - update tweet's IDTweet to qsd43Ezez43
	// db.Model(&tweet).Update("id_tweet", "qsd43Ezez43")

	// Delete - delete tweet
	// db.Delete(&tweet)

	http.HandleFunc("/", hello)
	log.Fatal(http.ListenAndServe(":8080", nil))
}

func hello(w http.ResponseWriter, r *http.Request) {
	if r.URL.Path != "/" {
		http.Error(w, "404 not found.", http.StatusNotFound)
		return
	}

	if r.Method == "GET" {
		idUser := r.FormValue("id_user")

		var tweets []Tweet
		DB.Where("id_user = ?", idUser).Find(&tweets) // find tweet with IDUser l1212

		for _, tweet := range tweets {
			fmt.Fprintf(w, tweet.IDTweet+"\n")
		}
	} else if r.Method == "POST" {
		i++
		// Create
		DB.Create(&Tweet{IDUser: "L1212", IDTweet: fmt.Sprintf("%s%d", "qsd43", i)})
	}
}
