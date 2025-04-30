DashDoor App
Project 02: DashDoor
Senen Bagos
Natalio Maturino
Rene Vega Gonzales
Andre Gutierrez
CST 338 Spring 25, Section 2

DashDoor

We are going to make a rip-off of DoorDash, “DashDoor.” DoorDash prices are too high, and DashDoor sells at a cheaper price and will definitely be more user friendly. 

Github: https://github.com/sbagos27/DashDoor



Table of contents

Completed Rubric Items	2
Initial Layout	3
Entity Relationship Diagram (ERD) REQUIRED	4
Team members	5
Senen Bagos III	5
Andre Gutierrez	5
Natalio Maturino	5
Rene Gonzalez	5
User Stories	6





Completed Rubric Items
Please highlight the items you have completed
Item
The following are Required
Score
Persistence
Minimum 3 tables implemented using the Room database wrapper
If you do not use the Room Database wrapper the project will be marked as 0.
30
Github issues
There must be at least 5 GitHub issues PER TEAMMATE
10
Presentation
Each application must have a video showing its functionality.
The video must be between 6 – 8 minutes long.
Each person must present their portion for 1-2 minutes
35
Highlighted Rubric
This rubric must be included in the video AND the submission. 
All completed tasks must be highlighted
5
Activities
Each team member must create 2-3 activities,
one of which must interact with the database.
12
Activity:
Login Page
An activity where a username and password are entered.
The username and password must be stored in the local room database.
4
Activity:
Landing Page
After successful login an activity should start that displays the username and some other information retrieved from the local database.
4
Admin landing page
If the user is an administrator the landing page must indicate this with additional options.
The same Activity may be used for both admin and non-admin users.
4
Github
Code must be pushed to Github in a public repository.
Each teammate must have at least 3 branches, with 5 commits EACH;
each branch must be merged into main using a pull request.
10
Unit tests
Each teammate must contribute at LEAST 2 unit tests. The tests must pass.
20


Optional Item
The following are Optional
Score
Intent Factories
All Intents to start an activity must use the factory pattern
Either each activity must have an Intent factory method OR use a Factory class.
10
Intent Tests
At least 1 unit test per activity transition. That is each intent must have a unit test.
20
Database Tests
Each database table must have at least three tests (insert, update, delete)
20
Recycler View
At least 1 activity has a recycler view for displaying information
10
Livedata
Incorporate liveData in your project. This dovetails nicely with adding a recycler view
10
API Integration
Use Retrofit to consume an external API 
20
External Library
Use an external Library. Here is a list of examples. 
Retrofit is included and would count for this.
16
Fragments
Incorporate fragments into your application
8
OAuth
Implement login with OAuth 2.  This can replace the login procedure described above
16

Initial Layout
Draw.io Link: https://app.diagrams.net/#G1fkM5_6VT_LTyCZ1TZHR5o2N6g2gk99e3#%7B%22pageId%22%3A%22Eet8k7oY_k7z-xd7VqKL%22%7D
Include a mock layout similar to the one shown below.  This can be created using screenshots from Android Studio, Draw.Io, or sketched out on paper (or a tablet if you are fortunate enough to have one).



Entity Relationship Diagram (ERD) REQUIRED

The assignment MUST use a database and must have at least three tables




Team members
Senen Bagos III
	Manage Pull Requests 
Issue: Created Repository and shared with everyone
Issue: Create Login, sign up and landing page. https://github.com/sbagos27/DashDoor/issues/1
Issue: Forget password
Issue: Distinguish between admin and normal user when making account and logging in


Andre Gutierrez
Issue: Menu (Shopping Cart UI) https://github.com/sbagos27/DashDoor/issues/2
Issue: Make restaurants and menus for restaurants
Issue: 4 food types (pizza,burgers,mexican,chinese)
Issue: checkout for ordering
Issue: Payment decision

Rene Gonzalez
Issue: create database for food transactions
Issue: database prices for all restaurants
Issue: storage for clients accounts
Feature: ensure food prices are not too high
Natalio Maturino
Issue: Create the admin https://github.com/sbagos27/DashDoor/issues/3
Issue: Allow admin to review accounts and shopping history
Issue: Allow admin to add, remove and edit user accounts
Issue: Allow admin to set rules and guidelines
Issue: Ensure customers do not have access to admin

User Stories

As a DashDoor user, I want to be able to order food from home
As a DashDoor user, I want to be able to make an account.
As a DashDoor user, I want to be able to pay with card and checkout.
As a DashDoor user, I want to be able to see my past orders.  
As a DashDoor user, I want an estimated time of arrival



From these use cases we generate the following issues:

Implement a list of restaurants with different types of food.
Use a database to store user accounts
Use a database to store past orders
A cart object to store orders


EXAMPLES(DELETE LATER) //am keeping this here to remember examples
Implement a Room database
Add the Gradle requirement
Setup the Asynchronous method to call the database
Create a Repository class to access the database
Create a GymLog entity object
It should store: Name of the lif, weight, repetitions, and the timestamp of when it happened
Create a Room DAO for the GymLog entity
Create methods in the DataRepository to access the GymLog records
Create a User Entity object
Required fields: username, password, isAdmin?
Create a Room DAO for the User entity
Create methods in the DataRepository to access the User records
