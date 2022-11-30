CREATE DATABASE IF NOT EXISTS 'db';
USE 'db';

DROP TABLE IF EXISTS 'time';
CREATE TABLE 'ShowTimes'
    (
    'Title'         varchar(50),
    'ShowTime'      varchar(50), 
    PRIMARY KEY ('Title', 'ShowTime')
    )


DROP TABLE IF EXISTS 'movie';
CREATE TABLE 'movie'
    (
    'Title'         varchar(50),
    'Genre'         varchar(50),
    'Length'        varchar(50),
    'Release'       time,
    PRIMARY KEY ('Title')
    )


DROP TABLE IF EXISTS 'seat';
CREATE TABLE 'seat'
    (
    'Title'         varchar(50),
    'Vacant'        BOOLEAN,
    'SeatNumber'    int,
    'ShowTime'      varchar(50),
    PRIMARY KEY ('SeatNumber', 'Title', 'ShowTime')
    )

