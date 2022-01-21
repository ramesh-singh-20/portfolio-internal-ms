# portfolio-internal-ms
This is Rest based micro service which provides CRUD functionalities for Portfolio resource.


##Docker Commands
build docker image: docker build . -t portfolio-internal-ms


run the app container: docker run -p 8085:8085 --name portfolio-internal-ms --link mysql-portfolio-container -d portfolio-internal-ms\

##Steps to run docker app in docker container
1. docker network create portfolio-internal-ms
2. docker pull --platform linux/x86_64/v8 mysql
3. docker run --name portfolio-internal-mysql-db -p3308:3306 --network portfolio-internal-ms -e MYSQL_ROOT_PASSWORD=Meshu@20 -d mysql
4. mvn clean install
5. build your docker image: docker build . -t portfolio-internal-ms
6. docker run --network portfolio-internal-ms --name portfolio-internal-ms-container -p 8085:8085 -d portfolio-internal-ms