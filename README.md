# portfolio-internal-ms
This is Rest based micro service which provides CRUD functionalities for Portfolio resource.


##Dcoker Commands
build docker image: docker build . -t portfolio-internal-ms


run the app container: docker run -p 8085:8085 --name portfolio-internal-ms --link mysql-portfolio-container -d portfolio-internal-ms\