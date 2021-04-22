# Animal adoption portal: API

To start contributing, clone this project into your local directory and open with IntelliJ Idea.

Use 'git clone' to clone the project.

## IMPORTANT POINTS TO NOTE

`DO NOT PUSH THE CODE DIRECTLY ON THE MASTER BRANCH.`

Create a separate branch. Make all your changes there and raise a pull request with that branch. Your PR will be merged after the review.

### Useful commands

`./gradlew test` to run all the tests

`./gradlew bootrun` to run the app on local server

`./gradlew update` to run the database migration scripts

### Database setup

We are using mysql for the database & MySql Workbench for testing & performing database operations.

Make sure that you have mysql & workbench(optional) installed.

Installing mysql server:
https://dev.mysql.com/downloads/mysql/

Installing Workbench:
https://dev.mysql.com/downloads/workbench/

Mysql cheatsheet:
https://gist.github.com/bradtraversy/c831baaad44343cc945e76c2e30927b3

Steps to set up the database for running animalRequest-peers api:

1. Log in to mysql as a root user: `mysql -u root -p`
2. Create a user by the name 'animalpeers' & password 'animalpeers' in mysql: 
`CREATE USER 'animalpeers'@'localhost' IDENTIFIED BY 'animalpeers';`
3. Grant all permissions to this user:
`GRANT ALL PRIVILEGES ON * . * TO 'animalpeers'@'localhost';`
4. You can optionally create a new connection in Workbench with the same username & password.
5. Run database migration command:`./gradlew update` 

