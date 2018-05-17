-------------------------------------------------------------------------------
-- File:    createTables.sql
-- Author:  Rhona MacDonald
-- Date:    August 2012
-- Purpose: Creates the tables in the THEATRE database.  Requires the database
--          to have been created before running.
-------------------------------------------------------------------------------
set nocount on
go

set quoted_identifier off
go

use THEATRE
go

print 'Checking for existence of THEATRE tables'
if (object_id("PerformerSkill")) is not null
	begin
	print 'Dropping table PerformerSkill'
	drop table PerformerSkill
	end
else
begin
        print "Table PerformerSkill does not exist"
end
go
if (object_id("Skill")) is not null
	begin
	print 'Dropping table Skill'
	drop table Skill
	end
else
begin
        print "Table Skill does not exist"
end
if (object_id("Performer")) is not null
	begin
	print 'Dropping table Performer'
	drop table Performer
	end
else
begin
        print "Table Performer does not exist"
end
if (object_id("Performance")) is not null
	begin
	print 'Dropping table Performance'
	drop table Performance
	end
else
begin
        print "Table Performance does not exist"
end
if (object_id("TheatreGroup")) is not null
	begin
	print 'Dropping table TheatreGroup'
	drop table TheatreGroup
	end
else
begin
        print "Table TheatreGroup does not exist"
end
if (object_id("Region")) is not null
	begin
	print 'Dropping table Region'
	drop table Region
	end
else
begin
        print "Table Region does not exist"
end

create table Region
     ( RegionID char(4) not null primary key,
       RegionName varchar(25) not null,
     )
go
print "Created table Region"
go

create table TheatreGroup
     ( GroupID integer not null primary key,
       GroupName char(30) not null,
       Director integer not null,
       RegionID char(4) not null references Region,
       DateStarted datetime not null,
       AnnualRevenue decimal(10,2)  not null,
       TheatreName varchar(25) null
     )
go
print "Created table TheatreGroup"
go

create table Performer
     ( MembershipID integer not null primary key,
       FirstName varchar(15) null,
       Surname varchar(15) not null,
       Height integer not null,
       GroupID integer not null references TheatreGroup
     )
go  
print "Created table Performer"
go

create table Skill
     ( SkillID integer not null primary key,
       SkillName varchar(20) not  null,
     )
go 
print "Created table Skill"
go

create table PerformerSkill
     ( MembershipID integer not null references Performer,
       SkillID integer not null references Skill
     )
go 
print "Created table PerformerSkill"
go

create table Performance
     ( PerfID integer not null primary key,
       PerfDateTime datetime not null,
       ShowName varchar(30) not null,
       GroupID integer not null references TheatreGroup
     )
go
print "Created table Performance"
go
