CREATE DATABASE solarsystem;

USE solarsystem;

CREATE TABLE planet(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50),
  description VARCHAR(255),
  type ENUM('tellurique','gazeuse','naine'),
  PRIMARY KEY(id)
);

-- planètes telluriques
INSERT INTO planet (name, description, type) 
  VALUES ('Terre','Planète petite, très proche du soleil et composée de roche','tellurique');
INSERT INTO planet (name, description, type) 
  VALUES ('Vénus','Planète petite, très proche du soleil et composée de roche','tellurique');
INSERT INTO planet (name, description, type) 
  VALUES ('Mercure','Planète petite, très proche du soleil et composée de roche', 'tellurique');
INSERT INTO planet (name, description, type) 
  VALUES ('Mars','Planète petite, très proche du soleil et composée de roche','tellurique');

-- planètes gazeuses
INSERT INTO planet (name, description, type) 
  VALUES ('Jupiter','Planète avec un gros diamètre. Plus éloignée du soleil. Composée principalement de gaz.','gazeuse');
INSERT INTO planet (name, description, type) 
  VALUES ('Saturne','Planète avec un gros diamètre. Plus éloignée du soleil. Composée principalement de gaz.','gazeuse');
INSERT INTO planet (name, description, type) 
  VALUES ('Uranus','Planète avec un gros diamètre. Plus éloignée du soleil. Composée principalement de gaz.','gazeuse');
INSERT INTO planet (name, description, type) 
  VALUES ('Neptune','Planète avec un gros diamètre. Plus éloignée du soleil. Composée principalement de gaz.','gazeuse');
  
-- planètes naines
INSERT INTO planet (name, description, type) 
  VALUES  ('Pluton','Corps céleste en orbite autour du soleil possédant une masse suffisante pour que sa gravité l\'emporte sur les forces de cohésion du corps solide et le maintienne en équilibre hydrostatique','naine');
INSERT INTO planet (name, description, type) 
  VALUES  ('Makemake','Corps céleste en orbite autour du soleil possédant une masse suffisante pour que sa gravité l\'emporte sur les forces de cohésion du corps solide et le maintienne en équilibre hydrostatique','naine');
INSERT INTO planet (name, description, type) 
  VALUES  ('Cérès','Corps céleste en orbite autour du soleil possédant une masse suffisante pour que sa gravité l\'emporte sur les forces de cohésion du corps solide et le maintienne en équilibre hydrostatique','naine');
INSERT INTO planet (name, description, type) 
  VALUES  ('Éris','Corps céleste en orbite autour du soleil possédant une masse suffisante pour que sa gravité l\'emporte sur les forces de cohésion du corps solide et le maintienne en équilibre hydrostatique','naine');
INSERT INTO planet (name, description, type) 
  VALUES  ('Haumea','Corps céleste en orbite autour du soleil possédant une masse suffisante pour que sa gravité l\'emporte sur les forces de cohésion du corps solide et le maintienne en équilibre hydrostatique','naine');
  
CREATE TABLE satellite(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	idPlanet INT NOT NULL,
	FOREIGN KEY (idPlanet) REFERENCES planet(id),
	PRIMARY KEY(id)
);

-- Terre
INSERT INTO satellite (name, idPlanet) VALUES ('La lune',1);
-- Mars
INSERT INTO satellite (name, idPlanet) VALUES ('Phobos',4);
INSERT INTO satellite (name, idPlanet) VALUES ('Deïmos',4);
-- Jupiter
INSERT INTO satellite (name, idPlanet) VALUES ('Europe',5);
INSERT INTO satellite (name, idPlanet) VALUES ('Ganymède',5);
INSERT INTO satellite (name, idPlanet) VALUES ('Callisto',5);
INSERT INTO satellite (name, idPlanet) VALUES ('Elara',5);
INSERT INTO satellite (name, idPlanet) VALUES ('Léda',5);
INSERT INTO satellite (name, idPlanet) VALUES ('Métis',5);
-- Saturne
INSERT INTO satellite (name, idPlanet) VALUES ('Mimas',6);
INSERT INTO satellite (name, idPlanet) VALUES ('Dioné',6);
INSERT INTO satellite (name, idPlanet) VALUES ('Titan',6);
INSERT INTO satellite (name, idPlanet) VALUES ('Japet',6);
INSERT INTO satellite (name, idPlanet) VALUES ('Kari',6);
INSERT INTO satellite (name, idPlanet) VALUES ('Tarqeq',6);
INSERT INTO satellite (name, idPlanet) VALUES ('Aegaeon',6);
-- Uranus
INSERT INTO satellite (name, idPlanet) VALUES ('Cordelia',7);
INSERT INTO satellite (name, idPlanet) VALUES ('Ophelie',7);
INSERT INTO satellite (name, idPlanet) VALUES ('Bianca',7);
INSERT INTO satellite (name, idPlanet) VALUES ('Juliette',7);
INSERT INTO satellite (name, idPlanet) VALUES ('Portia',7);
INSERT INTO satellite (name, idPlanet) VALUES ('Mab',7);
INSERT INTO satellite (name, idPlanet) VALUES ('Obéron',7);
INSERT INTO satellite (name, idPlanet) VALUES ('Margaret',7);
-- Neptune
INSERT INTO satellite (name, idPlanet) VALUES ('Triton',8);
INSERT INTO satellite (name, idPlanet) VALUES ('Néréïde',8);
INSERT INTO satellite (name, idPlanet) VALUES ('Naïade',8);
INSERT INTO satellite (name, idPlanet) VALUES ('Thalassa',8);
INSERT INTO satellite (name, idPlanet) VALUES ('Despina',8);
INSERT INTO satellite (name, idPlanet) VALUES ('Galatée',8);
INSERT INTO satellite (name, idPlanet) VALUES ('Larissa',8);
-- Pluton
INSERT INTO satellite (name, idPlanet) VALUES ('Charon',9);
INSERT INTO satellite (name, idPlanet) VALUES ('Nix',9);
INSERT INTO satellite (name, idPlanet) VALUES ('Hydra',9);
INSERT INTO satellite (name, idPlanet) VALUES ('Kerberos',9);
INSERT INTO satellite (name, idPlanet) VALUES ('Styx',9);

-- Makemake
INSERT INTO satellite (name, idPlanet) VALUES ('MK2',10);

-- Eris
INSERT INTO satellite (name, idPlanet) VALUES ('Dysnomie',12);

-- Hauméa
INSERT INTO satellite (name, idPlanet) VALUES ('Namaka',13);
INSERT INTO satellite (name, idPlanet) VALUES ('Hi\'iaka',13);

--  Périphélie : 
--  point de la trajectoire d'un objet céleste en orbite héliocentrique qui est le plus proche du Soleil autour duquel il tourne.
CREATE TABLE comet(
	id INT NOT NULL AUTO_INCREMENT,
	designation VARCHAR(50),
	name VARCHAR(50),
	nextPeriphelieDate DATE,
	revolutionPeriod DOUBLE,
	PRIMARY KEY(id)
);

INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('148P/1963 W1','Anderson-LINEAR 1','1963-10-28',7.85);
INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('177P/1889 M1','Barnard 2','1889-06-21',117.36);
INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('95P/1977 UB','Chiron','1996-02-14',50.7);
INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('P/1998 Y2','Li 1','1998-12-17',15.1);
INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('P/1999 U3','LINEAR 7','1999-11-18',10.7);
INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('150P/2000 WT168','LONEOS 3','2001-03-23',7.66);
INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('115P/1985 Q1','Maury 1','1985-06-08',8.84);
INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('P/1998 U2','Mueller 6','1998-10-20',8.71);
INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('P/2001 T3','NEAT 7','2002-02-01',16.6);
INSERT INTO comet (designation, name, nextPeriphelieDate, revolutionPeriod) 
	VALUES ('94P/1984 E1','Russel 4','1984-01-05',6.39);
	
CREATE TABLE astronaut(
	id int NOT NULL,
	age int NOT NULL,
	firstname VARCHAR(30),
	lastname VARCHAR(30)
);
	




 