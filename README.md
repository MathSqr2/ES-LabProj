# ES-LabProj - Group L26 

#### Authors

1. **Afonso Guimarães (86012)** - afonso.guima@ua.pt  
2. **Vasco Cardoso (86067)** - vasco.cardoso16@ua.pt

#### Instructions
To run the project the first step is to start the services by running the *docker-compose.yaml*:
```
    docker-compose up -d
```
If everything went well we are ready to run the application by doing:
  
```
    mvn spring-boot:run
```

Have in consideration that the ports used for the different microservices are:
1. **Port 9500** - for access to the Springboot application (127.0.0.1:9500/);
2. **Port 3306** - for the database to run;
3. **Port 9092** - for the kafka service. 
   

With everything set and done just follow the [link](127.0.0.1:9500/) in your browser to open it.



