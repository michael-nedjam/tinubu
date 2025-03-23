# Application de Gestion des Polices d'Assurance

Cette application Spring Boot permet de gérer les polices d'assurance. Elle utilise PostgreSQL comme base de données.

## Prérequis

- Java 17 ou version ultérieure
- Maven
- PostgreSQL

## Exécution avec Docker (App + DB)

Pour démarrer l'application et la base de données avec Docker Compose :

```bash
docker-compose up --build
```

## Exécution Localement
Construire l'application:
```bash
cd backend
mvn clean install
```
Exécuter l'application (pré-requis la base postgre):
```bash
cd backend
mvn spring-boot:run
```

### Construire l'Image Docker 

Pour construire l'image Docker de l'application, exécutez la commande suivante dans le répertoire racine du projet :

```bash
cd backend
docker build -t assurance-app .
```

### Exécuter le Conteneur Docker (pré-requis la base postgre)

```bash
cd backend
docker run -p 8080:8080 assurance-app
```

## Endpoints API

L'application expose plusieurs endpoints pour gérer les polices d'assurance :
- GET /api/polices: Liste toutes les polices d'assurance.
- POST /api/polices: Crée une nouvelle police d'assurance.
- GET /api/polices/{id}: Lit une police d'assurance par son ID.
- PUT /api/polices/{id}: Met à jour une police d'assurance existante.

## Surveillance avec Actuator

L'application utilise Spring Boot Actuator pour exposer des endpoints de surveillance :
- GET /actuator/health: Vérifie l'état de santé de l'application.
- GET /actuator/info: Fournit des informations générales sur l'application.
- GET /actuator/metrics: Fournit des métriques sur les performances de l'application.

