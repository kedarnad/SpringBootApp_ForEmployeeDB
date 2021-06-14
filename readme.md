

# How to run the application?
1.  cd into the 'SpringApplication' and run './gradlew bootRun'
2.  now go into the 'TestCases' folder from the parent directory and run 'python TestAPI.py' this will run all  the testcases required for all the endpoints. 

# Requirements:
1. Install gradle Spring Dependences from spring initializer.
2. this Application requires Java 8
3. install python json and request packages for running the TestCases.

# API endpoints:
1. TASK1 : reporting structure endpoint : http://localhost:8080/reportingStruct/{id}
2. TASK2 : Compensation read endpoint : http://localhost:8080/compensation/read/{id}
3. TASK2 : Compensation create endpoint : http://localhost:8080/compensation/create
