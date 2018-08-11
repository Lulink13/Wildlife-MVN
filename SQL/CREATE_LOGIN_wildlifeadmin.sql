USE [master]
GO

/****** Object:  Login [wildlifeadmin]    Script Date: 11/08/2018 12:00:01 ******/
DROP LOGIN [wildlifeadmin]
GO

/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [wildlifeadmin]    Script Date: 11/08/2018 12:00:01 ******/
CREATE LOGIN [wildlifeadmin] WITH PASSWORD=N's6T2+gPP/gvT7qnHH50T3cnEblvcZc4olrkdw1E/or0=', DEFAULT_DATABASE=[wildlife], DEFAULT_LANGUAGE=[Français], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO

ALTER LOGIN [wildlifeadmin] DISABLE
GO

ALTER SERVER ROLE [dbcreator] ADD MEMBER [wildlifeadmin]
GO


