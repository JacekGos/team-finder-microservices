<h1 align="center">Team Finder - microservices</h1>

<h2 align="left">General info</h2>

This is the backend part of Team-Finder based on microservices architecture. </br>
User Interface created by using React and Bootstrap:
https://github.com/JacekGos/team-finder-ui-v2

A web application, the purpose of which is to search for sports events in the area<br>
and to create teams in various sports disciplines.<br>

Getting information about the location of places is carried out by using google maps geocoding api.

<h3 align="left">Basic features:</h3>

- [x] Searching for games, e.g. based on the given address and sport dyscipline, which are shown on the map
- [x] Advanced game search filter, based on detailed game parameters, such as sport discipline,<br>
  range from given address, price, date, number of players, duration
- [ ] Creating a user account for more advanced features
- [ ] Creating new games using venue reservation system
- [ ] Joining existing games

<h3 align="left">Application architecture:</h3>

- <a href="https://github.com/JacekGos/team-finder-microservices/tree/main/api-gateway">Api Gateway </a>
- <a href="https://github.com/JacekGos/team-finder-microservices/tree/main/discovery-server">Discovery Server </a> - Eureka Server
- <a href="https://github.com/JacekGos/team-finder-microservices/tree/main/event-core-service">Event Core Service </a> - Base service for receiving and updating events
- <a href="https://github.com/JacekGos/team-finder-microservices/tree/main/event-serivce">Event Service </a> - Service to store data about events
- <a href="https://github.com/JacekGos/team-finder-microservices/tree/main/notification-service">Notification Service </a> - Service to notificate users about events
- <a href="https://github.com/JacekGos/team-finder-microservices/tree/main/user-chat-service">User Chat Service </a> - Service to websocket communication between users
- <a href="https://github.com/JacekGos/team-finder-microservices/tree/main/user-service">User Service </a> - Service to store data about users
- <a href="https://github.com/JacekGos/team-finder-microservices/tree/main/venue-service">Venue Service </a> - Service to store data about venues

![team-finder](https://github.com/JacekGos/team-finder-microservices/assets/46130249/0bc48845-1593-499b-8a4f-af712905b8c0)


<h3 align="left">Technologies:</h3>

- Java 17
- Spring Boot 2.7
- Spring Cloud
- Spring Security 5
- Spring Data JPA
- Hibernate 5
- PostgreSQL 14
- JUnit 5
- Mockito 3.9
- Google Maps Geocoding API
- Docker
- Keycloak



