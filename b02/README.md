# TwitterMicroServiceYnov

## Lancer le serveur

Il y a deux manières pour lancer le serveur :

* Run the file

        go run server.go

* Build and Run the executable

        go build server.go
        ./server

## Obtenir Go
Pour installer Go, vous pouvez suivre ce tutoriel : https://golang.org/

## Paquet
Pour obtenir les packages nécessaires au bon fonctionnement de l'application, il faut executer la commande : 
    `go get package_name` 
> (package_name correspondant au nom du package).

## Méthodes

- GET - `tweet/all` : Retourne les tweets de l'utilisateur
    * id_user
- POST - `tweet/save` : Crée le lien entre l'utilisateur et le tweet dans la base de données
    * id_user
    * id_tweet
- DELETE - `tweet/delete` : Supprime le lien entre l'utilisateur et le tweet dans la base de données
    * id_user
    * id_tweet
