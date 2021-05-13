# Setup Anforderungen

  * Docker
  * Docker Compose
  * JDK >= 11

# MigrationsTool-Setup

  * Um ein bestimmtes Migrationstool zu nutzen, muss in der Datei `./src/main/resources/application.propterties` folgende Eigentschaft eingestellt sein.
    * Flyway -> `spring.flyway.enabled` auf `${ENABLE_FLYWAY:true}` stellen (Im Default schon an)
    * Liquibase -> `spring.liquibase.enabled` auf `${ENABLE_LIQUIBASE:true}` stellen
  
# How to run

  * Im Ordner `./docker` diesen befehl ausführen:
    * `docker-compose up -d;`
    * Dadurch wird auf `http://localhost:5050/`der pgadmin gehosted.
  * Um die Datenbank aufzubauen und die Applikation zu starten, auf diesem Ordner diesen Befehl ausführen:
    * `./gradlew bootRun` (Linux)
    * `gradlew.bat bootRun` (Windows)

# pgadmin nutzen

  * Um in der Webseite zutritt zu bekommen, folgender Login-Daten sind zur Verfügung:
    * Email-Adresse -> `admin@admin.ch`
    * Passwort -> `passwort`
  * Um mit dem Server "houseConstruct" in Postgresql-Datenbank zu verbinden, solche Schritte zu führen:
    * Auf Icon `Add New Server` anklicken
    * Auf Tab `Connection` wechseln
    * Folgende Daten angeben:
      * Hostname/adress -> `postgres`
      * Port -> `5432`
      * Maintenance Database -> `houseConstruct`
      * Username -> `admin`
      * Password -> `passwort`
    * Dann auf `save` klicken und dann ist die Datenbank-Zugriff zur Verfügung gestellt
