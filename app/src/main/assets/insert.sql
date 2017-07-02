INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Pool", "pool.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Wifi", "wifi.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Restaurant", "restautant.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Gym", "gym.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("24h Reception", "24h.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Lounge", "lounge.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Parking", "parking.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Valet", "valet.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Concierge", "concierge.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Room Service", "roomservice.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Wheelchair Access", "wheelchair.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Breakfast", "breakfast.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Air Conditioning", "aircon.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Mini Bar", "minibar.xml");
INSERT INTO Amenities (AmenitiesName, AmenitiesIcon) VALUES ("Laundry Service", "laundry.xml");

INSERT INTO Transport (TransportType, TransportIcon) VALUES ("Bus", "bus.xml");
INSERT INTO Transport (TransportType, TransportIcon) VALUES ("Rail", "rail.xml");
INSERT INTO Transport (TransportType, TransportIcon) VALUES ("Taxi", "taxi.xml");
INSERT INTO Transport (TransportType, TransportIcon) VALUES ("Tram", "tram.xml");
INSERT INTO Transport (TransportType, TransportIcon) VALUES ("Metro", "metro.xml");
INSERT INTO Transport (TransportType, TransportIcon) VALUES ("Monorail", "monorail.xml");

INSERT INTO Cuisine (CuisineName) VALUES ('American');
INSERT INTO Cuisine (CuisineName) VALUES ('Arab');
INSERT INTO Cuisine (CuisineName) VALUES ('Armenian');
INSERT INTO Cuisine (CuisineName) VALUES ('Asian Fusion');
INSERT INTO Cuisine (CuisineName) VALUES ('Bar');
INSERT INTO Cuisine (CuisineName) VALUES ('Bolivian');
INSERT INTO Cuisine (CuisineName) VALUES ('Brazilian');
INSERT INTO Cuisine (CuisineName) VALUES ('British');
INSERT INTO Cuisine (CuisineName) VALUES ('Caribbean');
INSERT INTO Cuisine (CuisineName) VALUES ('Chilean');
INSERT INTO Cuisine (CuisineName) VALUES ('Chinese');
INSERT INTO Cuisine (CuisineName) VALUES ('Cocktails');
INSERT INTO Cuisine (CuisineName) VALUES ('Colombian');
INSERT INTO Cuisine (CuisineName) VALUES ('European');
INSERT INTO Cuisine (CuisineName) VALUES ('Fast Food');
INSERT INTO Cuisine (CuisineName) VALUES ('French');
INSERT INTO Cuisine (CuisineName) VALUES ('Greek');
INSERT INTO Cuisine (CuisineName) VALUES ('Indian');
INSERT INTO Cuisine (CuisineName) VALUES ('International');
INSERT INTO Cuisine (CuisineName) VALUES ('Irish');
INSERT INTO Cuisine (CuisineName) VALUES ('Italian');
INSERT INTO Cuisine (CuisineName) VALUES ('Japanese');
INSERT INTO Cuisine (CuisineName) VALUES ('Jewish');
INSERT INTO Cuisine (CuisineName) VALUES ('Latin');
INSERT INTO Cuisine (CuisineName) VALUES ('Moroccan');
INSERT INTO Cuisine (CuisineName) VALUES ('Peruvian');
INSERT INTO Cuisine (CuisineName) VALUES ('Polish');
INSERT INTO Cuisine (CuisineName) VALUES ('Russian');
INSERT INTO Cuisine (CuisineName) VALUES ('South American');
INSERT INTO Cuisine (CuisineName) VALUES ('Spanish');
INSERT INTO Cuisine (CuisineName) VALUES ('Thai');
INSERT INTO Cuisine (CuisineName) VALUES ('Turkish');
INSERT INTO Cuisine (CuisineName) VALUES ('Vegan');
INSERT INTO Cuisine (CuisineName) VALUES ('Vegetarian');
INSERT INTO Cuisine (CuisineName) VALUES ('Venezualan');
INSERT INTO Cuisine (CuisineName) VALUES ('Vietnamese');
INSERT INTO Cuisine (CuisineName) VALUES ('Wine');

INSERT INTO City (CityName, CityPopulation, CityDescription, CityCountry, CityHistory, CityLanguage, CityImage) VALUES ('Buenos Aires',14902908,'Buenos Aires, is Argentina’s big, cosmopolitan capital city. Its center is the Plaza de Mayo, lined with stately 19th-century buildings including Casa Rosada, the iconic, balconied presidential palace. Other major attractions include Teatro Colón, a grand 1908 opera house with nearly 2,500 seats, and the modern MALBA museum, displaying Latin American art.','Argentina','The city of Buenos Aires was founded twice. It was first founded in 1536 by an expedition led by the Spaniard Pedro de Mendoza, who named it Nuestra Señora Santa María del Buen Aire (“Our Lady St. Mary of the Good Air”). He was made the first governor-general of the Río de la Plata region.','Spanish','bsas.png');
INSERT INTO City (CityName, CityPopulation, CityDescription, CityCountry, CityHistory, CityLanguage, CityImage) VALUES ('Las Vegas',632912,'Las Vegas, officially the City of Las Vegas and often known simply as Vegas, is the 28th-most populated city in the United States, the most populated city in the state of Nevada, and the county seat of Clark County. The city anchors the Las Vegas Valley metropolitan area and is the largest city within the greater Mojave Desert. Las Vegas is an internationally renowned major resort city, known primarily for its gambling, shopping, fine dining, entertainment, and nightlife. The Las Vegas Valley as a whole serves as the leading financial, commercial, and cultural center for Nevada.','U.S.A','Las Vegas was founded as a city in 1905, when 110 acres (45 ha) of land adjacent to the Union Pacific Railroad tracks were auctioned in what would become the downtown area. In 1911, Las Vegas was incorporated as a city.','English','vegas.png');

INSERT INTO Hotel (HotelName, CityID, HotelDescription, HotelAddress, HotelNeighbourhood, HotelWebsite, HotelRating, HotelPrice, HotelClass, HotelPhone, HotelImage) VALUES ('VAIN Boutique Hotel',1,'Located in the heart of Palermo Viejo neighborhood, only 15 minutes away from the main tourist attractions, VAIN Boutique Hotel gives the possibility of having another alternative to the noisy BA downtown. It preserves the Porteño neighborhood feeling, combined with a bohemian and avant-garde mixture that can be sensed in the variety of stores, from fashion designers, antique and design furniture to coffee shops, fashion restaurants and bars, along with the traditional ones.','Thames 2226, 1414 Palermo Viejo, Distrito Federal','Palermo Viejo','http://www.vainhotel.com/',4.1,3.1,4,'+54-11-4776-8246','vainhotel.png');


INSERT INTO RestaurantBar (RestaurantBarName, CityID, RestaurantBarDescription, RestaurantBarAddress, RestaurantBarNeighbourhood, RestaurantBarWebsite, RestaurantBarOpeningHours, RestaurantBarDiningHours, RestaurantBarRating, RestaurantBarPrice, RestaurantBarMichelinStars, RestaurantBarImage, RestaurantBarPhone, RestaurantBarWheelchairAccess) VALUES ('Sarkis',1,'Sarkis is one of the most popular restaurants in Buenos Aires. Sarkis offer Middle Eastern cuisine of a high quality at very reasonable prices. The results, however are long waiting times for a seat. Once you get a table though, you will not be disappointed.','Thames 1101, 1414 Villa Crespo, Distrito Federal','Villa Crespo','https://www.facebook.com/pages/Sarkis/156339884415152','Mon-Sun 12:00-15:00\nMon-Sun 20:00-01:00','Mon-Sun 12:00-15:00\nMon-Sun 20:00-01:00',4.5,2.2,0,'sarkis.png','+54-11-4772-4991',1);
