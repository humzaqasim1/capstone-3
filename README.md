# Capstone 3 – EasyShop - Humza Qasim

This project contains a Java Spring Boot backend and a static HTML/CSS/JavaScript frontend.

---

## Requirements

* **Java Development Kit (JDK) 17**
* **IntelliJ IDEA Community Edition** (latest)
* **MySQL Server** (e.g., MySQL 8.x)
* **MySQL Workbench** (to run the database script)
* Internet browser (Chrome, Firefox, Edge, Safari, etc.)


---

## Project Description

This project contains a digital storefront for EasyShop; a store that sells clothing, electronics, and home/cooking wares. 
Code was provided for most of the backend of this project, though adjustments, additions, and bug fixes were made by me.
I fixed the category function of the program as well as solved bugs involving the search feature and accidental product duplication.
I had hoped to create a functional shopping cart feature but struggled to finish coding it in time.
---

## Application Screen Images
![CapstoneScreenshot1](https://github.com/user-attachments/assets/6dc13e9b-1be0-4226-94c0-c3e3edf23e60)
![CapstoneScreenshot2](https://github.com/user-attachments/assets/962df57d-5322-4cd0-b82d-4580a12374c2)
![CapstoneScreenshot3](https://github.com/user-attachments/assets/49c59486-de42-43d7-8d80-65845f53589e)

---

## How to run the backend

1. In IntelliJ, make sure the project is fully indexed and Maven dependencies have been downloaded (you may see a progress bar at the bottom).
2. In the **Run configuration** dropdown (top-right of IntelliJ), choose:

   **`Backend (Spring Boot)`**

   (If it doesn’t exist, you can run the main class manually by right-clicking the `EasyshopApplication` class in `backend-api` and choosing **Run**.)
3. Click the green **Run** triangle.
4. The Spring Boot application will start and listen on:

   ```text
   http://localhost:8080
   ```

Check the Run tool window for any startup errors (for example, database connection problems). If there are errors, double-check your MySQL setup and `application.properties` values.

---

## How to run the frontend

1. In IntelliJ’s **Project** view, navigate to:

   ```text
   frontend-ui/index.html
   ```

2. Right-click `index.html` → **Open in Browser** → choose your browser.

3. Alternatively, you can locate `frontend-ui/index.html` in Finder / File Explorer and double-click it to open it in a browser.

---

## Where to make changes

* **Backend logic** (controllers, models, data access, etc.) is in:

  ```text
  backend-api/src/main/java/
  ```

* **Backend configuration** (including database settings) is in:

  ```text
  backend-api/src/main/resources/
  ```

* **Frontend HTML/CSS/JS** is in the `frontend-ui` folder:

  ```text
  frontend-ui/index.html
  frontend-ui/css/
  frontend-ui/js/
  frontend-ui/images/
  ```
