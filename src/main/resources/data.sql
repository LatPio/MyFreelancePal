-- Employee dataset

insert into employee (id, bankiban, banknumber, name, nip, createdat, updatedat)
values
    (100, 'PL AA BBBB CCCD 8888 7777 5555 3333', '90 8888 7777 5555 3333', 'Reafał', '123-456-7890', '2020-02-19 11:47:57.000000', '2021-06-19 14:47:57.000000'),
    (200, 'PL AA BBBB CCCD 1111 2222 3333 4444', '99 1111 2222 3333 4444', 'Piotrek', '344-443-3333', '2020-01-19 10:29:27.000000', '2021-06-19 14:47:57.000000');


-- Employer dataset

insert into employer (id, createdat, email, name, nip, phone, updatedat, active)
VALUES
    (100, '2021-01-25 04:30:17.000000', '123@aa.com', 'Google', '12-1111-1234','14-12301222', '2021-06-19 14:47:57.000000', true),
    (200, '2021-03-19 19:40:40.000000', '345@bb.com', 'Franek Kolega', '12-2222-1234','12-12301222', '2021-06-19 14:47:57.000000', true),
    (300, '2021-05-10 13:07:12.000000', '456@ccc.com', 'UJ', '12-4444-1234','19-12301222', '2021-06-19 14:47:57.000000', true),
    (400, '2021-10-02 23:12:38.000000', '5678@dddd.com', 'Amazon', '12-8888-1234','12-12301222', '2021-06-19 14:47:57.000000', true);

-- Projekty

insert into project (id, color, createdat, name, updatedat, employer_id, activeproject, hourpricedefault)
VALUES
    (100, 'red', '2021-05-10 13:07:12.000000', 'Projekt - JAVA test',  '2021-06-19 14:47:57.000000', 100, true, 23),
    (200, 'blue', '2021-05-10 13:07:12.000000', 'Projekt - Angular test',  '2021-06-19 14:47:57.000000', 100, true,43),
    (300, 'green', '2021-05-10 13:07:12.000000', 'Projekt - Python test',  '2021-06-19 14:47:57.000000', 200, true, 21),
    (400, 'purple', '2021-05-10 13:07:12.000000', 'SQL dla JAVA-site',  '2021-06-19 14:47:57.000000', 300, true, 44),
    (500, 'grey', '2021-05-10 13:07:12.000000', 'SQL Python',  '2021-06-19 14:47:57.000000', 200, true, 56),
    (600, 'yellow', '2021-05-10 13:07:12.000000', 'SQL test',  '2021-06-19 14:47:57.000000', 100, false, 10),
    (700, 'red', '2021-05-10 13:07:12.000000', 'JAVA test',  '2021-06-19 14:47:57.000000', 300, false, 100),
    (800, 'red', '2021-05-10 13:07:12.000000', 'Python',  '2021-06-19 14:47:57.000000', 400, false,132),
    (900, 'red', '2021-05-10 13:07:12.000000', 'Angular',  '2021-06-19 14:47:57.000000', 400, false, 78),
    (1000, 'red', '2021-05-10 13:07:12.000000', 'Site FullStack-AngularSpringBOOT',  '2021-06-19 14:47:57.000000', 300, false, 99);

--  tasks

insert into task (id, createdat, dateend, datestart, invoicecreated, name, timeOfWorkInMin, timeofinvoicecreation, updatedat, project_id, hourprice)
VALUES
    (100, '2021-05-10 13:07:12.000000', '2021-05-10 14:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 55, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 100, 23.00),
    (200, '2021-05-10 13:07:12.000000', '2021-05-10 15:07:12.000000', '2021-05-10 14:07:12.000000', false, 'Zadanie 1', 10, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 200, 23.00),
    (300, '2021-05-10 13:07:12.000000', '2021-05-10 16:07:12.000000', '2021-05-10 15:07:12.000000', false, 'Zadanie 1', 20, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 300, 223.00),
    (400, '2021-05-10 13:07:12.000000', '2021-05-10 17:07:12.000000', '2021-05-10 16:07:12.000000', false, 'Zadanie 1', 45, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 400, 25.00),
    (500, '2021-05-10 13:07:12.000000', '2021-05-10 18:07:12.000000', '2021-05-10 17:07:12.000000', false, 'Zadanie 1', 123, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 500, 2.00),
    (600, '2021-05-10 13:07:12.000000', '2021-05-10 19:07:12.000000', '2021-05-10 18:07:12.000000', false, 'Zadanie 1', 123, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 600, 53.00),
    (700, '2021-05-10 13:07:12.000000', '2021-05-10 20:07:12.000000', '2021-05-10 19:07:12.000000', false, 'Zadanie 1', 79, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 700, 83.00),
    (800, '2021-05-10 13:07:12.000000', '2021-05-10 21:07:12.000000', '2021-05-10 20:07:12.000000', false, 'Zadanie 1', 180, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 800, 24.00),
    (900, '2021-05-10 13:07:12.000000', '2021-05-10 21:57:12.000000', '2021-05-10 21:07:12.000000', false, 'Zadanie 1', 122, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 900, 12.00),
    (1000, '2021-05-10 13:07:12.000000', '2021-05-10 22:47:12.000000', '2021-05-10 22:07:12.000000', false, 'Zadanie 1', 345, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 1000, 78.00),
    (1100, '2021-05-10 13:07:12.000000', '2021-05-10 23:27:12.000000', '2021-05-10 23:07:12.000000', false, 'Zadanie 2', 55, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 100, 40.00);



-- adresses

insert into address (id, buildingnumber, city, country, createdat, flatnumber, name, postalcode, street, updatedat, employer_id)
VALUES
    (100, 24,'Kraków','Polska','2021-05-10 13:07:12.000000', 12, 'domowy', '30-398', 'Narutowicza', '2021-05-10 13:07:12.000000', 100),
    (200, 46,'Bydgoszcz','Polska','2021-05-10 13:07:12.000000', 15, 'Firmowy', '30-398', 'Krakowska', '2021-05-10 13:07:12.000000', 200),
    (300, 21,'Tarnów','Polska','2021-05-10 13:07:12.000000', 1, 'domowy', '30-398', 'Lwowska', '2021-05-10 13:07:12.000000', 300),
    (400, 53,'Warszawa','Polska','2021-05-10 13:07:12.000000', 5, 'Firmowy', '30-398', 'Kondratowicza', '2021-05-10 13:07:12.000000', 100),
    (500, 2,'Gdańsk','Polska','2021-05-10 13:07:12.000000', 88, 'Mój', '30-398', 'Midowa', '2021-05-10 13:07:12.000000', 400),
    (600, 12,'Toruń','Polska','2021-05-10 13:07:12.000000', 1, 'Mój drugi', '30-398', 'Gronostajowa', '2021-05-10 13:07:12.000000',100),
    (700, 11,'Kołobrzeg','Polska','2021-05-10 13:07:12.000000', 33, 'domowy', '30-398', 'Gołębia', '2021-05-10 13:07:12.000000', 200);

insert into address (id, buildingnumber, city, country, createdat, flatnumber, name, postalcode, street, updatedat, employee_id)
VALUES
    (800, 24,'Kraków','Polska','2021-05-10 13:07:12.000000', 12, 'domowy', '30-398', 'Narutowicza', '2021-05-10 13:07:12.000000', 100),
    (900, 46,'Bydgoszcz','Polska','2021-05-10 13:07:12.000000', 15, 'Firmowy', '30-398', 'Krakowska', '2021-05-10 13:07:12.000000', 200),
    (1000, 21,'Tarnów','Polska','2021-05-10 13:07:12.000000', 1, 'domowy', '30-398', 'Lwowska', '2021-05-10 13:07:12.000000', 100),
    (1100, 53,'Warszawa','Polska','2021-05-10 13:07:12.000000', 5, 'Firmowy', '30-398', 'Kondratowicza', '2021-05-10 13:07:12.000000', 100),
    (1200, 2,'Gdańsk','Polska','2021-05-10 13:07:12.000000', 88, 'Mój', '30-398', 'Midowa', '2021-05-10 13:07:12.000000', 200),
    (1300, 12,'Toruń','Polska','2021-05-10 13:07:12.000000', 1, 'Mój drugi', '30-398', 'Gronostajowa', '2021-05-10 13:07:12.000000',100),
    (1400, 11,'Kołobrzeg','Polska','2021-05-10 13:07:12.000000', 33, 'domowy', '30-398', 'Gołębia', '2021-05-10 13:07:12.000000', 100);

-- invoices
insert into invoice(id, createdat, invoicecreationdate, paydue, pricenet, seconddate, updatedat, vat, employee_id, employer_id)
VALUES (100, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 23,'2021-05-10 13:07:12.000000','2021-05-10 13:07:12.000000',23,100,100);

---- Maps
-- empolyee_address_map
-- insert into employee_address_map(address_id, employee_id) VALUES (100,100);
-- insert into employee_address_map(address_id, employee_id) VALUES (300,200);
-- empolyer_address_map
-- insert into employer_address_map(address_id, employer_id) VALUES (200,100);
-- insert into employer_address_map(address_id, employer_id) VALUES (400,200);
-- insert into employer_address_map(address_id, employer_id)VALUES (500,300);
-- insert into employer_address_map(address_id, employer_id) VALUES (600,400);
--employee-employer-map
-- insert into employer_employee_map(employer_id, employee_id) VALUES (100,100);
-- insert into employer_employee_map(employer_id, employee_id) VALUES (200,200);
-- insert into employer_employee_map(employer_id, employee_id) VALUES (300,200);
-- insert into employer_employee_map(employer_id, employee_id) VALUES (400,200);

