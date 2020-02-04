# TwitterMicroServiceYnov

## Équipe

- Lereverend Paul
- Huet Hugo
- Crochet Olivier
- Bouchain Loïc
- Dezat Valentin


# Objectifs

Le projet consiste en la création d’une application permettant de sauvegarder, supprimer et lire dans nos bases de données les tweets. Pour cela, une inscription et la possession d'un compte Twitter sont nécessaires pour faire le lien entre ces différentes informations.

- ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) B1 : Backend de connexion et inscription : Loïc
- ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) B2 : Backend de sauvegarde des tweets : Hugo 
- ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) B3 : Backend de récupération d’un tweet et de la timeline : Paul
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) B4 : Backend d’écriture d’un tweet : Valentin
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) F1 : Frontend : Olivier
- ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) Innovation : Paul

# Utilisation

Des explications d'utilisation sont disponibles dans les dossiers des différents services. 

## Lancement

```
docker-compose up
```

## Déploiement 

```
oc login
oc apply -f {fichier_de_deploiement}
```

## Architecture 

B1 : localhost:8080

B2 : localhost:8082 -> Voir readme dans le dossier B2 pour les ressources

B3 : localhost:8083 -> Voir readme dans le dossier B3 pour les ressources

B4 : ????

F1 : localhost:4201

## Support 

Contacter paul.lereverend@ynov.com (réponse sous 24h)
