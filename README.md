# webtechproject - backend

### Informationen

**Student**: Jascha Steudler

**Matrikelnummer**: 588282

**Lehrkraft**: Prof. Dr. Arif Wider & Prof. Dr.-Ing. Alexander Stanik

**Semester**: 5. Semester, Hochschule für Technik und Wirtschaft Berlin

### Über das Projekt

Gebaut wurde eine Trainingsplan Anwendung. 

Zugehöriges Frontend: https://github.com/jsSteud/webtech-frontend

## How to Log In / Sign up unter ``/login``

1. Registrieren

   **oder**
2. Als Alternative gibt es einen Testuser -> bitte bei mir anfragen

    

## How to use the application

Es gibt 3 Pfade:
1. ``/plan``
   2. Plan
   3. Übungen zum Plan hinzügen
   4. Übungen aus Plan entfernen
2. ``/exercises``
   3. Übungen bearbeiten
      4. Name, Kommentar, Sets, Gewichte etc....
   5. Übungen löschen
3. ``/createnew``
   4. Neue Übung erstellen

Alle sind über die NavBar zu erreichen.

## Allgemeine Hinweise

Die erstellten Übungen sind nur im entsprechenden Account zugänglich.

Der LogIn ist nur über einen (1!) Browser zugängig.


## Technische Hinweise 

Der Login wird über einen Session-Token realisiert, welcher gehasht in der Datenbank liegt. Der Token wird nach erfolgreicher Eingabe
von ``username`` und ``password`` serverseitig generiert und an den Client zurückgegeben. Findet von einem anderen Browser ein Login mit korrekten Credentials
statt, wird ein neuer Token generiert: der alte verfällt und wird ungültig.

``username`` und ``password``werden gehasht in der Datenbank gespeichert.
