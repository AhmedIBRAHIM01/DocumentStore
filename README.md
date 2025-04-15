README – Java RMI Document Store

Projektübersicht

Dieses Projekt implementiert einen einfachen Dokumentenspeicher (DocumentStore) mit Java RMI. Benutzer können Dokumente erstellen und abrufen. Dokumente werden als serialisierte Java-Objekte zwischen Client und Server übertragen. Der Server speichert die Dokumente im Arbeitsspeicher (nicht persistent).

Dokumentstruktur

Ein Dokument besteht aus folgenden Attributen:
- ID (automatisch vergeben)
- Erstellungsdatum (automatisch vergeben)
- Titel
- Liste der Autoren
- Inhalt (Text)
Startanleitung
1. Kompilieren aller Java-Dateien:
   javac *.java
2. Starten der RMI-Registry:
   rmiregistry
3. Starten des Servers:
   java org.example.DocumentSotoreServer
4. Starten des Clients (in neuem Terminal):
   java org.example.DocumentStorClient
 Clientfunktionen
   Beim Start zeigt der Client ein Menü mit folgenden Optionen:
   1: Ein neues Dokument erstellen
   2: Ein Dokument anhand der ID abrufen
   3: Nach Dokumenten anhand des Titels suchen
   4: Beenden
 Beispiel-Session

   Client 1:
   
   1: to create a new Document.
   
   Title: learn how to live
   
   Authors: Ahmed, Omar
   
   Content: hello I am the new author
   
   → Dokument wird mit ID 1 erstellt
   

Client 2:

2: to retrieve Document by ID
Enter ID: 1

→ Dokumentdetails werden korrekt angezeigt

Hinweise
- Die Dokumente sind nur während der Laufzeit im Speicher.
- Es können beliebig viele Clients gleichzeitig verwendet werden.
- Die Verbindung erfolgt über RMI-Registry auf Port 1099.

Voraussetzungen
- Java JDK 8 oder höher
- RMI aktiviert (kein spezieller Framework erforderlich)
