PRAGMA foreign_keys = OFF;

DROP TABLE IF EXISTS HotelAmenity;
DROP TABLE IF EXISTS RestaurantBarCuisine;
DROP TABLE IF EXISTS TransportSystem;
DROP TABLE IF EXISTS Hotel;
DROP TABLE IF EXISTS Amenity;
DROP TABLE IF EXISTS RestaurantBar;
DROP TABLE IF EXISTS Event;
DROP TABLE IF EXISTS Tour;
DROP TABLE IF EXISTS Attraction;
DROP TABLE IF EXISTS Cuisine;
DROP TABLE IF EXISTS Airport;
DROP TABLE IF EXISTS City;
DROP TABLE IF EXISTS Transport;

DELETE FROM sqlite_sequence WHERE name = 'HotelAmenity';
DELETE FROM sqlite_sequence WHERE name = 'RestaurantBarCuisine';
DELETE FROM sqlite_sequence WHERE name = 'TransportSystem';
DELETE FROM sqlite_sequence WHERE name = 'Hotel';
DELETE FROM sqlite_sequence WHERE name = 'Amenity';
DELETE FROM sqlite_sequence WHERE name = 'RestaurantBar';
DELETE FROM sqlite_sequence WHERE name = 'Event';
DELETE FROM sqlite_sequence WHERE name = 'Tour';
DELETE FROM sqlite_sequence WHERE name = 'Attraction';
DELETE FROM sqlite_sequence WHERE name = 'Cuisine';
DELETE FROM sqlite_sequence WHERE name = 'Airport';
DELETE FROM sqlite_sequence WHERE name = 'City';
DELETE FROM sqlite_sequence WHERE name = 'Transport';

PRAGMA foreign_keys = ON;