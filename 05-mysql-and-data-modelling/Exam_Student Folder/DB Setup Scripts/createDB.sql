-------------------------------------------------------------------------------
-- File:    createDB.sql
-- Author:  Rhona MacDonald
-- Date:    August 2012
-- Purpose: Creates the database required for City & Guilds Develop Software
--          using SQL assignment.
-------------------------------------------------------------------------------

/* Drop databases if they exist */
use master
go

print 'Checking for existence of CGDatabase database'
if exists (select * from sysdatabases where name = 'CGDatabase')
	begin
	print 'Dropping database CGDatabase'
	drop database CGDatabase
	end

USE master

/*  Create the Databases  */
CREATE DATABASE CGDatabase
go

ALTER DATABASE CGDatabase SET RECOVERY SIMPLE
go

print "Database CGDatabase created"
go

use CGDatabase
go

checkpoint
go

