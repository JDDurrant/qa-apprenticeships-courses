-------------------------------------------------------------------------------
-- File:    createData.sql
-- Author:  Rhona MacDonald
-- Date:    August 2012
-- Purpose: Populates tables in the THEATRE database with sample data.
--          Database and tables must have been created prior to running.
-------------------------------------------------------------------------------
set nocount on
go

set quoted_identifier off
go

use THEATRE
go

insert into Region values ('HIGH','Highlands')
insert into Region values ('LNDN','London')
insert into Region values ('YORK','Yorkshire')
insert into Region values ('WALE','Cardiff')
insert into Region values ('WCSC','West Central Scotland')
go

print "Populated Region table"
go

insert into TheatreGroup values (200,'Music & Dance',9,'WCSC','9-Sep-2008',14620,NULL)
insert into TheatreGroup values (300,'Razzle Dazzle',3,'WCSC','18-Apr-2012',20000,NULL)
insert into TheatreGroup values (400,'Wonderland Productions',17,'LNDN','3-Jun-2012',6000,'Kings Theatre')
insert into TheatreGroup values (500,'Revelation',24,'LNDN','24-Jul-2009',1200,'Queens Theatre')
insert into TheatreGroup values (600,'Showtime Performers',28,'LNDN','25-Aug-2010',19725,'Royal Theatre')
insert into TheatreGroup values (700,'Entertainers R Us',35,'WALE','11-Nov-2007',17500,NULL)
insert into TheatreGroup values (800,'Dancing Divas',38,'YORK','13-Sep-2009',15000,NULL)
insert into TheatreGroup values (900,'Pantheon Performers',44,'YORK','27-Mar-2005',12250,NULL)
go

print "Populated TheatreGroup table"
go

insert into Skill values (1,'Modern Dance')
insert into Skill values (2,'Sing')
insert into Skill values (3,'Act')
insert into Skill values (4,'Jazz Dance')
insert into Skill values (5,'Stage Combat')
insert into Skill values (6,'Circus Skills')
insert into Skill values (7,'Tap Dance')
go

print "Populated Skill table"
go

insert into Performer values ( 1,'Kirsty','Taylor',162,300)
insert into Performer values ( 2,'John','Jones',180,300)
insert into Performer values ( 3,'Helen','Donachie',169,300)
insert into Performer values ( 4,'Gavin','Johnston',183,300)
insert into Performer values ( 5,'Thomas','Murray',187,300)
insert into Performer values ( 6,'Stacey','Selkirk',171,200)
insert into Performer values ( 7,'Anna','Craig',159,200)
insert into Performer values ( 8,'Fred','Grayson',168,200)
insert into Performer values ( 9,'Shiela','Wilson',164,200)
insert into Performer values (10,'James','Martin',190,200)
insert into Performer values (11,'Tracey','Jackson',174,200)
insert into Performer values (12,'Martin','Sloan',188,200)
insert into Performer values (13,'Gary','Morrison',192,200)
insert into Performer values (14,'Louise','Gerard',163,200)
insert into Performer values (15,'Peter','Patterson',177,200)
insert into Performer values (16,'Yvonne','Orr',165,200)
insert into Performer values (17,'Gayle','Smith',171,400)
insert into Performer values (18,'Steven','Carrick',194,400)
insert into Performer values (19,'Kevin','Stewart',187,400)
insert into Performer values (20,'Paul','Kelly',182,400)
insert into Performer values (21,'Sophie','Trent',156,500)
insert into Performer values (22,'Maria','Coleman',174,500)
insert into Performer values (23,'Geraldine','Portman',167,500)
insert into Performer values (24,'Marcus','Clayton',189,500)
insert into Performer values (25,'Stan','Borden',182,500)
insert into Performer values (26,'Theresa','Comiston',180,500)
insert into Performer values (27,'Louise','Taylor',170,600)
insert into Performer values (28,'Laura','Collins',158,600)
insert into Performer values (29,'Loretta','Jamieson',161,600)
insert into Performer values (30,'Michael','Folkstone',166,600)
insert into Performer values (31,'Gordon','Colt',188,600)
insert into Performer values (32,'Michelle','Caine',157,700)
insert into Performer values (33,'Jennie','Gordon',165,700)
insert into Performer values (34,'Patricia','Kelly',170,700)
insert into Performer values (35,'Mitchell','Green',186,700)
insert into Performer values (36,'Joanie','Hunt',161,700)
insert into Performer values (37,'Bob','Solden',190,800)
insert into Performer values (38,'Ben','Stoltz',187,800)
insert into Performer values (39,'Craig','Darwin',185,800)
insert into Performer values (40,'Kelly','Frost',173,800)
insert into Performer values (41,'Jenna','Mann',158,800)
insert into Performer values (42,'Jemima','Fairview',165,900)
insert into Performer values (43,'Jeff','Goldman',192,900)
insert into Performer values (44,'Luke','Moldern',186,900)
insert into Performer values (45,'Colette','Cross',167,900)
insert into Performer values (46,'Marissa','Georgeton',171,900)
insert into Performer values (47,'Henry','Acorn',194,900)
insert into Performer values (48,'Duncan','Morrison',194,500)
go

print "Populated Performer table"
go

insert into Performance values (1,'1-Mar-2012 8:00PM','My Fair Lady',200)
insert into Performance values (2,'12-Apr-2012 7:00PM','Cats',200)
insert into Performance values (3,'14-Apr-2012 7:00PM','Cats',200)
insert into Performance values (4,'16-Apr-2012 7:00PM','Cats',200)
insert into Performance values (5,'13-Feb-2012 7:30PM','Starlight Express',300)
insert into Performance values (6,'14-Feb-2012 7:30PM','Starlight Express',300)
insert into Performance values (7,'18-Feb-2012 6:00PM','Phantom of the Opera',300)
insert into Performance values (8,'20-Feb-2012 6:00PM','Phantom of the Opera',300)
insert into Performance values (9,'22-Feb-2012 6:00PM','Phantom of the Opera',300)
insert into Performance values (10,'9-Apr-2012 7:30PM','Wicked',400)
insert into Performance values (11,'10-Apr-2012 7:30PM','Wicked',400)
insert into Performance values (12,'22-Apr-2012 6:30PM','The Wiz',400)
insert into Performance values (13,'23-Apr-2012 6:30PM','The Wiz',400)
insert into Performance values (14,'24-Apr-2012 6:30PM','The Wiz',400)
insert into Performance values (15,'25-Apr-2012 6:30PM','The Wiz',400)
insert into Performance values (16,'3-Mar-2012 7:00PM','Jesus Christ Superstar',500)
insert into Performance values (17,'10-Mar-2012 7:00PM','Jesus Christ Superstar',500)
insert into Performance values (18,'10-May-2012 7:30PM','Blood Brothers',600)
insert into Performance values (19,'11-May-2012 7:30PM','Blood Brothers',600)
insert into Performance values (20,'12-May-2012 7:30PM','Blood Brothers',600)
insert into Performance values (21,'14-Mar-2012 8:00PM','Godspell',700)
insert into Performance values (22,'15-Mar-2012 8:00PM','Godspell',700)
insert into Performance values (23,'28-Jan-2012 7:00PM','Chicago',800)
insert into Performance values (24,'29-Jan-2012 7:00PM','Chicago',800)
insert into Performance values (25,'13-Mar-2012 7:30PM','Les Miserables',900)
insert into Performance values (26,'14-Mar-2012 7:30PM','Les Miserables',900)
insert into Performance values (27,'15-Mar-2012 7:30PM','Les Miserables',900)
insert into Performance values (28,'16-Mar-2012 7:30PM','Les Miserables',900)
insert into Performance values (29,'2-Jun-2012 7:30PM','Les Miserables',900)
insert into Performance values (30,'3-Jun-2012 7:30PM','Les Miserables',900)
go

print "Populated Performance table"
go

insert into PerformerSkill values (1,5)
insert into PerformerSkill values (21,4)
insert into PerformerSkill values (22,5)
insert into PerformerSkill values (42,4)
insert into PerformerSkill values (43,5)
insert into PerformerSkill values (12,1)
insert into PerformerSkill values (17,2)
insert into PerformerSkill values (23,3)
insert into PerformerSkill values (45,6)
go

print "Populated PerformerSkill table"
go

