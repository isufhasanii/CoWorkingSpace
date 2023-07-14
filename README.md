# Übungsprojekt: CoWorkingSpace

CoWorkingSpace ist ein Buchungssystem für Räume in CoWorking Space, welches mit Quarkus entwickelt wird.

## Erste Schritte

1. Erstelle eine Kopie (fork) von diesem Projekt.
1. Stelle sicher, dass Docker installiert ist und läuft.
1. Stelle sicher, dass Visual Studio Code und die Erweiterung Remote Container installiert ist.
1. Klone (clone) das Projekt lokal, um damit arbeiten zu können.
1. Öffne das Projekt mit Visual Studio Code.
1. Öffne das Projekt im Entwicklungscontainer.
1. Starte das Projekt mit dem Kommando `Quarkus: Debug current Quarkus Project`
1. Probiere die Client-Applikation unter http://localhost:8080 aus.
1. Schaue die API auf http://localhost:8080/q/swagger-ui/ an.
2. Stellen Sie sicher das javax.mail.jar in der dependency drin ist, für die E-Mail-Funktion, sonst laden sie dies auf der JavaX Mail-Homepage runter.

## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Um die automatisierten Tests in einer Entwicklungsumgebung auszuführen, können Sie den folgenden Anleitungen folgen:

1. Öffnen Sie Ihre Entwicklungsumgebung (z.B. Visual Studio Code, IntelliJ IDEA, Eclipse).

2. Importieren Sie Ihr Projekt in die Entwicklungsumgebung, wenn es noch nicht importiert ist. Gehen Sie dazu zu "File" (Datei) -> "Open" (Öffnen) oder "Import" (Importieren) und wählen Sie das Verzeichnis Ihres Projekts aus.

3. Navigieren Sie in der Projektstruktur zur Testverzeichnisstruktur. Normalerweise werden die Tests in einem separaten Verzeichnis mit dem Namen "test" oder "src/test" gespeichert.

4. Suchen Sie die gewünschte Testklasse, die Sie ausführen möchten, und öffnen Sie sie.

5. Überprüfen Sie, ob die erforderlichen Abhängigkeiten und Bibliotheken in Ihrem Build-Konfigurationsdateien (z.B. pom.xml für Maven-Projekte oder build.gradle für Gradle-Projekte) korrekt konfiguriert sind.

6. Führen Sie den gewünschten Test aus, indem Sie entweder auf den "Run" (Ausführen) -Button neben der Testmethode klicken oder mit der rechten Maustaste auf die Testmethode klicken und "Run" (Ausführen) auswählen.

7. Überprüfen Sie die Testergebnisse in der Ausgabe oder im Test-Runner-Fenster. Sie sollten sehen, ob die Tests erfolgreich waren oder fehlgeschlagen sind. Zusätzlich werden detaillierte Informationen zu den einzelnen Tests und den fehlgeschlagenen Assertions angezeigt.

8. Wiederholen Sie diesen Vorgang für die anderen Tests, die Sie ausführen möchten.
