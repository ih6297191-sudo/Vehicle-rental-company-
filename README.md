# Vehicle Rental Company

A Java Swing desktop application for managing vehicle rental accounts.

## Requirements

- Java Development Kit (JDK) 8 or newer
- VS Code with the Extension Pack for Java, or any Java IDE

Check that Java is installed:

```powershell
java -version
javac -version
```

## Run from VS Code

1. Open this project folder in VS Code.
2. Open `Main.java`.
3. Click the Run button above the `main` method.

Run the application from the project root so that the `images` and `Data_all` folders are found correctly.

## Run from PowerShell

Open PowerShell in the project root and compile the source files:

```powershell
New-Item -ItemType Directory -Force out
javac -d out Main.java Entities\Account.java Frames\*.java
```

Start the application:

```powershell
java -cp out Main
```

## Run from Command Prompt

```bat
mkdir out
javac -d out Main.java Entities\Account.java Frames\*.java
java -cp out Main
```

## Features

- User registration and login
- Duplicate username checking
- Vehicle selection during registration
- Profile information display
- Logout functionality

## Project Structure

```text
Main.java              Application entry point
Entities/Account.java  Account and file-storage logic
Frames/                Login, registration, and homepage windows
Data_all/Data.txt      Saved account data
images/                Application images
```

## Data Storage

Account data is stored locally in `Data_all/Data.txt`. This is a desktop demo application, so passwords are currently stored as plain text. Do not use real personal passwords.
