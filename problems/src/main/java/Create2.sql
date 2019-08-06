CREATE DATABASE Tracker;

CREATE TABLE Roles (
  Role_ID serial primary key,
  Role varchar(2000) NOT NULL UNIQUE
);

CREATE TABLE Rules (
  Rule_ID serial primary key,
  Rule varchar(2000) NOT NULL UNIQUE
);

CREATE TABLE Users (
  User_ID serial primary key,
  Full_name varchar(2000) NOT NULL,
  Role_ID integer references Roles(Role_ID),
  Rule_ID integer references Rules(Rule_ID)
);

CREATE TABLE Item_State (
  I_State_ID serial primary key,
  Status varchar(2000) NOT NULL UNIQUE
);

CREATE TABLE Item_Category (
  I_Category_ID serial primary key,
  Category varchar(2000) NOT NULL UNIQUE
);

CREATE TABLE Items (
  Item_ID serial primary key,
  I_Category_ID integer references Item_Category(I_Category_ID),
  User_ID integer references Users(User_ID),
  I_State_ID integer references Item_State(I_State_ID),
  Item varchar(2000) NOT NULL
);

CREATE TABLE Attached_Files (
  File_ID serial primary key,
  Item_ID integer references Items(Item_ID),
  FileName varchar(2000) NOT NULL
);

CREATE TABLE Item_Comments (
  CommentID serial primary key,
  Item_ID integer references Items(Item_ID),
  CommentName varchar(2000) NOT NULL
);

INSERT INTO Rules (Rule) VALUES
(N'Create, Delete, Change'),
(N'Create, Change');

INSERT INTO Roles (Role) VALUES
(N'Admin'), 
(N'User');

INSERT INTO Users (Full_name, Role_ID, Rule_ID) VALUES
(N'John Smith', 1, 1),
(N'Jenny Ocean', 2, 2),
(N'Mike Banen', 2, 2),
(N'Michel Bay', 2, 2);

INSERT INTO Item_State (Status) VALUES
(N'In Progress'), (N'Closed');

INSERT INTO Item_Category (Category) VALUES
(N'Cat1'), (N'Cat2'), (N'Cat3');

INSERT INTO Items (I_Category_ID, User_ID, I_State_ID, Item) VALUES
(1, 1, 1, 'Do sth'),
(2, 2, 2, 'Done'),
(3, 3, 1, 'Do sth2'),
(1, 4, 2, 'Do sth3');

INSERT INTO Attached_Files (Item_ID, FileName) VALUES
(1, 'FileDesc1'),
(2, 'FileDesc2'),
(3, 'FileDesc3'),
(4, 'FileDesc4');

INSERT INTO Item_Comments (Item_ID, CommentName) VALUES
(1, 'COMMENT1'),
(2, 'Commment2'),
(3, 'Com3'),
(4, 'Com44');