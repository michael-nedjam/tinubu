# Utiliser une image de base officielle Java qui inclut le JDK
FROM eclipse-temurin:17-jdk-focal

# Installer Maven
RUN apt-get update && \
    apt-get install -y maven

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier le reste du code source
COPY src ./src

# Compiler l'application
RUN mvn package -DskipTests

# Exposer le port sur lequel l'application va tourner
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "target/assurance-app-1.0-SNAPSHOT.jar"]