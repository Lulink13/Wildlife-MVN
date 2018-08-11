USE [wildlife]
GO

/****** Object:  Table [db_owner].[Cellules]    Script Date: 11/08/2018 12:05:48 ******/
IF OBJECT_ID('wildlife.Cellules','U') IS NOT NULL
	DROP TABLE [db_owner].[Cellules];
GO

/****** Object:  Table [db_owner].[Cellules]    Script Date: 11/08/2018 12:05:48 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [db_owner].[Cellules](
	[IDCellule] [int] IDENTITY(1,1) NOT NULL,
	[IDCarte] [smallint] NOT NULL,
	[IDBiome] [tinyint] NOT NULL,
	[CoordX] [smallint] NOT NULL,
	[CoordY] [smallint] NOT NULL,
	[Humidite] [tinyint] NOT NULL,
	[Vegetation] [tinyint] NOT NULL,
    CONSTRAINT [PK_Cellulles] PRIMARY KEY CLUSTERED ([IDCellule] ASC) WITH (PAD_INDEX = OFF, 
																			STATISTICS_NORECOMPUTE = OFF, 
																			IGNORE_DUP_KEY = OFF, 
																			ALLOW_ROW_LOCKS = ON, 
																			ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

