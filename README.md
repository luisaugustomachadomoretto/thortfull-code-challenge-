# thortfull-code-challenge
 
- Thorthfull code challenge. 
- Based on George Lucas dreams :D
- This Micro Service Consumes API from Starwars (People & Films)
- 2 sample test cases to validate remote host

# Author

- Luis Augusto Machado Moretto
- malacma@gmail.com
- +351 932 160 448

# Micro Service Open API URL
 
- http://localhost:8090/swagger-ui/index.html

# Call Routes with CURL

## Call People by ID

`
curl -X 'GET' \
'http://localhost:8090/api/v1/starwars/people/1' \
-H 'accept: application/json'
`

## Call Film by ID

`
curl -X 'GET' \
'http://localhost:8090/api/v1/starwars/film/5' \
-H 'accept: application/json'
`
# Micro Service Monitoring

- Spring Boot Actuator is enabled
- Check URL -> http://localhost:9001/actuator

# How to run with Maven

- Requirements
  - Java 17
  - Maven
  - Bash

`
mvn clean package

java -jar ./target/ThortfullCodeChallenge-1.2.1-SNAPSHOT.jar
`



