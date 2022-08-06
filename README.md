# capstone

## Configuring MySql as database
    step 1: open pom.xml and replace postgresql dependency (line no 39 to 43) with below
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
    step 2: open application.yml and update 
            spring.datasource.url: jdbc:mysql://<YOUR_HOST>:3306/<DB_NAME>
            spring.datasource.username: <YOUR_DB_USERNAME>
            spring.datasource.password: <YOUR_DB_PASSWORD>

## To run the project

    Step 1: open queries.sql and run all queries in your database
    Step 2: Open CapstoneApplication.java and run file as Java Application

## PORT
    Application port is on 8090 if you want to update go to application.yml 
    and update server.port value

## To add department
    curl -X POST \
    http://localhost:8090/capstone/addDepartment \
    -H 'cache-control: no-cache' \
    -H 'content-type: application/json' \
    -H 'postman-token: c6773aaf-9096-133b-4133-c14c78714a42' \
    -d '{
    "name": "Computer Science"
    }'

## To add Employee
    curl -X POST \
    http://localhost:8090/capstone/addEmployee \
    -H 'cache-control: no-cache' \
    -H 'content-type: application/json' \
    -H 'postman-token: 6061903e-f10f-7b71-f40c-b773dcfbc61a' \
    -d '{
    "firstName" : "Ashwin",
    "lastName" : "Gatadi",
    "gender" : "F",
    "emailId" : "ashwin.gatadi@gmail.com",
    "dateOfBirth" : "26/03/1965",
    "dateOfJoining": "18/07/2022",
    "salary" : 3000000,
    "departmentId" : 6
    }'

##To add Performance review
    curl -X POST \
    http://localhost:8090/capstone/reviewPerformance \
    -H 'cache-control: no-cache' \
    -H 'content-type: application/json' \
    -H 'postman-token: 1f205605-fd7b-fe21-a47e-b86281baa18a' \
    -d '{
    "employeeId" : 3,
    "rating" : 3
    }'

## 1 Average Salary In Each Department
    curl -X GET \
    http://localhost:8090/capstone/avgSalaryInEachDept \
    -H 'cache-control: no-cache' \
    -H 'postman-token: a65aeb7b-72a5-4a71-5ec2-11b78b4401c2'    
## 2 Average Salary In Each Department by Rating
    curl -X GET \
    http://localhost:8090/capstone/avgSalaryInEachDeptByRating \
    -H 'cache-control: no-cache' \
    -H 'postman-token: fc408baf-8d80-d290-96c1-9343aa2f47b8'    

## 3 Department with highest Number Of Employees
    curl -X GET \
    http://localhost:8090/capstone/deptWithHighestNumberOfEmployees \
    -H 'cache-control: no-cache' \
    -H 'postman-token: 8ea84403-5a8d-a689-9d33-8db4a4b818b4' 

Note: Change host and port accordingly for above end point


## NOTE
    1)   TODO are the areas which are left intentionally for your implentation and practice
    2)   Implementation for below end points 
                    1 Average Salary In Each Department
                    2 Average Salary In Each Department by Rating
                    3 Department with highest Number Of Employees
        are left upto you although quries are attahed in the code(also below) which gives you the desired output, you have write 
        the code looking into other classes

## 1 Average Salary In Each Department
    select dept_id, sum(salary)/count(*) 
    from employee
    group by dept_id;

## 2 Average Salary In Each Department by Rating
    select e.dept_id, p.rating, sum(salary)/count(*) 
    from employee e, performance p
    where e.employee_id = p.employee_id
    group by e.dept_id, p.rating;
    
## 3 Department with highest Number Of Employees
    select dept_id, count(*) 
    from employee
    group by dept_id
    order by count(*) desc
    limit 1;
    
