# Cloud Computing
The sharing place for team 06.

## H-Drive
### Mount H-Drive
`$ sshfs <userController-name>@stulogin.dcs.shef.ac.uk: ~/dcshome`

## OpenNebula
### Login to VM
`$ ssh -i cloudkey root@143.167.9.209`
### Uploading to VM
- `$ scp -i cloudkey <source-path> root@143.167.9.209:<destination-path>`
- `$ scp -i cloudkey -r platform/web root@143.167.9.209:/var/lib/tomcat8/webapps/platform`

## Deploy
- Copy the folder to `/var/lib/tomcat8/webapps/`
- Environemnt Switch List:
    - team06.platform.web.bean.AdminBean
    - team06.platform.web.controller.ManagerServlet
    - context.xml
    - login.login

## TODO
- Optimise 
    - Navigating Speed up
- Account
    - ~~Develop specific functions for account.~~ (Finish)
    - Add ~~Authentication~~ (Finish) and Authorisation
    - Consider the rating level associated with peanut. So that they can even earn peanuts.
    - Consider the number of visits associated with peanut
- Rating System
    - Add Rating System
- Java Beans
    - ~~Figure out how to use Java Beans.~~ (Finish)
- Log System
    - Add Log4j
- Application
    - ~~Set javabean item clickable~~ (Finish)
    - ~~Add Application~~ (Finish)
        - Optimize
    - ~~Associated with database~~ (Finish)
        - Optimize
    - Security Check
- Guide
    - Add Guide
- Admin
    - ~~View All applications, databases, users~~ (Finish)
    - Add Usage
    - Add function to add, edit and delete.
- Status
    - Change Status
- Figure out about XML.(Low Priority)

## Done
- ~~Tomcat Realm~~ (Finish)
- ~~Using ajax and servlet to change div.~~ (Discard)
- Add navigating between the home page and account page.
- Use JSON to pass value from back-end to front-end. The dependencies have listed below.
    - commons-beanutils-1.9.3.jar
    - ccommons-collections-3.2.2.jar
    - commons-lang-2.6.jar
    - commons-logging-1.2.jar
    - ezmorph-1.0.6.jar
    - json-lib-2.4-jdk15.jar
- MVC Mode
    - Domain Layer
        - contain Java Bean
        - getter and setter
    - Dao Layer
        - The interface of database
    - Service Layer
        - Business
    - Web Layer
        - UI
            - Provide pages
        - controller
            - Business logic
        - bean
            - Store data before commit to database