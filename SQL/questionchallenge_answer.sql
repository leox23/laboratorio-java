-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: questionchallenge
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `isRigth` tinyint NOT NULL,
  `question_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `question_fk_idx` (`question_id`),
  CONSTRAINT `question_fk` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'16 julio de 1969',0,1),(2,'21 julio de 1969',1,1),(3,'4 julio de 1969',0,1),(4,'18 octubre de 1969',0,1),(5,'La Estrella Polar',0,2),(6,'Próxima Centauri',1,2),(7,'Pólux',0,2),(8,'Aorus',0,2),(9,'Siglo IX',0,3),(10,'Siglo XII',0,3),(11,'Siglo XVII',1,3),(12,'Siglo XIX',0,3),(13,'Imposible, siempre se necesita un telescopio, aunque sea pequeño',0,4),(14,'No se puede ver ni siquiera con el mejor de los telescopios de aficionados',0,4),(15,'Sí, se puede ver a ciertas horas, pero debes conocer la trayectoria y la hora exactas',1,4),(16,'La estacion espacial dejo de exitir en 2018',0,4),(17,'El Monte Olimpo, en Marte',1,5),(18,'El Altar de Zeus, en Júpiter',0,5),(19,'La Morada de los Titanes, en Júpiter',0,5),(20,'El Monte Kilimanjaro, en Marte',0,5),(21,'A la muerte de una estrella',1,6),(22,'Al nacimiento de una estrella',0,6),(23,'A la formación de nuevas galaxias',0,6),(24,'El choque de dos estrellas',0,6),(25,'2.000.000 ºC',0,7),(26,'10.000.000 ºC',0,7),(27,'15.000.000 ºC',1,7),(28,'90.000.000 ºC',0,7),(29,'Cinturón de asteroides',1,8),(30,'Cinturón de Kuiper',0,8),(31,'Cinturón de Orión',0,8),(32,'Anillo de Elden',0,8),(33,'A un año luz',0,9),(34,'A la distancia entre la Tierra y el Sol',1,9),(35,'La distancia entre el Sol y el centro de la Vía Láctea',0,9),(36,'La distancia entre la Via Lactea y Andromeda',0,9),(37,'Sonda espacial Cassini',0,10),(38,'Sonda espacial Voyager 1',1,10),(39,'El Halcón Milenario',0,10),(40,'Sonda espacial Apolo 18',0,10),(41,'Ío',0,11),(42,'Europa',0,11),(43,'Ganímedes',0,11),(44,'Deimos',1,11),(45,'Proyecto Área 51',0,12),(46,'Proyecto SETI',1,12),(47,'Proyecto Isaac Asimov',0,12),(48,'Proyecyo NASA ET',0,12),(49,'Sistema Cervantes',1,13),(50,'Sistema de Ernest Hemingway',0,13),(51,'Sistema de William Shakespeare',0,13),(52,'Sistema Garcia Marquez',0,13),(53,'Arcturus',0,14),(54,'UY Scuti',1,14),(55,'VY Canis Majoris',0,14),(56,'Solaria 2',0,14),(57,'La nebulosa del Águila',1,15),(58,'La nebulosa del Dragón',0,15),(59,'La nebulosa del Reloj de Arena',0,15),(60,'La nebulosa del Cangrejo',0,15),(61,'23%',1,16),(62,'60%',0,16),(63,'3%',0,16),(64,'18%',0,16),(65,'Son emisiones de polvo y gas que se producen entre objetos más allá de los confines de nuestro sistema solar',0,17),(66,'Son producidas por grandes llamaradas solares y generan interferencias en la tecnología terrestre',0,17),(67,'Son vibraciones que deforman el espacio-tiempo, la materia de la que está hecha el universo',1,17),(68,'Son las vibraciones que produce la luna sobre el agua de la tierra',0,17),(69,'Una estrella de neutrones pequeña que gira a gran velocidad.',1,18),(70,'Un tipo especial de telescopio que se usa para fotografiar cometas.',0,18),(71,'Un objeto astronómico de energía electromagnética extremadamente luminoso y distante.',0,18),(72,'La expulsion de energia que produce un agujero negro',0,18),(73,'4',1,19),(74,'0',0,19),(75,'16',0,19),(76,'2',0,19),(77,'Plutón, Makemake, Deimos.',0,20),(78,'Ceres, Manaan, Fobos.',1,20),(79,'Eris, Haumea, Pandora.',0,20),(80,'Pan,Dafne,Jano',0,20),(81,'Procyon',0,21),(82,'Polaris',0,21),(83,'Alfa Centauri',1,21),(84,'Sirio',0,21),(85,'Cada 100 años',0,22),(86,'Cada 75 años',1,22),(87,'Cada 50 años',0,22),(88,'Cada 16 años',0,22),(89,'2024',1,23),(90,'2036',0,23),(91,'2222',0,23),(92,'2058',0,23),(93,'Porque son muy azules y su pico de emisión está situado en los rayos ultravioleta.',1,24),(94,'Porque son muy rojas y su pico de emisión está situado en los rayos gamma.',0,24),(95,'Porque son muy azules y su pico de emisión está situado en los rayos X.',0,24),(96,'Porque son muy rojas y su pico de emisión está situado en los rayos Betha.',0,24),(97,'NASA',0,25),(98,'ESA',0,25),(99,'JAXA',0,25),(100,'ASCA',1,25);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-22  1:09:28
