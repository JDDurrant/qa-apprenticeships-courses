# Pupil's Library

You are asked to design, implement and test an application to help a school library with handle the process of lending books to pupils as well as maintaining the administration process. You are asked to build an intelligent login system in which user can be identified as a staff or Pupil. Your programs menu will be adapted based on the logged in user with appropriate menus. Staff or borrowers will be rejected if are not registered.

### Login menu is as follow:
* Login name
* Exit

### Pupils only have access to search book menu:
* Search by book ID
* Search by book name
* Search by book author
* Exit

### Staff have access to the main menu:
* Admin process
* Borrowers process
* Search process
* Exit

### Operate the library's functionality through different menus such as admin menu:
* Add book to library
* Delete book from library
* Search book menu
* Add/remove staff
* Add/remove pupils
* List all registered pupils
* List all registered staff
* Exit

### Borrowers process menu
* Add book to a borrower's list
* Remove book from a borrower's list
* List all books of a borrower
* Search book menu
* Exit

After login menu, appropriate menu will be displayed. All the menus are working as run time, displays after completion of each task. Exit option take the user to login menu.

## Some Suggestions - Create the following classes:

* Book (id, name, author, location_code)
* LibraryBook extends Book (qty, location, daysToBorrow...)
* UserLogin (username, password, state (staff = 1, pupils = 2))
* Person (UserLogin, name, surname, DOB, address, ...)
* Staff extends Person
* Pupil extends Person
* Borrower (Person, ArrayList<> booklist, ...)
* LibraryApplication

## Some rules
* The quantity of each book in the library will be decremented when borrowed by a student
* Each student can borrow up to 5 books
* Borrowing books should be follwed by restricted deadlines
* Number of available books should be updated when a book is borrowed or returned
* Borrowers should be able to search through the menu and get guidance with appropriate messages:
	* Whether book is available to borrow
	* How many copies are available
	* Whether the student is allowed to borrow this book
* Library books can be loaded by an automated process and updated whenthe program is terminated

Good luck!
