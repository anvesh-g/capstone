CREATE TABLE department (
    dept_id int NOT NULL GENERATED ALWAYS AS IDENTITY,
    dept_name varchar(255),
    PRIMARY KEY (dept_id)
);

CREATE TABLE employee (
    employee_id int NOT NULL GENERATED ALWAYS AS IDENTITY,
    first_name varchar(255),
    last_name varchar(255),
    gender char(1),
	email_id varchar(255),
	date_of_birth date,
	date_of_joining date,
    salary int,
    dept_id int,
	PRIMARY KEY (employee_id),
	FOREIGN KEY(dept_id) REFERENCES department(dept_id)
);

CREATE TABLE performance (
    id int NOT NULL GENERATED ALWAYS AS IDENTITY,
    rating int,
    PRIMARY KEY (id),
    employee_id int,
    FOREIGN KEY(employee_id) REFERENCES employee(employee_id)
);