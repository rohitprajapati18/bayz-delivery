Backend Engineer Assignment
In this assignment, I corrected all the functional and logical bugs in the assignment, designed and created the REST API end points and jobs to update the team.

## Tools Used :
- GIT for version control
- Gradle
- Java 8
- MySQL 5.6+
- Liquibase

## Application Constraints:
- At the time of registration the user has to choose whether he is a customer or a delivery man by mentioning "yes" or "no" at respective fields
- The delivery man commission is calculated in the delivery controller once the delivery man requests to create the delivery

## Completed Tasks:
1. Fixed logical and functional bugs in the codebase and written unit tests
2. End point to find top 3 delivery persons whose delivery has the maximum order price is at `/api/toppersons?start-time=&end-time=` here `{start-time}/{end-time}`
3. An asynchronous job is created which runs every 1min and found out all the deliveries which are not completed in 45 minutes and updates the customer team and also gives them the details of all such deliveries.

## API Endpoints

Delivery Endpoints
- POST /api/delivery     - add new delivery 
- GET api/delivery/{delivery-id}     - get delivery by id 
- GET /api/delivery/top-delivery-men  - get top three delivery men in given time

Person Endpoints
- POST /api/person        - add new person
- GET /api/person         - get all person
- GET /api/person/{person-id}  - get person by id