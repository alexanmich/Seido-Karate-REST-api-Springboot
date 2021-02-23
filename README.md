# Seido-Karate-REST-api-Springboot

## Introduction
Seido Karate Kata Training is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). It is running java 15 and uses Thymeleaf dependencies for server-side rendering. The application allows users to view all katas under Seido Karate (which  they can view by grade) and pick random katas to practice to avoid only training your best/favourites.

## Running Seido Karate Kata Training

You can then access Seido Karate Kata Training here: http://localhost:8080/

<img width="1042" alt="welcome-screenshot" src="images/welcome.png">

## Working with Seido Karate REST api in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 15.
* git command line tool
* Your preferred IDE 

### Steps:

1) Clone this repo in command line

```
git clone https://github.com/alexanmich/Seido-Karate-REST-api-Springboot.git
```
   
2) Import project from files 
    ```
    File -> Open -> cloned project
    ```
3) Run KataApplication.jar

4) Navigate to Seido Karate Kata Training

    Visit [http://localhost:8080](http://localhost:8080) in your browser.

## Endpoints
1) /all
2) /all/{grade}

<img width="1042" alt="all-screenshot" src="images/all.png">

3) /random
4) /random/{grade}

<img width="1042" alt="random-screenshot" src="images/random.png">
