# Web-Based Note-Taking Application "FastNotes" by Razzolini Khiara.

This project is a simple but functional **web-based note-taking application**, developed from scratch for a technical interview challenge with the current knowledge that I have. It supports user login, creation of styled notes, archiving, search functionality, and a modern UI experience.

---

## 🚀 Technologies Used

- **Java EE** (Jakarta EE)
  - JSF (JavaServer Faces)
  - JPA (Java Persistence API)
- **MySQL** (as relational database)
- **GlassFish** Server (v7)
- **NetBeans IDE** (development and deployment)
- **HTML / CSS / JavaScript**
  - Uses a `div[contenteditable]` editor for rich-text formatting
- **Git** (version control)

---

## 🧠 Features

- ✅ User authentication (login)
- ✅ Note creation with **rich-text support** (bold, italic, underline, size)
- ✅ Responsive UI and card-style display
- ✅ Search bar to filter notes by title
- ✅ Archive / unarchive notes
- ✅ Modal preview of note content
- ✅ Visual styling with random colors on notes

---

## ⚙️ Setup Instructions

### 1. Database Configuration

- You must have **MySQL** installed and running.
- Create a database named (for example):  
  ```sql
  CREATE DATABASE notesdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

### 2. MySQL JDBC Driver
Install the MySQL JDBC driver (Connector/J):

Download from: https://dev.mysql.com/downloads/connector/j/

Add the .jar to your project libraries.

Or configure it in GlassFish:
Admin Console > Resources > JDBC > JDBC Drivers

### 3. GlassFish Deployment
Deploy the project on GlassFish Server (v5+).

Add a JDBC resource (e.g. jdbc/notes) matching the one defined in your persistence.xml (if applicable).

### 4. Login
🔐 User-Specific Data
Each user has access only to their own notes.

Notes are linked to users via a foreign key (user_id) in the database.

Session management ensures data isolation.
- USER: kikiwi
- PASSWORD: ensolvers
- The project could handle more users if an "user" table is created on the DB. Still, even if you logout, the notes remain there.


![image](https://github.com/user-attachments/assets/952ccf57-a1f4-4c40-ab81-b56e3238b05c)
## --Login page
![image](https://github.com/user-attachments/assets/c77ee20b-5ff4-487a-b213-3ac22368a35e)
## --Dashboard view: Shows the logged-in user's active notes with options to search, create, edit, delete, or archive notes. Includes real-time note count and access to archived notes. All actions are user-specific.
![image](https://github.com/user-attachments/assets/c67c6817-a7bb-4f60-925c-722709e22000)
## --Note preview
![image](https://github.com/user-attachments/assets/4a8fdd8b-f600-425a-9008-db01f6409551)
## --Note edit/creation
![image](https://github.com/user-attachments/assets/8b412b2e-af48-454c-8358-5b93884e14eb)
## --Search a note title
![image](https://github.com/user-attachments/assets/b6f7d598-76ac-4d6b-8e89-5925ae8d0ae9)
## --Archived notes

📄 License:

This project was developed for an interview challenge. Please do not reuse or redistribute without permission.
