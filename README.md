# ReviewV1
Review of what i have learned so far

Basic JSP usage to get data from user and display to know if all works correctly.
Basic H2 usage as DB to storage data.
Basic SQL usage to save and get data from H2.
Basic IoC, Controllers, Repository and Module usage.

JSP stands for UI to see the result of work.
H2 stands for keeping User table and all the data in it.
SQL stands for communication with H2, getting and saving data in DB.
IoC stands for all the object creation and destruction management.
Controller stands for managing the end points.
Repository connects JSP with H2 through SQL.
Module is our class to manage the object properties.

In index.jsp we got a form that takes basic informations from user.
By pressing the button we can "register" to database. If registration process went correctly, the information about success will pop up under the button.
Second button stands for getting all the data stored in table which is displayed under it as well.

scheme.sql is a file to create table in our H2 Database when project starts.

User.java is our module that have basic properties like:
 - uid thats unique (doesn't work yet)
 - uName that we get from a form
 - uName that we get from a form
Some getters and setters are set to easly manage data of particular object.
The User class also have @Scope("prototype") which means that we can create multiple objects of user and changing any propertie affects only the object we meant.

HomeController.java is our controller to manage end points and actoins made by user.
We got 3 end points there:
 - "/" - for home page, which is all this end point do
 - "addUser" - to add user to Database, its also responsible for displaying a massage of success or error by comparing size of the table before and after action of adding user
 - "getUsers" - to display all the users from database on home page in .toString() format

UserRepo.java is our repository for all the operations made on database.
All we can do with the database so far is:
 - save() - save user to database with all the properties described in user.java file
 - getAll() - get all the data from Users table and make a List<User> thats returned and can be easly displayed in .toString() format

//DONE
- Repair uid
- finding user by id and name

//TODO
- add feature of removing object from table
- add feature of updating object data thats already saved
- Whatever I will come up with

Last readme update: 20.07.2024
