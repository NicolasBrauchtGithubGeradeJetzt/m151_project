# Setup Anforderungen

  * Docker
  * Docker Compose
  * JDK >= 11

# MigrationsTool-Setup

  * Um ein bestimmtes Migrationstool zu nutzen, muss in der Datei `./src/main/resources/application.propterties` folgende Eigentschaft eingestellt sein.
    * Flyway -> `spring.flyway.enabled` auf `${ENABLE_FLYWAY:true}` stellen (Im Default schon an)
    * Liquibase -> `spring.liquibase.enabled` auf `${ENABLE_LIQUIBASE:true}` stellen (Diese wird aber keine User haben)
  
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


# Verbinden mit Postman
  * Um mit der Applikation (inklusive Datenbank)zu kommunizieren, können wir per "Postman" diese ausführen.
    * Bei der Erstausführung muss ein Login ausgeführt werden welches unter "authorization" wo diese Paramter gelten:
      * Username: Email des Benutzers
      * Passwort: Passwort....selbsterklärend
    * Diese User sind erhlätlich für folgende Rollen:
      * Rolle: Admin          Email: AderMini@gmail.com   Passwort: AdminTest
      * Rolle: Kunde          Email: KurtDieter@gmail.com Passwort: KundeTest
      * Rolle: Architekt      Email: ArchieTrek@gmail.com Passwort: AchiTest
      * Rolle: Möbelverkäufer Email: MobVern@gmail.com    Passwort: MöbelTest
    * Wenn man den User wechseln möchte, müsste man nur die angaben ändern

# Verbindungen
  * Diese Verbindungen sind verfügbar, um Aktionen zu den Tabellen zu führen:
    * localhost:6969/user/      ->  Verwaltung des Benutzers
    * localhost:6969/building/  ->  Verwaltung des Grundgebäude
    * localhost:6969/floor/     ->  Verwaltung der Etagen vom Gebäude
    * localhost:6969/room/      ->  Verwaltung der Zimmer vom Gebäude
    * localhost:6969/furniture/ ->  Verwaltung der Möbel