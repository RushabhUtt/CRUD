FROM openjdk:11-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} EmployeeCRUD-0.0.1-SNAPSHOT.jar
EXPOSE 6521
ENTRYPOINT ["java","-jar","EmployeeCRUD-0.0.1-SNAPSHOT.jar"]