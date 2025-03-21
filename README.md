# Application de Gestion des Polices d'Assurance

Cette application Spring Boot permet de gérer les polices d'assurance. Elle utilise PostgreSQL comme base de données.

## Prérequis

- Java 17 ou version ultérieure
- Maven
- PostgreSQL

## Exécution Localement

Construire l'application:
    mvn clean install
Exécuter l'application:
    java -jar target/assurance-app.jar
ou
    mvn spring-boot:run

## Endpoints API

L'application expose plusieurs endpoints pour gérer les polices d'assurance :
    GET /api/polices: Liste toutes les polices d'assurance.
    POST /api/polices: Crée une nouvelle police d'assurance.
    GET /api/polices/{id}: Lit une police d'assurance par son ID.
    PUT /api/polices/{id}: Met à jour une police d'assurance existante.

## Surveillance avec Actuator

L'application utilise Spring Boot Actuator pour exposer des endpoints de surveillance :
    GET /actuator/health: Vérifie l'état de santé de l'application.
    GET /actuator/info: Fournit des informations générales sur l'application.
    GET /actuator/metrics: Fournit des métriques sur les performances de l'application.

