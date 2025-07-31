# RecipeManager — GUI + Console (Optional Login)

This project provides both a **JavaFX GUI** and a **Console** interface for managing recipes stored locally in `recipes.json`. It supports:

- Add / View / Delete recipes
- Export **CSV** and **PDF**
- **Optional Login** (local `users.json`), with **Skip Login**
- Unit tests for controller and storage

## Requirements
- JDK 17 (or newer)
- Maven 3.9+

## Build & Test
```bash
mvn clean test
mvn -q -DskipTests package
```

## Run — GUI (JavaFX)
```bash
mvn javafx:run
```
> The GUI starts at **Login**. Use **Register** to create a user or **Skip Login**.

## Run — Console
```bash
java -jar target/RecipeManager-Console.jar
```

### Data files
- `recipes.json` — recipes database
- `users.json` — credentials (username + SHA-256 hash)

> Files are created in the working directory the first time the app runs.

## Notes
- PDF export uses OpenPDF (LibrePDF).
- CSV export is plain text with `|` used inside array fields.
