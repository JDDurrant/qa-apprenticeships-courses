-------------------------------------------------------------------------------
-- File:    README.txt
-- Author:  Rhona MacDonald
-- Date:    May 2012
-- Purpose: Instructions detailing how to run scripts to create the database
-------------------------------------------------------------------------------

These instructions will enable you to create, populate and then make use of
the Theatre database on a named MS SQL server instance that is installed on
the local machine.  This is a sample database that will enable you to work on
the practice exercises designed for this database.

For the setup scripts to work you must first have a local installation of MS
SQL sever installed on your machine.


Instructions

1. Copy the 'DB Setup Scripts' folder containing this README file and the other
   database setup scripts to your local computer.

2. Using Windows Explorer, navigate to the local copy of the 'DB Setup Scripts'
   folder you just created in step 1.

3. Run the BUILD_DATABASE.bat batch script by double clicking on it.

4. A command shell window will open prompting you to enter the name of the
   server that you want to create the database on.  If you have used the
   default options when intalling MS SQL Server then the server name you should
   enter when prompted is:
   
     .\SQLEXPRESS
       
   If you have used a different server name during the installation, then you
   should enter that at the prompt instead.
	
5. A new message will now be displayed in the command shell window displaying
   the server name that the database will be created on, and asking you to
   confirm if you want to proceed.  The prompt is shown as below, you should
   enter Y or N at the prompt to confirm whether you want to proceed or not.

6. If you chose Y in step 5, the database will then be created and populated
   with the required data.  Messages will be output to the command shell
   window to update you on progress and finally the message below will be
   displayed to confirm that script has completed execution and prompting you
   to enter a key to exit.

     Database creation and data population is complete, press any key to exit.
   
7. If you chose N in step 5, the program will exit without creating the
   database.  The message below will be displayed to confirm that no database
   was created and you will finally be prompted to enter any key to exit the
   program.

     Program terminating, database has NOT been created, press any key to exit.