<div align="center">
<a href="https://www.fiap.com.br" target="_blank">
    <img src="https://www.fiap.com.br/wp-content/themes/fiap2016/images/mobile/mba/vitrine/mba-logo.png" height="100px" alt="FIAP" class="center"/>
</a>

### Webservices & Restful Technologies</h3>

[![Java11](https://img.shields.io/badge/devel-Java-brightgreen)](https://docs.oracle.com/en/java/javase/11)
[![SpringBoot](https://img.shields.io/badge/framework-SpringBoot-brightgreen)](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle)
[![Heroku](https://img.shields.io/badge/deploy-Heroku-brightgreen)](https://www.heroku.com)
[![Docker](https://img.shields.io/badge/container-Docker-brightgreen)](https://www.docker.com)
[![Maven](https://img.shields.io/badge/dependency--manager-Maven-brightgreen)](https://maven.apache.org/guides)
[![MySQL](https://img.shields.io/badge/dependency--manager-MySQL-brightgreen)](https://dev.mysql.com/doc/)
[![JUnit5](https://img.shields.io/badge/coverage-JUnit5-brightgreen)](https://junit.org/junit5/docs/current/user-guide)
[![MIT](https://img.shields.io/badge/license-MIT-brightgreen)](https://opensource.org/licenses/MIT)
</div>

## TL;DR

##### Postman Documentation: https://documenter.getpostman.com/view/18751134/UVsQsPqy
##### Github Repository: https://github.com/souluanf/place-for-pet
##### Docker Repository: https://hub.docker.com/repository/docker/souluanf/place-for-pet


## Execution
### 1 - With Docker
  ```shell
  docker run -p 8030:8030 -d --name placeforpet souluanf/placeforpet:latest
   ```
### 2 - Without docker
* 2.1 Configure Java 11:  ([download](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) & [install](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html))


* 2.2 Configure Maven:  ([download](https://maven.apache.org/download.cgi) & [install](https://maven.apache.org/install.html))


* 2.3 Download project
  ```
  $ git clone https://github.com/souluanf/placeforpet.git
  ```
* 2.4 Database configuration ([docker-compose](https://docs.docker.com/compose/)):
  ```shell
  docker-compose -f docker-compose.yml -p place-for-pet up -d 
  ```
* 2.5 Run Application
   * In the project path, open the shell console, install the dependencies and run the application:
        ```shell
        mvn clean install -Dmaven.test.skip=true
        mvn spring-boot:run
        ```

### 3 - With Dockerfile
* 3.1 gerar build do dockerfile
    ```shell
    docker build -t placeforpet .
    ```
    
* 3.2 subir container com aplicacao e fazer binding com a porta 8080
    ```shell
    docker run -d -p 8080:8080 --name placeforpet placeforpet
    ```
  
Point your web browser to [localhost:8080](http://localhost:8080)

### Developers

| Github                              | Linkedin                                      |
|-------------------------------------|-----------------------------------------------|
| https://github.com/Cjunior1976      | https://www.linkedin.com/in/cjunior1976       |
| https://github.com/souluanf         | https://www.linkedin.com/in/souluanf          |
| https://github.com/paulobof         | https://www.linkedin.com/in/paulobof          |
| https://github.com/wees-guimaraes   | https://www.linkedin.com/in/wesley-guimaraes  |