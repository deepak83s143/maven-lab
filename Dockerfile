FROM tomcat
Maintainer "Deepak Sharma"
COPY target/addressbook.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]
EXPOSE 8080
