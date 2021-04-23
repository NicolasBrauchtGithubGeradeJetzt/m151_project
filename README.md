# m151_project

## Projekt-Beschrieb "Gebäude-Konstruktion"

PDF-Version erhältich unter -> /Dokumentation/M151_Projektbeschrieb_NicolasAlex_Kingsman

### Beschreibung

Das Projekt wird eine Applikation herstellen, wo man via Backend ein Gebäude konstruieren kann und diese in der eigenen internen Datenbank gespeichert wird.
\
Mit dem Gebäude kann man die einzelnen Etagen, Räume und die Möbel innen verwalten.
Zu dem kann man einen Besitzer einem Gebäude zuweisen.
\
Zu allen benötigten Daten in der Datenbank soll man die Möglichkeit haben via REST API diese zu verwalten (Hinzufügen/Aktualisieren/Entfernen) und anzuschauen.

### Personengruppen

|Benutzerrolle: |Beschreibung:  |
--- | --- |
|Admin (Administrator) |Der Admin hat die Gesamtkontrolle über die Applikation und kann dementsprechend alle Funktionen anwenden. |
|Kunde |Kunde haben das Recht alle gespeicherten Daten ansehen zu dürfen, Ausnahmen sind Personen-Bedingte Daten (wie vom Besitzer)  und sie dürfen keine Änderungen bei den Daten durchführen. |
|Architekt |Architekten besitzen die Rechte Daten rund um das Gebäude und die Platzierungen der Möbel verwalten zu dürfen. <br />Aber Ihnen wird verweigert Daten zu Möbel ändern zu können. <br />Sie haben dennoch Zugriff zum Anschauen aller Daten. |
|Möbelverkäufer |Möbelverkäufer besitzen einzig nur das Recht Daten rund um „Möbel“ verwalten zu dürfen und anzuschauen. Zu restlichen Daten wird diese blockiert. |

### User-Stories

Für diese Applikation sollen folgende Funktionen zur Verfügung sein (diese via REST API anzusteuern sind):
\
Login:

* __Als__ Admin /Kunde /Architekt /Möbelverkäufer __möchte ich__ einloggen __damit ich__ bestimmte Rechte für Funktionen zu erhalten.
* __Als__ Admin /Kunde /Architekt /Möbelverkäufer __möchte ich__ ausloggen __damit ich__ als anderen Benutzer danach einloggen kann.

Besitzer:

* __Als__ Admin __möchte ich__ einen neuen Besitzer hinzufügen __damit ich__ diese später einem Gebäude zuweisen kann.
* __Als__ Admin __möchte ich__ einen Besitzer verwalten __damit ich__ diesen aktualisiere oder/und entfernen kann.
* __Als__ Admin/Architekt __möchte ich__ die Daten eines Besitzers aufrufen können __damit ich__ diese mit der Zuweisung verwenden kann.

Gebäude:

* __Als__ Admin/Architekt __möchte ich__ ein neues Gebäude erstellen __damit__ daraus ein Gebäude-Konstruktion erstellt werden kann.
* __Als__ Admin/Architekt __möchte ich__ eine neue Etage und Zimmer dem Gebäude zuweisen __damit ich__ die Konstruktion verfeinern kann.
* __Als__ Admin/Architekt __möchte ich__ das Gebäude verwalten __damit ich__ diese Aktualisieren und/oder verwalten kann (inklusive die Etagen und Zimmer)
* __Als__ Admin/Kunde/Architekt __möchte ich__ alle Daten zum Gebäude mit den Etagen und Zimmer aufrufen __damit ich__ die Konstruktion vom Gebäude vor mir sehe.

Möbel:

* __Als__ Admin/Möbelverkäufer __möchte ich__ neue Möbelstücke hinzufügen __damit ich__ diese für die Gebäuden zur Verfügung stelle.
* __Als__ Admin/Architekt __möchte ich__ die Möbelstücke in einem bestimmten Raum zufügen __damit__ es in der Konstruktion registriert wird.
* __Als__ Admin/Kunde/Architekt __möchte ich__ alle Möbelstücke in einem Raum sehen können __damit ich__ weiss, welche Möbelstücke im Raum ist.

### Technologien

Für die Applikation werden folgende Technologien verwendet:

|Name: |Beschreibung:  |
--- | --- |
|Docker |Eine Engine, das einzelne Containers mit Applikationen und Konfigurationen verwaltet und hosted. |
|Docker-Compose |Mit einer „.yml“-Datei lässt sich durch die Applikation ein neues „Image“ erstellen, woraus man dann ein Container laufen lassen kann. |
|Spring |Ein Framework für Java-Plattformen. (Speziell geeignet für Web-Anwendungen) |
|Java |Die Programmiersprache, welches für das Backend geschrieben wird. |
|PostreSql |Die Datenbank für die Applikation. Alle Anfragen werden als Transaktionen angenommen. |
|Postman |Eine Applikation, die API-Abfragen verschicken kann und zum Testen der API vom Backend dient. |
|Github |Webseite, wo der ganze Code/Projekt gelagert wird und daraus heruntergeladen werden. |
