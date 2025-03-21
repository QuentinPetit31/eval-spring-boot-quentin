Documentation des Endpoints API - Spring Boot

AJOUTER UN PRODUIT

Méthode HTTP : POST
URL : ` localhost:8081/api/produits [POST]`
Description : Permet d’ajouter un nouveau produit avec sa catégorie.

 EXEMPLE JSON VALIDE
```json
{
  "nom": "Burger",
  "prix": 10.5,
  "categorie": {
    "id": 1
  }
}

```
EXEMPLE JSON NON VALIDE
```json
{
  "nom": "",
  "prix": 0,
  "categorie": {
    "id": 1
  }
}
```
nom vide donc code attendu -> 400 Bad request

////////////////////////////////////////////////////////////////////////////////


AFFICHER UNE CATEGORIE PAR ID

Méthode HTTP : GET
EXEMPLE VALIDE :
URL : localhost:8081/api/categories/{id}
Exemple : localhost:8081/api/categories/1
Description : Retourne la catégorie de l’ID fourni.

Code HTTP attendu :

200 OK si la catégorie est trouvée
404 Not Found si elle n'existe pas

```json

json
{
  "id": 1,
  "libele": "Fast Food"
}
```

EXEMPLE NON VALIDE :
Méthode HTTP : GET  
EXEMPLE NON VALIDE :  
URL : localhost:8081/api/categories/{id}  
Exemple : localhost:8081/api/categories/99  
Description : L’ID fourni ne correspond à aucune catégorie existante.

Code HTTP attendu :

404 Not Found si la catégorie n'existe pas

```json
{
  "error": "La catégorie avec l'ID 99 n'existe pas."
}
```
////////////////////////////////////////////////////////////////////////////////
