## Utilisation du backend de récupération des tweets

Lancement du serveur

`docker build -t b3 .`

`docker run -p 8083:8080 b3`

## Méthodes

- GET - `/timeline` : Retourne la timeline de l'utilisateur

```json
[
  {
    "date": "Tue Feb 04 07:15:52 UTC 2020",
    "text": "test",
    "user": "PyresRobert"
  },
  {
    "date": "Tue Feb 04 04:27:51 UTC 2020",
    "text": "Big WIN for us in Iowa tonight. Thank you!",
    "user": "realDonaldTrump"
  },
  {
    "date": "Tue Feb 04 04:23:21 UTC 2020",
    "text": "RT @SaraCarterDC: #EXCLUSIVE\n\nGOP Investigation:Thousands Of Obama Admin Docs Under Review Regarding Ukraine White House Meetings \n\nRead my…",
    "user": "realDonaldTrump"
  },
  {
    "date": "Tue Feb 04 04:12:03 UTC 2020",
    "text": "RT @SenMcSallyAZ: .@Raytheon is headquartering its combined missiles defense unit right here in Southern Arizona.\nhttps://t.co/KhQRzdvSXt",
    "user": "realDonaldTrump"
  }
]
```

- GET - `tweet/{id}` : Retourne un tweet

```json
{
  "date": "Mon Feb 03 10:51:19 UTC 2020",
  "text": "Vous allez jamais me croire.\n\nStream avant 13h.",
  "user": "Sardoche_Lol"
}
```
