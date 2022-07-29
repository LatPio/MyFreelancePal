select 1;
-- Employee dataset

insert into employee (id, bankiban, banknumber, currency, description, email, name, nip, phone, vat)
values
    (10001, 'PLAABBBBCCCD8888777755553333', '908888777755553333', 'USD','Mój prywatny profil dla znajomych', 'rafal@gmail.com','Rafał Master Jedi', '1234567890', '0121234567','5'),
    (10002, 'PLAABBBBCCCD8888777755553333', '908888777755553333', 'PLN','Mój biznesowy profil', 'rafal@rafal.com','Rafał Kowalski', '1234567890', '0121234567','23');


-- Employer dataset

insert into employer (id, activeemployer, email, description, name, nip, phone, notes)
VALUES
    (10001, true, '123@aa.com','?', 'Google', '1211111234','01412301222', '?'),
    (10002, true, '345@bb.com', '?','Franek Kolega', '1222221234','1212301222', '?'),
    (10003, true, '456@ccc.com', '?', 'UJ', '1244441234','1912301222', '?'),
    (10004, true, '5678@dddd.com', '?', 'Amazon', '1288881234','1212301222', '?');

-- Projekty

insert into project (id, color, name,   description, hourpricedefault, activeproject, employer_id)
VALUES
    (10001, 'red', 'Projekt - JAVA test',  'Opis wymagań projektowych', 245.32, true, 10001),
    (10002, 'blue', 'Projekt - Python test',  'Opis wymagań projektowych', 290.32, true, 10002),
    (10003, 'purple', 'Projekt - Site FullStack-AngularSpringBOOT test',  'Opis wymagań projektowych', 245.32, true, 10003),
    (10004, 'grey', 'Projekt - SQL test',  'Opis wymagań projektowych', 123.45, true, 10002),
    (10005, 'yellow', 'Projekt - JAVA test',  'Opis wymagań projektowych', 245.00, true, 10004),
    (10006, 'teal', 'Projekt - SQL test',  'Opis wymagań projektowych', 100.90, true, 10004),
    (10007, 'navy', 'Projekt - JAVA test',  'Opis wymagań projektowych', 350.92, true, 10001),
    (10008, 'fuchsia', 'Projekt - SQL test',  'Opis wymagań projektowych', 134.33, true, 10002),
    (10009, 'aqua', 'Projekt - Angular test',  'Opis wymagań projektowych', 250.44, true, 10002),
    (10010, 'silver', 'Projekt - JAVA test',  'Opis wymagań projektowych', 200.00, true, 10003),
    (10011, 'olive', 'Projekt - Python test',  'Opis wymagań projektowych', 199.55, true, 10003),
    (10012, 'lime', 'Projekt - JAVA test',  'Opis wymagań projektowych', 290.02, true, 10002),
    (10013, 'orange', 'Projekt - Angular test',  'Opis wymagań projektowych', 300.90, true, 10001),
    (10014, 'green', 'Projekt - Site FullStack-AngularSpringBOOT test',  'Opis wymagań projektowych', 499.89, true, 10003);

-- adresses

insert into address (id, buildingnumber, city, country, flatnumber, name, postalcode, street, employer_id)
VALUES
    (10001, 24,'Kraków','Polska', 12, 'Główny', '30-398', 'Narutowicza', 10001),
    (10002, 46,'Bydgoszcz','Polska', 15, 'Firmowy', '30-398', 'Krakowska',  10001),
    (10003, 21,'Tarnów','Polska', 1, 'Firmowy', '30-398', 'Lwowska', 10002),
    (10004, 53,'Warszawa','Polska',5, 'Firmowy', '30-398', 'Kondratowicza', 10002),
    (10005, 2,'Gdańsk','Polska', 88, 'Firmowy', '30-398', 'Midowa', 10003),
    (10006, 12,'Toruń','Polska',1, 'Firmowy drugi', '30-398', 'Gronostajowa', 10003),
    (10007, 11,'Kołobrzeg','Polska',33, 'Firmowy', '30-398', 'Gołębia', 10004),
    (10008, 24,'Kraków','Polska', 12, 'domowy', '30-398', 'Narutowicza', 10004);

insert into address (id, buildingnumber, city, country, flatnumber, name, postalcode, street, employee_id)
VALUES
    (10009, 53,'Warszawa','Polska', 5, 'Domowy', '30-398', 'Kondratowicza', 10001),
    (10010, 2,'Gdańsk','Polska',88, 'Domowy drugi', '30-398', 'Midowa', 10001),
    (10011, 12,'Toruń','Polska',1, 'Mój drugi', '30-398', 'Gronostajowa', 10002),
    (10012, 11,'Kołobrzeg','Polska',33, 'Mój', '30-398', 'Gołębia',  10002);

-- invoices
insert into invoice (id, amountinwords, amountnet, amountpretax, amountvat, creatinddate, daystopay, invoicecreationdate, payduedate, invoicedateofworkcompletion, updatedate, vat, employee_id, employeeaddress_id, employer_id, employeraddress_id)
values  ('2022-07/10000', 'two thousand three hundred fourteen   07/100', 2203.88, 2314.07, 110.19, '2022-07-28 22:08:57.928197', 14, '2022-07-28', '2022-08-11', '2022-07-28', '2022-07-28 22:15:11.851855', 5, 10001, 10009, 10001, 10001);

--invoiceServiceEntry
insert into invoiceserviceentry (id, amount, createdat, idsoftasks, name, netamount, netprice, pretaxamount, unit, updatedat, vat, vatamount, invoiceid)
values  (10001, 463, '2022-07-28 22:15:05.635280', '10001,10011,10024,10028', 'JAva', 2203.88, 4.76, 2314.07, 'min', '2022-07-28 22:15:05.685311', 5, 110.19, '2022-07/10000');

--  tasks
insert into task (id, createdat, dateend, datestart, donetask, hourprice, invoicecreated, name, timeofinvoicecreation, timeofworkinmin, updatedat, invoiceserviceentryid, project_id)
values  (10002, null, '2022-07-10 18:24:12.000000', '2022-07-10 15:09:12.000000', true, 290.32, false, 'Task 2', null, 193, null, null, 10002),
        (10003, null, '2022-07-11 10:28:12.000000', '2022-07-11 07:04:12.000000', true, 245.32, false, 'Task 3', null, 201, null, null, 10003),
        (10004, null, '2022-07-11 15:02:12.000000', '2022-07-11 10:42:12.000000', true, 123.45, false, 'Task 4', null, 322, null, null, 10004),
        (10005, null, '2022-07-11 18:00:12.000000', '2022-07-11 15:03:12.000000', true, 290.32, false, 'Task 5', null, 192, null, null, 10002),
        (10006, null, '2022-07-12 12:22:12.000000', '2022-07-12 08:02:12.000000', true, 245.32, false, 'Task 6', null, 262, null, null, 10003),
        (10007, null, '2022-07-12 15:08:12.000000', '2022-07-12 13:42:12.000000', true, 290.32, false, 'Task 7', null, 92, null, null, 10002),
        (10008, null, '2022-07-12 18:48:12.000000', '2022-07-12 16:02:12.000000', true, 245.00, false, 'Task 2', null, 231, null, null, 10005),
        (10009, null, '2022-07-13 11:28:12.000000', '2022-07-13 09:12:12.000000', true, 100.90, false, 'Task 3', null, 141, null, null, 10006),
        (10010, null, '2022-07-13 12:58:12.000000', '2022-07-13 11:33:12.000000', true, 245.00, false, 'Task 4', null, 67, null, null, 10005),
        (10012, null, '2022-07-13 17:18:12.000000', '2022-07-13 15:32:12.000000', true, 134.33, false, 'Task 11', null, 89, null, null, 10008),
        (10013, null, '2022-07-14 09:08:12.000000', '2022-07-14 07:02:12.000000', true, 200.00, false, 'Task 12', null, 128, null, null, 10010),
        (10014, null, '2022-07-14 12:18:12.000000', '2022-07-14 09:12:12.000000', true, 199.55, false, 'Task 13', null, 186, null, null, 10011),
        (10015, null, '2022-07-14 13:23:12.000000', '2022-07-14 12:22:12.000000', true, 300.90, false, 'Task 14', null, 54, null, null, 10013),
        (10016, null, '2022-07-14 14:45:12.000000', '2022-07-14 13:32:12.000000', true, 290.02, false, 'Task 15', null, 78, null, null, 10012),
        (10017, null, '2022-07-14 17:55:12.000000', '2022-07-14 15:02:12.000000', true, 499.89, false, 'Task 16', null, 169, null, null, 10014),
        (10018, null, '2022-07-15 10:48:12.000000', '2022-07-15 07:02:12.000000', true, 123.45, false, 'Task 17', null, 214, null, null, 10004),
        (10019, null, '2022-07-15 13:22:12.000000', '2022-07-15 11:02:12.000000', true, 245.00, false, 'Task 18', null, 154, null, null, 10005),
        (10020, null, '2022-07-15 18:08:12.000000', '2022-07-15 15:02:12.000000', true, 123.45, false, 'Task 19', null, 183, null, null, 10004),
        (10021, null, '2022-07-16 11:08:12.000000', '2022-07-16 09:02:12.000000', true, 290.32, false, 'Task 21', null, 127, null, null, 10002),
        (10022, null, '2022-07-16 13:02:12.000000', '2022-07-16 11:13:12.000000', true, 290.32, false, 'Task 22', null, 111, null, null, 10002),
        (10023, null, '2022-07-16 16:01:12.000000', '2022-07-16 14:12:12.000000', true, 245.32, false, 'Task 20', null, 102, null, null, 10003),
        (10025, null, '2022-07-17 09:01:12.000000', '2022-07-17 07:04:12.000000', true, 290.32, false, 'Task 24', null, 113, null, null, 10002),
        (10026, null, '2022-07-17 11:28:12.000000', '2022-07-17 09:02:12.000000', true, 245.32, false, 'Task 25', null, 145, null, null, 10003),
        (10027, null, '2022-07-17 13:58:12.000000', '2022-07-17 12:02:12.000000', true, 245.00, false, 'Task 27', null, 103, null, null, 10005),
        (10001, null, '2022-07-10 15:08:12.000000', '2022-07-10 13:02:12.000000', true, 111.00, true, 'Task 1', '2022-07-28 22:15:05.595855', 126, '2022-07-28 22:15:05.660819', 10001, 10001),
        (10011, null, '2022-07-13 15:28:12.000000', '2022-07-13 13:02:12.000000', true, 350.92, true, 'Task 7', '2022-07-28 22:15:05.595855', 145, '2022-07-28 22:15:05.665934', 10001, 10007),
        (10024, null, '2022-07-16 17:08:12.000000', '2022-07-16 16:02:12.000000', true, 350.92, true, 'Task 23', '2022-07-28 22:15:05.595855', 63, '2022-07-28 22:15:05.669008', 10001, 10007),
        (10028, null, '2022-07-17 17:08:12.000000', '2022-07-17 15:02:12.000000', true, 350.92, true, 'Task 30', '2022-07-28 22:15:05.595855', 129, '2022-07-28 22:15:05.671007', 10001, 10007);



