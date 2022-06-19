-- Employee dataset

insert into employee (id, bankiban, banknumber, name, nip, createdat, updatedat)
values (1, 'PL AA BBBB CCCD 8888 7777 5555 3333', '90 8888 7777 5555 3333', 'Reafał', '123-456-7890', '2020-02-19 11:47:57.000000', '2021-06-19 14:47:57.000000');

insert into employee (id, bankiban, banknumber, name, nip, createdat, updatedat)
values (2, 'PL AA BBBB CCCD 1111 2222 3333 4444', '99 1111 2222 3333 4444', 'Piotrek', '344-443-3333', '2020-01-19 10:29:27.000000', '2021-06-19 14:47:57.000000');


-- Employer dataset

insert into employer (id, createdat, email, name, nip, phone, updatedat)
VALUES (1, '2021-01-25 04:30:17.000000', '123@aa.com', 'Google', '12-1111-1234','14-12301222', '2021-06-19 14:47:57.000000');

insert into employer (id, createdat, email, name, nip, phone, updatedat)
VALUES (2, '2021-03-19 19:40:40.000000', '345@bb.com', 'Franek Kolega', '12-2222-1234','12-12301222', '2021-06-19 14:47:57.000000');

insert into employer (id, createdat, email, name, nip, phone, updatedat)
VALUES (3, '2021-05-10 13:07:12.000000', '456@ccc.com', 'UJ', '12-4444-1234','19-12301222', '2021-06-19 14:47:57.000000');

insert into employer (id, createdat, email, name, nip, phone, updatedat)
VALUES (4, '2021-10-02 23:12:38.000000', '5678@dddd.com', 'Amazon', '12-8888-1234','12-12301222', '2021-06-19 14:47:57.000000');

-- Projekty

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (1, 'red', '2021-05-10 13:07:12.000000', 'Projekt - JAVA test',  '2021-06-19 14:47:57.000000', 1);

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (2, 'blue', '2021-05-10 13:07:12.000000', 'Projekt - Angular test',  '2021-06-19 14:47:57.000000', 1);

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (3, 'green', '2021-05-10 13:07:12.000000', 'Projekt - Python test',  '2021-06-19 14:47:57.000000', 2);

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (4, 'purple', '2021-05-10 13:07:12.000000', 'SQL dla JAVA-site',  '2021-06-19 14:47:57.000000', 3);

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (5, 'grey', '2021-05-10 13:07:12.000000', 'SQL Python',  '2021-06-19 14:47:57.000000', 2);

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (6, 'yellow', '2021-05-10 13:07:12.000000', 'SQL test',  '2021-06-19 14:47:57.000000', 1);

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (7, 'red', '2021-05-10 13:07:12.000000', 'JAVA test',  '2021-06-19 14:47:57.000000', 3);

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (8, 'red', '2021-05-10 13:07:12.000000', 'Python',  '2021-06-19 14:47:57.000000', 4);

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (9, 'red', '2021-05-10 13:07:12.000000', 'Angular',  '2021-06-19 14:47:57.000000', 4);

insert into project (id, color, createdat, name, updatedat, employer_id)
VALUES (10, 'red', '2021-05-10 13:07:12.000000', 'Site FullStack-AngularSpringBOOT',  '2021-06-19 14:47:57.000000', 3);

--  tasks

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (1, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 55, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 1);

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (2, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 10, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 2);

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (3, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 20, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 3);

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (4, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 45, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 4);

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (5, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 123, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 5);

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (6, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 123, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 6);

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (7, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 79, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 7);

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (8, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 180, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 8);

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (9, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 122, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 9);

insert into task (id, createdat, dateend, datestart, invoicecreated, name, time, timeofinvoicecreation, updatedat, project_id)
VALUES (10, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', false, 'Zadanie 1', 345, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 10);



-- adresses

insert into address (id, buildingnumber, city, country, createdat, flatnumber, name, postalcode, street, updatedat)
VALUES (1, 24,'Kraków','Polska','2021-05-10 13:07:12.000000', 12, 'domowy', '30-398', 'Narutowicza', '2021-05-10 13:07:12.000000');

insert into address (id, buildingnumber, city, country, createdat, flatnumber, name, postalcode, street, updatedat)
VALUES (2, 46,'Bydgoszcz','Polska','2021-05-10 13:07:12.000000', 15, 'Firmowy', '30-398', 'Krakowska', '2021-05-10 13:07:12.000000');

insert into address (id, buildingnumber, city, country, createdat, flatnumber, name, postalcode, street, updatedat)
VALUES (3, 21,'Tarnów','Polska','2021-05-10 13:07:12.000000', 1, 'domowy', '30-398', 'Lwowska', '2021-05-10 13:07:12.000000');

insert into address (id, buildingnumber, city, country, createdat, flatnumber, name, postalcode, street, updatedat)
VALUES (4, 53,'Warszawa','Polska','2021-05-10 13:07:12.000000', 5, 'Firmowy', '30-398', 'Kondratowicza', '2021-05-10 13:07:12.000000');

insert into address (id, buildingnumber, city, country, createdat, flatnumber, name, postalcode, street, updatedat)
VALUES (5, 2,'Gdańsk','Polska','2021-05-10 13:07:12.000000', 88, 'Mój', '30-398', 'Midowa', '2021-05-10 13:07:12.000000');

insert into address (id, buildingnumber, city, country, createdat, flatnumber, name, postalcode, street, updatedat)
VALUES (6, 12,'Toruń','Polska','2021-05-10 13:07:12.000000', 1, 'Mój drugi', '30-398', 'Gronostajowa', '2021-05-10 13:07:12.000000');

insert into address (id, buildingnumber, city, country, createdat, flatnumber, name, postalcode, street, updatedat)
VALUES (7, 11,'Kołobrzeg','Polska','2021-05-10 13:07:12.000000', 33, 'domowy', '30-398', 'Gołębia', '2021-05-10 13:07:12.000000');

-- invoices
insert into invoice(id, createdat, invoicecreationdate, paydue, pricenet, seconddate, updatedat, vat, employee_id, employer_id)
VALUES (1, '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', '2021-05-10 13:07:12.000000', 23,'2021-05-10 13:07:12.000000','2021-05-10 13:07:12.000000',23,1,1);

---- Maps
-- empolyee_address_map
insert into employee_address_map(address_id, employee_id) VALUES (1,1);
insert into employee_address_map(address_id, employee_id) VALUES (3,2);
-- empolyer_address_map
insert into employer_address_map(address_id, employer_id) VALUES (2,1);
insert into employer_address_map(address_id, employer_id) VALUES (4,2);
insert into employer_address_map(address_id, employer_id)VALUES (5,3);
insert into employer_address_map(address_id, employer_id) VALUES (6,4);
--employee-employer-map
insert into employer_employee_map(employer_id, employee_id) VALUES (1,1);
insert into employer_employee_map(employer_id, employee_id) VALUES (2,2);
insert into employer_employee_map(employer_id, employee_id) VALUES (3,2);
insert into employer_employee_map(employer_id, employee_id) VALUES (4,2);

