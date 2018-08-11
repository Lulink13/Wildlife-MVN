USE [wildlife]
GO

/****** Object:  Table [db_owner].[Biomes]    Script Date: 11/08/2018 12:05:26 ******/
IF OBJECT_ID('wildlife.Biomes','U') IS NOT NULL
	DROP TABLE [db_owner].[Biomes];
GO

/****** Object:  Table [db_owner].[Biomes]    Script Date: 11/08/2018 12:05:26 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [db_owner].[Biomes](
	[IDBiome] [tinyint] IDENTITY(1,1) NOT NULL,
	[NomBiome] [varchar](15) NOT NULL,
	[HumiditeBase] [tinyint] NOT NULL,
	[VegetationBase] [tinyint] NOT NULL,
    CONSTRAINT [PK_Biomes] PRIMARY KEY CLUSTERED ( [IDBiome] ASC ) WITH (PAD_INDEX = OFF, 
																		 STATISTICS_NORECOMPUTE = OFF, 
																		 IGNORE_DUP_KEY = OFF, 
																		 ALLOW_ROW_LOCKS = ON, 
																		 ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

