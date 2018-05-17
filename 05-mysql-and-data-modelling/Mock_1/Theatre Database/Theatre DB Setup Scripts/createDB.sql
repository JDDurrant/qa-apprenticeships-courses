-------------------------------------------------------------------------------
-- File:    createDB.sql
-- Author:  Rhona MacDonald
-- Date:    August 2012
-- Purpose: Creates the THEATRE database
-------------------------------------------------------------------------------

/* Drop databases if they exist */
set nocount on
go

set quoted_identifier off
go

use master
go

print 'Checking for existence of THEATRE database'
if exists (select * from sysdatabases where name = "THEATRE")
	begin
	print 'Dropping database THEATRE'
	drop database THEATRE
	end

USE master

/*  Create the Databases  */
exec("CREATE DATABASE THEATRE")
go

ALTER DATABASE THEATRE SET RECOVERY SIMPLE
go

print "Database THEATRE created"
go

use THEATRE
go
checkpoint
go
