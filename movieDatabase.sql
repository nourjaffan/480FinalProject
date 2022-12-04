CREATE DATABASE IF NOT EXISTS db;
USE db;

DROP TABLE IF EXISTS ShowTimes;
CREATE TABLE ShowTimes
    (
    Title         varchar(45),
    ShowTime      varchar(45), 
    Day           int,
    Month         int,
    Year          int,
    PRIMARY KEY (Title, ShowTime)
    );


DROP TABLE IF EXISTS movie;
CREATE TABLE movie
    (
    Title         varchar(45),
    Genre         varchar(45),
    Length        varchar(45),
    ReleaseTime       varchar(45),
    Day           int,
    Month         int,
    Year          int,
    PRIMARY KEY (Title)
    );


DROP TABLE IF EXISTS seat;
CREATE TABLE seat
    (
    Title         varchar(45),
    Vacant        BOOLEAN,
    SeatNumber    int,
    ShowTime      varchar(45),
    Day           int,
    Month         int,
    Year          int,
    PRIMARY KEY (SeatNumber, Title, ShowTime)
    );
    
DROP TABLE IF EXISTS test;
