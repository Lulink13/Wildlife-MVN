/*

 Script de création de la base de données WildLife 2018
 Pour SQL Server 2017 
 Jaycee, sur la base du travail de Lulink
 
 
 Script Version 0.2
*/


/*  T-SQL before SQL Server 2016 
IF EXISTS(SELECT name FROM sys.databases WHERE name = 'wildlife')
	DROP DATABASE wildlife;
GO
*/

/* T-SQL since SQL Server 2016*/
DROP DATABASE IF EXISTS wildlife;
GO

CREATE DATABASE wildlife;
GO




/*
	Tables
*/

/*
IF OBJECT_ID('wildlife', 'U') IS NOT NULL
  DROP TABLE <schema_name, sysname, dbo>.<table_name, sysname, sample_table>
GO
*/

IF OBJECT_ID('wildlife.Cartes','U') IS NOT NULL
	DROP TABLE wildlife.Cartes;
GO
/*
IF EXISTS(SELECT * FROM wildlife.INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'wildlife.Cartes')
	BEGIN
	DROP TABLE wildlife.Cartes CASCADE;
	COMMIT;
	END
GO
*/

CREATE TABLE wildlife.Cartes (	IDCarte 		SMALLINT IDENTITY(0,1) PRIMARY KEY,
								NomCarte 		VARCHAR(15),
								Largeur 		SMALLINT,
								Auteur 			VARCHAR(15));
GO


IF OBJECT_ID('wildlife.Biomes','U') IS NOT NULL
	DROP TABLE wildlife.Biomes;
GO						
CREATE TABLE Biomes (	IDBiome 		TINYINT IDENTITY(0,1) PRIMARY KEY,
						NomBiome 		VARCHAR(15),
						HumiditeBase 	TINYINT,
						VegetationBase 	TINYINT);
GO


IF OBJECT_ID('wildlife.Cellules','U') IS NOT NULL
	DROP TABLE wildlife.Cellules;
GO
CREATE TABLE Cellules (	IDCellule		INTEGER IDENTITY(0,1) PRIMARY KEY,
						IDCarte 		SMALLINT,
						CoordX 			SMALLINT,
						CoordY 			SMALLINT,
						IDBiome 		TINYINT DEFAULT 0,
						Humidite 		TINYINT,
						Vegetation 		TINYINT);



/*
	Clés étrangères
*/
ALTER TABLE Cellules ADD CONSTRAINT FK_IDBiome FOREIGN KEY (IDBiome) REFERENCES Biomes (IDBiome) ON DELETE SET DEFAULT;
ALTER TABLE Cellules ADD CONSTRAINT FK_IDCarte FOREIGN KEY (IDCarte) REFERENCES Cartes (IDCarte) ON DELETE CASCADE;
GO
