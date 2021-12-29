-- MySQL dump 10.13  Distrib 5.7.22, for Win64 (x86_64)
--
-- Host: localhost    Database: restbd
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `armadora`
--

DROP TABLE IF EXISTS `armadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `armadora` (
  `clave` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `nPlantas` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `paisOrigen` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`clave`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armadora`
--

LOCK TABLES `armadora` WRITE;
/*!40000 ALTER TABLE `armadora` DISABLE KEYS */;
INSERT INTO `armadora` VALUES ('BMW',0,'BMW European cars Corporation','Alemania'),('Ferrari',0,'Ferrari International','Italia'),('Fiat',1,'Fabbrica Italiana Automobili Torino','Italia'),('Ford',1,'Ford Motor Company','EUA'),('GM',2,'General Motors Company','EUA'),('KIA',0,'KIA International Inc.','Corea del Sur'),('Lamborghini',0,'Lamborghini International','Italia'),('MB',2,'Daimler Mercedes Benz','Alemania'),('Peugeot',1,'Peugeot S.A.','Francia'),('Renault',1,'Groupe Renault','Francia'),('Seat',1,'Sociedad Española de Autos de Turismo','España'),('Tesla',0,'Tesla Motors','EUA'),('Volvo',0,'Volvo cars','Suecia'),('VW',1,' Volkswagen Nutzfahrzeuge','Alemania');
/*!40000 ALTER TABLE `armadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modeloauto`
--

DROP TABLE IF EXISTS `modeloauto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modeloauto` (
  `claveModelo` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `importado` bit(1) NOT NULL,
  `nombre` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `version` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `claveArmadora` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`claveModelo`),
  KEY `FKfjwyalt39yfbmxxgp8n2a2af6` (`claveArmadora`),
  CONSTRAINT `FKfjwyalt39yfbmxxgp8n2a2af6` FOREIGN KEY (`claveArmadora`) REFERENCES `armadora` (`clave`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modeloauto`
--

LOCK TABLES `modeloauto` WRITE;
/*!40000 ALTER TABLE `modeloauto` DISABLE KEYS */;
INSERT INTO `modeloauto` VALUES ('500','','Fiat 500 Diabolo','200 Caballos Turbo','Fiat'),('GolfGTI','','Golf GTI DSG','Turbo GTI Stronic','VW'),('Jetta','\0','Jetta A4 Trendline','Automatic','VW'),('LoboHD','','Lobo Harley Davidson','Harley Davidson','Ford'),('Mustang','','Mustang GT 500','500 Caballos','Ford'),('Panda','\0','Fiat Panda','Estándar','Fiat'),('Spark','\0','Spark Std Aus','Estándar austero','GM'),('X3','','Serie 3 SUV','Luxe','BMW');
/*!40000 ALTER TABLE `modeloauto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-22 22:38:35
