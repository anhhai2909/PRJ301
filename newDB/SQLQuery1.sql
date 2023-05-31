create table teacher(
tID nvarchar(20) primary key,
name nvarchar(100),
email nvarchar(100),
position int,
imgaddress text,
)

create table class(
cID nvarchar(20) primary key,
classname nvarchar(10),
numberofstudent int,
tID nvarchar(20) foreign key references teacher(tID)
)

create table Student(
sID nvarchar(20) primary key,
name nvarchar(100),
gender int,
dob Date,
homeaddress nvarchar(100),
idnumber nvarchar(10),
email nvarchar(100),
phone nvarchar(10),
prname nvarchar(100),
prphone nvarchar(10),
imgaddress text,
cID nvarchar(20) foreign key references class(cID),
)

create table learn(
years int,
begindate Date,
enddate Date,
cID nvarchar(20) foreign key references class(cID),
sID nvarchar(20) foreign key references Student(sID),
primary key(years,cID,sID)
)

create table timetable(
tt nvarchar(20),
subject nvarchar(100),
tDate Date,
slot int,
cID nvarchar(20) foreign key references class(cID),
primary key(tt,slot,cID)
)

create table classmanage(
years int,
cID nvarchar(20) foreign key references class(cID),
tID nvarchar(20) foreign key references teacher(tID),
primary key(years,cID,tID)
)

create table subject(
suID nvarchar(20) primary key,
name nvarchar(100),
descript text
)

create table attendence(
adate Date,
slot int,
stat int,
suID nvarchar(20) foreign key references subject(suID),
sID nvarchar(20) foreign key references Student(sID),
primary key (adate,slot,suID,sID)
)

create table mark(
m1 float,
m2 float,
pt1 float,
pt2 float,
mt float,
fe float,
avag float,
rating int,
suID nvarchar(20) foreign key references subject(suID),
sID nvarchar(20) foreign key references Student(sID),
primary key (suID,sID)
)

create table account(
username nvarchar(100) primary key,
upassword nvarchar(100),
sID nvarchar(20) foreign key references Student(sID),
)

create table adminacc(
username nvarchar(100) primary key,
upassword nvarchar(100),
role int,
tID nvarchar(20) foreign key references teacher(tID)
)