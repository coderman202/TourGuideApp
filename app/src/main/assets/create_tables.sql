CREATE TABLE IF NOT EXISTS City (
CityID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
CityName TEXT NOT NULL,
CityPopulation INTEGER NOT NULL,
CityDescription TEXT NOT NULL,
CityCountry TEXT NOT NULL,
CityHistory TEXT NOT NULL,
CityLanguage TEXT NOT NULL,
CityImage TEXT NOT NULL,
CityTimeZone TEXT NOT NULL);

CREATE TABLE IF NOT EXISTS Airport (
AirportID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
AirportName TEXT NOT NULL,
CityID INTEGER NOT NULL,
AirportIATACode TEXT NOT NULL,
FOREIGN KEY(CityID) REFERENCES City(CityID) ON DELETE SET NULL );

CREATE TABLE IF NOT EXISTS Hotel (
HotelID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
HotelName TEXT NOT NULL,
CityID INTEGER NOT NULL,
HotelDescription TEXT NOT NULL,
HotelAddress TEXT NOT NULL,
HotelNeighbourhood TEXT NOT NULL,
HotelWebsite TEXT NOT NULL,
HotelRating INTEGER NOT NULL,
HotelPrice INTEGER NOT NULL,
HotelClass INTEGER NOT NULL,
HotelPhone TEXT NOT NULL,
FOREIGN KEY(CityID) REFERENCES City(CityID) ON DELETE SET NULL );

CREATE TABLE IF NOT EXISTS Amenity (
AmenityID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
AmenityName TEXT NOT NULL,
AmenityIcon TEXT NOT NULL);

CREATE TABLE IF NOT EXISTS HotelAmenity (
HotelAmenityID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
AmenityID INTEGER NOT NULL,
HotelID INTEGER NOT NULL,
FOREIGN KEY(AmenityID) REFERENCES Amenity(AmenityID) ON DELETE SET NULL,
FOREIGN KEY(HotelID) REFERENCES Hotel(HotelID) ON DELETE SET NULL );

CREATE TABLE IF NOT EXISTS RestaurantBar (
RestaurantBarID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
RestaurantBarName TEXT NOT NULL,
CityID INTEGER NOT NULL,
RestaurantBarDescription TEXT NOT NULL,
RestaurantBarAddress TEXT NOT NULL,
RestaurantBarNeighbourhood TEXT NOT NULL,
RestaurantBarWebsite TEXT NOT NULL,
RestaurantBarOpeningHours TEXT NOT NULL,
RestaurantBarDiningHours TEXT NOT NULL,
RestaurantBarRating INTEGER NOT NULL,
RestaurantBarPrice INTEGER NOT NULL,
RestaurantBarMichelinStars INTEGER NOT NULL,
RestaurantBarPhone TEXT NOT NULL,
RestaurantBarWheelchairAccess INTEGER,
FOREIGN KEY(CityID) REFERENCES City(CityID) ON DELETE SET NULL );

CREATE TABLE IF NOT EXISTS Cuisine (
CuisineID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
CuisineName TEXT NOT NULL);

CREATE TABLE IF NOT EXISTS RestaurantBarCuisine (
RestaurantBarCuisineID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
RestaurantBarID INTEGER NOT NULL,
CuisineID INTEGER NOT NULL,
FOREIGN KEY(RestaurantBarID) REFERENCES RestaurantBar(RestaurantBarID) ON DELETE SET NULL,
FOREIGN KEY(CuisineID) REFERENCES Cuisine(CuisineID) ON DELETE SET NULL );

CREATE TABLE IF NOT EXISTS Event (
EventID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
EventName TEXT NOT NULL,
CityID INTEGER NOT NULL,
EventDescription TEXT NOT NULL,
EventAddress TEXT NOT NULL,
EventWebsite TEXT NOT NULL,
EventStartDateTime TEXT NOT NULL,
EventEndDateTime TEXT NOT NULL,
EventTheme TEXT NOT NULL,
EventWheelchairAccess INTEGER,
FOREIGN KEY(CityID) REFERENCES City(CityID) ON DELETE SET NULL );

CREATE TABLE IF NOT EXISTS Attraction (
AttractionID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
AttractionName TEXT NOT NULL,
CityID INTEGER NOT NULL,
AttractionDescription TEXT NOT NULL,
AttractionAddress TEXT NOT NULL,
AttractionWebsite TEXT NOT NULL,
AttractionNeighbourhood TEXT NOT NULL,
AttractionPrice INTEGER NOT NULL,
AttractionRating INTEGER NOT NULL,
AttractionOpeningHours TEXT NOT NULL,
AttractionPhone TEXT NOT NULL,
AttractionWheelchairAccess INTEGER,
FOREIGN KEY(CityID) REFERENCES City(CityID) ON DELETE SET NULL);

CREATE TABLE IF NOT EXISTS Tour (
TourID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
TourName TEXT NOT NULL,
CityID INTEGER NOT NULL,
TourDescription TEXT NOT NULL,
TourAddress TEXT NOT NULL,
TourWebsite TEXT NOT NULL,
TourOperator TEXT NOT NULL,
TourPrice INTEGER NOT NULL,
TourRating INTEGER NOT NULL,
TourOperatingTimes TEXT NOT NULL,
TourPhone TEXT NOT NULL,
TourWheelchairAccess INTEGER,
FOREIGN KEY(CityID) REFERENCES City(CityID) ON DELETE SET NULL);

CREATE TABLE IF NOT EXISTS Transport (
TransportID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
TransportType TEXT NOT NULL,
TransportIcon TEXT NOT NULL);

CREATE TABLE IF NOT EXISTS TransportSystem (
TransportSystemID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
CityID INTEGER NOT NULL,
TransportID TEXT NOT NULL,
FOREIGN KEY(CityID) REFERENCES City(CityID) ON DELETE SET NULL,
FOREIGN KEY(TransportID) REFERENCES Transport(TransportID) ON DELETE SET NULL);