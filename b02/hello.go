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

func main() {
	fmt.Println("Hello, world.")

	db, err := gorm.Open("sqlite3", "test.db")
	if err != nil {
		panic("failed to connect database")
	}
	defer db.Close()

	// Migrate the schema
	db.AutoMigrate(&Tweet{})

	// Create
	db.Create(&Tweet{IDUser: "L1212", IDTweet: "aze43Ezez43"})

	// Read
	var tweet Tweet
	db.Find(&tweet)
	fmt.Println(&tweet)
	db.First(&tweet, 1) // find tweet with id 1
	fmt.Println(&tweet)
	db.First(&tweet, "id_tweet = ?", "L1212") // find tweet with IDTweet l1212
	fmt.Println(&tweet)

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

	if r.Method == "POST" {
		// Call ParseForm() to parse the raw query and update r.PostForm and r.Form.
		if err := r.ParseForm(); err != nil {
			fmt.Fprintf(w, "ParseForm() err: %v", err)
			return
		}
		fmt.Fprintf(w, "Post from website! r.PostFrom = %v\n", r.PostForm)
		idUser := r.FormValue("id_user")
		fmt.Fprintf(w, "id_user = %s\n", idUser)
	} else {
		fmt.Fprintf(w, "Sorry, only GET and POST methods are supported.")
	}
}
