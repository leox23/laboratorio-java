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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` int NOT NULL,
  `text` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,1,'¿Qué día pisó Armstrong la Luna?'),(2,1,'¿Cuál es la estrella más cercana al sistema solar?'),(3,1,'¿En qué siglo se inventó el primer telescopio?'),(4,1,'¿Es cierto que se puede ver la Estación Espacial Internacional desde la Tierra sin necesidad de telescopios?'),(5,1,'¿Sabes cómo se llama y dónde se encuentra la montaña más alta del sistema solar?'),(6,2,'¿A qué fenómeno alude el término \"nova\"?'),(7,2,'¿Sabes qué temperaturas se pueden llegar a alcanzar en el Sol?'),(8,2,'¿Qué nombre recibe la región del sistema solar comprendida entre las órbitas de Marte y Júpiter?'),(9,2,'¿A qué corresponde una Unidad Astronómica (UA)?'),(10,2,'¿Sabes cuál es el objeto fabricado por el hombre que actualmente se encuentra más alejado de la Tierra?'),(11,3,'¿Cuál de estos cuerpos celestes no es una luna del planeta Júpiter?'),(12,3,'¿Cómo se llama el proyecto destinado a la búsqueda de vida inteligente más allá de la Tierra?'),(13,3,'¿Qué sistema estelar recibe su nombre de un conocido literato universal?'),(14,3,'¿Cuál es la estrella mas grande conocida por el ser humano?'),(15,3,'¿Sabes en qué nebulosa se encuentran los Pilares de la Creación?'),(16,4,' ¿Que porcentaje del  universo está compuesto de materia oscura?'),(17,4,'¿Qué son las ondas gravitacionales?'),(18,4,'¿Qué es un púlsar?'),(19,4,'¿Cuántos eclipses como mínimo pueden producirse en un año?'),(20,4,'Uno de estos objetos celestes no existe en el mundo real'),(21,5,'El sistema estelar más cercano al Sol es sin duda...'),(22,5,'¿Cada cuántos años pasa el cometa Halley por la Tierra?'),(23,5,'¿En que año podría haber un fenómeno solar catastrófico en la Tierra?'),(24,5,'¿Cómo se distinguen las estrellas Wolf-Rayet?'),(25,5,'¿Cual de estas no es una agencia espacial real?');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
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
