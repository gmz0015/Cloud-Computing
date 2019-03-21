# Cloud Computing
The sharing place for team 06.

## H-Drive
### Mount H-Drive
`$ sshfs <user-name>@stulogin.dcs.shef.ac.uk: ~/dcshome`

## OpenNebula
### Login to VM
`$ ssh -i cloudkey root@143.167.9.209`
### Uploading to VM
`$ scp -i cloudkey <source-path> root@143.167.9.209:<destination-path>`

## Deploy
- Copy the folder to `/var/lib/tomcat8/webapps/`

## Done
- Using ajax and servlet to change div.
- Add navigating between the home page and account page.
- Use JSON to pass value from back-end to front-end. The dependencies have listed below.
    - commons-beanutils-1.9.3.jar
    - ccommons-collections-3.2.2.jar
    - commons-lang-2.6.jar
    - commons-logging-1.2.jar
    - ezmorph-1.0.6.jar
    - json-lib-2.4-jdk15.jar

## TODO
- Optimise navigating speed.
- Develop specific functions for account.
- Figure out how to use Java Beans.
- Figure out about XML.