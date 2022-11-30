CREATE DATABASE IF NOT EXISTS 'db';
USE 'db';

DROP TABLE IF EXISTS 'time';
CREATE TABLE 'ShowTimes'
    (
    'Title'         varchar(45),
    'ShowTime'      String, 
    PRIMARY KEY ('Title', 'ShowTime')
    )


DROP TABLE IF EXISTS 'movie';
CREATE TABLE 'movie'
    (
    'Title'         varchar(45),
    'Genre'         varchar(45),
    'Length'        varchar(45),
    'Release'       time,
    PRIMARY KEY ('Title')
    )


DROP TABLE IF EXISTS 'seat';
CREATE TABLE 'seat'
    (
    'Title'         varchar(45),
    'Vacant'        BOOLEAN,
    'SeatNumber'    int,
    'ShowTime'      String,
    PRIMARY KEY ('SeatNumber', 'Title', 'ShowTime')
    )

