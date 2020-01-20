package main

import (
	"fmt"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/sqlite"
)

//Tweet model
type Tweet struct {
	ID      uint `gorm:"primary_key"`
	idUser  string
	idTweet string
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
	db.Create(&Tweet{idUser: "L1212", idTweet: "aze43Ezez43"})

	// Read
	var tweet Tweet
	db.Find(&tweet)
	fmt.Println(&tweet)
	db.First(&tweet, 1) // find tweet with id 1
	//db.First(&tweet, "idTweet = ?", "L1212") // find tweet with idTweet l1212

	// Update - update tweet's idTweet to qsd43Ezez43
	db.Model(&tweet).Update("idTweet", "qsd43Ezez43")

	// Delete - delete tweet
	db.Delete(&tweet)
}
