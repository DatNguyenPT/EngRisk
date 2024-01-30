CREATE DATABASE ENGRISK;

USE ENGRISK;

CREATE TABLE VOCAB(
	category VARCHAR(255) NOT NULL, -- Job, Tech,..
	words VARCHAR(255) NOT NULL PRIMARY KEY,
	wordType VARCHAR(10) NOT NULL,
	pronoun VARCHAR(255) NOT NULL,
	exampleSentence VARCHAR(255) NOT NULL
);

CREATE TABLE GRAMMAR(
	category VARCHAR(255) NOT NULL,
	grammarType VARCHAR(255) NOT NULL PRIMARY KEY,
	usingSituation VARCHAR(255) NOT NULL,
	positiveFormula VARCHAR(255) NOT NULL,
	negativeFormula VARCHAR(255) NOT NULL,
	questionFormula VARCHAR(255) NOT NULL,
	exampleSentence VARCHAR(255) NOT NULL
);

create table QUIZ(
	question varchar(255),
    answer varchar(255)
);

create table USER(
	user_name varchar(255),
    pass varchar(255),
    login_name varchar(50),
    active_status bit,
    joined_date datetime,
    latest_active datetime
);

create table PROGRESS(
	user_name varchar(255),
    percent int,
    course_name varchar(80)
);

CREATE TABLE LESSON_PROGRESS (
    user_name VARCHAR(255),
    course_name VARCHAR(80),
    percent_completed INT
);

CREATE TABLE COURSES(
	course_name VARCHAR(255),
    category VARCHAR(255),
    rating INT,
	joined BIGINT
);

CREATE TABLE JOIN_COURSE(
	user_name VARCHAR(255),
    course_name VARCHAR(255),
    joined_date datetime,
    complete_status bit
);

CREATE TABLE CONTRIBUTE(
	id BIGINT auto_increment primary key,
	user_name VARCHAR(255),
    score BIGINT,
    latest_contribute DATETIME,
    words varchar(255)
);







