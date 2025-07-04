**COMPANY**: CODETECH IT SOLUTIONS

**NAME**: VARNIT JAIN

**INTERN ID**: CT04DF1140

**DOMAIN**: JAVA DEVELOPER

**DURATION**: 4 WEEKS

**MENTOR**: NEELA SANTOSH

# TASK 1
# Java File Handling Project

This project demonstrates basic file operations in Java — including writing to, reading from, and modifying text files. It showcases how to interact with files using standard Java I/O classes and is ideal for beginners learning file handling concepts.

# TASK 2
# Java Weather REST API Client

This is a simple Java application that fetches and displays current weather data using a public REST API. The project demonstrates how to make HTTP requests, parse JSON responses using Gson, and display the data in a structured format — all managed with Gradle.

## Features

- Consumes a public REST API: Open-Meteo (no API key required)
- Fetches current weather for a fixed location (Delhi)
- Parses JSON data using Gson
- Displays:
  - Temperature (°C)
  - Wind Speed (km/h)
  - Time of observation

## Technologies Used

- Java 17+
- Gradle (build tool)
- Gson library for JSON parsing
- Open-Meteo API

## Project Structure
WeatherClient/
├── build.gradle
├── settings.gradle
└── src/
└── main/
└── java/
└── WeatherClient.java


## Setup Instructions

### Prerequisites

- Java JDK 17 or higher
- Gradle installed, or use the included Gradle wrapper (`gradlew`)
- (Recommended) VS Code with Java Extension Pack

### How to Run

1. Clone or download the project.
2. Open a terminal in the project root folder (where `build.gradle` is located).
3. Run the following commands:

   ```bash
   gradle build
   gradle run
<img width="488" alt="image" src="https://github.com/user-attachments/assets/0a8411fa-259a-4fa5-819a-ffc8875d919f" />

# TASK 3
# Multithreaded Chat Application (Java Sockets + Threads)

## Project Overview

This project demonstrates a real-time client-server chat system using Java Sockets and Multithreading. It allows multiple clients to connect to a single server and communicate with each other concurrently.

## Features

- Supports multiple clients using threads  
- Real-time messaging across clients  
- Simple console-based chat UI  
- Server logs connections and disconnections  
- Broadcasts messages to all connected clients  

---

## Technologies Used

- Java (JDK 8+)
- Java Sockets (java.net)
- Multithreading (java.lang.Thread)
- I/O Streams (java.io)

---

## Project Structure

```
javaProjectIntern/
└── task3/
    ├── chatServer.java   # Server-side socket and thread logic
    └── chatClient.java   # Client-side interaction logic
```

Both files include the declaration:
```java
package task3;
```

---

## How to Run

### 1. Compile the Java Files

Open terminal in the `javaProjectIntern` directory:
```bash
javac task3/chatServer.java task3/chatClient.java
```

---

### 2. Run the Server

```bash
java task3.chatServer
```

Expected:
```
Server is running on port 1234...
```

---

### 3. Run One or More Clients (in separate terminals)

```bash
java task3.chatClient
```

Enter your name when prompted, then start chatting.

---

<img width="518" alt="image" src="https://github.com/user-attachments/assets/3f465986-2107-4e64-a8d2-a37c227e6118" />
<img width="575" alt="image" src="https://github.com/user-attachments/assets/06e87d87-08c3-471e-9071-d2c7b53bf48d" />

# TASK 4
# AI-Based Recommendation System (Java + Apache Mahout)

This project demonstrates an AI-powered recommendation system built using Java and Apache Mahout. It applies user-based collaborative filtering to recommend items based on user preferences from a dataset.

## Project Structure

```
task4/
├── data/
│   └── ratings.csv
├── src/
│   └── main/
│       └── java/
│           └── RecommendationEngine.java
├── build.gradle
├── settings.gradle
```

## Technologies Used

- Java
- Apache Mahout (v0.9)
- Gradle
- SLF4J (for logging)

## Sample Dataset

Path: `data/ratings.csv`

```
1,101,5.0
1,102,3.0
1,103,2.5
2,101,2.0
2,102,2.5
2,103,5.0
2,104,2.0
3,101,2.5
3,104,4.0
3,105,4.5
4,101,5.0
4,103,3.0
4,104,4.5
4,105,4.0
```

Format: `userID,itemID,preferenceScore`

## How to Build and Run

### 1. Navigate to the project folder:
```bash
cd task4
```

### 2. Build the project using Gradle:
```bash
gradle build
```

### 3. Run the recommendation engine:
```bash
gradle run
```

<img width="578" alt="image" src="https://github.com/user-attachments/assets/896392d7-a519-4b9f-a125-e8108b90e14a" />



