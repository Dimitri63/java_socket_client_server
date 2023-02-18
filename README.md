# java_socket_client_server
Créer un nouveau projet Maven
partir de l'archétype : maven-archetype-quickstart


Choisir la version de java JDK-18

Créer le projet


Modifier le pom.xml pour modifier la version du compiler de maven-archetype-quickstart :
<properties>
<maven.compiler.source>11</maven.compiler.source>
<maven.compiler.target>11</maven.compiler.target>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>

Faire un mvn clean install

Se déplacer dans le dossier target
Et exécuter le jar compiler
java -cp DiscordAPI-1.0-SNAPSHOT.jar org.example.App

Créer notre code avec les dépendances dont nous avons besoin.
A présent il faut faire un build de l'application en prennant en compte les dépendances externes

project-structure
- artefact
    - artefact avec dépendance
        - choisir le manifest

Faire un buid de l'artefact

Maintenant dans le dossier out/artefact
java -cp DiscordAPI.jar org.example.App
