USE [wildlife]
GO

/****** Object:  Table [db_owner].[Cartes]    Script Date: 11/08/2018 12:04:57 ******/
IF OBJECT_ID('wildlife.Cartes','U') IS NOT NULL
	EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'db_owner', @level1type=N'TABLE',@level1name=N'Cartes', @level2type=N'COLUMN',@level2name=N'IDCarte'
	DROP TABLE [db_owner].[Cartes];
GO
/*
DROP TABLE [db_owner].[Cartes]
GO
*/

/****** Object:  Table [db_owner].[Cartes]    Script Date: 11/08/2018 12:04:57 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [db_owner].[Cartes](
	[IDCarte] [smallint] IDENTITY(1,1) NOT NULL,
	[NomCarte] [varchar](15) NOT NULL,
	[Largeur] [smallint] NOT NULL,
	[Auteur] [varchar](15) NULL,
	 CONSTRAINT [PK_Cartes] PRIMARY KEY CLUSTERED ( [IDCarte] ASC ) WITH (PAD_INDEX = OFF, 
																		  STATISTICS_NORECOMPUTE = OFF, 
																		  IGNORE_DUP_KEY = OFF, 
																		  ALLOW_ROW_LOCKS = ON, 
																		  ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
	) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Integer d''identification' , @level0type=N'SCHEMA',@level0name=N'db_owner', @level1type=N'TABLE',@level1name=N'Cartes', @level2type=N'COLUMN',@level2name=N'IDCarte'
GO

