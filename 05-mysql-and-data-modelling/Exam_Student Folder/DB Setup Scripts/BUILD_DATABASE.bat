@echo off
rem ---------------------------------------------------------------------------
rem File:    BUILD_DATABASE.bat
rem Author:  Rhona MacDonald
rem Date:    August 2012
rem Purpose: Wrapper script to automate creation & population of database
rem ---------------------------------------------------------------------------

set /p servername=Please enter the servername: 

echo Will create and load database on %servername% server instance.
set /p proceed=Do you wish to continue (Y/N)? 

if "%proceed%"=="N" goto exit_error
if "%proceed%"=="n" goto exit_error

osql -n -E -S %servername% -i createDB.sql
if %ERRORLEVEL% neq 0 goto exit_error
echo ================
echo CREATED DATABASE
echo ================

osql -n -E -b -S %servername% -i populateDB.sql -h-1
if %ERRORLEVEL% neq 0 goto exit_error
echo ==================
echo POPULATED DATABASE
echo ==================

:exit_clean
echo Database creation and data population is complete, press any key to exit.
goto exit_wait

:exit_error
echo Program terminating, database creation has NOT been successful, press any key to exit.
goto exit_wait

:exit_wait
pause>%TMP%\null

