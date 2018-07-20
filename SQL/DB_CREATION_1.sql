/*

 Script de création de la base de données WildLife 2018
 Pour SQL Server 2017 
 Jaycee, sur la base du travail de Lulink
 
 
 Script Version 0.1
*/

DROP DATABASE wildlife;
CREATE DATABASE wildlife;
GO

CREATE TABLE Cartes (	IDCarte 	SMALLINT IDENTITY(0,1),
						NomCarte 	VARCHAR(15),
						Largeur 	SMALLINT,
						Auteur 		VARCHAR(15));

CREATE TABLE Cellules (	IDCellule	INTEGER IDENTITY(0,1),
						IDCarte 	SMALLINT,
						CoordX 		SMALLINT,
						CoordY 		SMALLINT,
						IDBiome 	TINYINT,
						Humidite 	TINYINT,
						Vegetation 	TINYINT);

CREATE TABLE Biomes (	IDBiome 		SMALLINT IDENTITY(0,1),
						NomBiome 		VARCHAR(15),
						HumiditeBase 	TINYINT,
						VegetationBase 	TINYINT);
GO
