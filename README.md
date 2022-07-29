# MyFreelancePal

_made by Piotr Łątka_

_First Java-SpringBoot project written as part of the Course: [JWD - WSZIB Krakow](https://www.wszib.edu.pl/en/postgraduate-studies-and-courses/postgraduate-studies/java-web-developer/)_

## Main features:


- Managing time spent on a different project
- Assign project to your employer
- Grouping projects and time spend to a specific employer
- Managing employers and jobs done for them
- Simple invoice issuing and management
- Calendar view

# Technologies
Project Created with:
- SpringBoot 2.6.6
- BootStrap 5.2
- Thymeleaf 2.6.6
- Postgresql 42.3.3


# Getting Started

1. You can download this project directly to your local machine and simply configure file db-template.properties with: DateBase Name, Login and Password, and then change name of the file to db.properties. Currently, implemented database is Postgresql.
2. Second method you cna run this application is simply host it on server. In application.properties are added commented vales for Hosting page Heroku. Uncomment these and commit to your own account on Heroku or another hosting page.
3. In root folder is data.sql with some mock data to play around, if you want clean app to work with, simply delete or comment everything (first line leave as it is). 

# Some Features of application and walk around:
1. To be able, add first task and count time, first add in Manage Employers page new **_Employer_** with assigned to it some **_Projects_**.
2. Main page: simple Dashboard with some statistical data. In section _List Of Project for..._ you can  switch Project between <span style="color:green">_**Active**_</span> and <span style="color:red">_**Inactive**_</span> to show less projects in **_Active Task_** page. 
3. At page Active Tasks are listed active project with Staring Task square. After setting task name, will appear new square with stopper like function after hitting play and stop it will count time spent on task and save it to database. 
4. In section Manage Employers you can go to Detailed Information where are stored data on Project and Task.
5. To be able to create Invoice first Create your own profile.
6. In section Billings you can create Invoice. Invoice Creation consist of three steps. First create template of Invoice choosing Employer and Your Profile. Next Open and Update Information such as Dates and pick Appropriate Addresses. And finally click Add Entry, in this page you can choose Task assigned for chosen Employer which wasn't put in another InvoiceEntry. After specifying Name and save InvoiceEntry and later saving Invoice app will calculate and populate Invoice Table with appropriate Values. To Nicely layout Invoice hit print button it will redirect to clean view of Invoice, form where you can print your Invoice and send it to your Employer.           
 
### Features to be added:
- Login Page with managing many tenant 

