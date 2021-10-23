# Dev-Connector
Dev Connector is a portal for sharing your web projects with the world.
## Steps to Setup the Spring Boot Back end app(dev-connector backend)
1. **Clone the application**

	```bash
	git clone https://github.com/kapilnegi98/Dev-Connector.git
	cd polling-app-server

2. **Create MySQL database**

	```bash
	create database dev-connector
	```

3. **Change MySQL username and password as per your MySQL installation**

	+ open `src/main/resources/application.properties` file.

	+ change `spring.datasource.username` and `spring.datasource.password` properties as per your mysql installation

4. **Run the app**

	You can run the spring boot app by typing the following command -

	```bash
	mvn spring-boot:run
	```

	The server will start on port 8080.

	You can also package the application in the form of a `jar` file and then run it like so -

	```bash
	mvn package
	java -jar target/devconnector-0.0.1-SNAPSHOT.jar
  
  ## Steps to Setup the React Front end app (dev-connector-app-client)

First go to the `client` folder -

```bash
cd client
```

Then type the following command to install the dependencies and start the application -

```bash
npm install && npm start
```

The front-end server will start on port `3000`.
