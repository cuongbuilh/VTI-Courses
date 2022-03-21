-- MariaDB dump 10.19  Distrib 10.5.12-MariaDB, for Linux (x86_64)
--
-- Host: mysql.hostinger.ro    Database: u574849695_25
-- ------------------------------------------------------
-- Server version	10.5.12-MariaDB-cll-lve

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` enum('Admin','HR','IT','Delivery') COLLATE utf8_unicode_ci DEFAULT NULL,
  `Description` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Delivery','Dolores quas unde in et. Numquam nemo enim temporibus occaecati.','1974-09-17 22:30:39','2004-06-19 04:02:46'),(2,'Delivery','Aliquam error porro dolore eius dicta. Sint tempore quos beatae provident ut nihil omnis eius. Cupiditate hic distinctio voluptas ut. Excepturi aperiam dolores quia explicabo quidem consequatur.','2010-01-10 02:15:44','2000-07-21 23:05:46'),(3,'HR','Et magnam doloremque necessitatibus accusamus dolorem tenetur blanditiis. Distinctio nobis et a reiciendis enim. Illum omnis occaecati velit dolorum eum ipsum sed.','2011-09-30 17:30:37','2009-09-09 09:56:19'),(4,'Delivery','Non et maxime vitae in harum. Velit et aliquam ut quidem facilis quia. Iste ut rerum perferendis. Veniam vero rerum qui sunt eius nesciunt blanditiis optio. Eum maiores quisquam voluptas nihil iste rerum.','1978-02-13 07:14:19','1978-03-14 05:12:29'),(5,'Delivery','Dolores accusantium tempore ut et quo et. Dolore in quia dolores ut occaecati velit laboriosam vel. Accusantium ullam est doloribus ex. Doloribus sed ad corrupti.','2008-05-06 11:46:42','1998-09-12 18:32:10'),(6,'HR','Impedit beatae sit ea doloremque rem ea. Impedit amet non id exercitationem. Et quia impedit tempora sunt. Non facere quia ullam saepe. Sit impedit voluptatibus consequatur illum maxime.','2019-06-30 21:46:15','1987-01-09 11:00:14'),(7,'IT','Quidem ut occaecati molestiae non dignissimos est at et. Rem eligendi tempora quae earum. Eligendi nobis facilis quia ipsum suscipit labore ea. Aperiam vitae facere ea ex ad error odio.','1986-08-22 23:14:34','2014-11-30 15:58:03'),(8,'Delivery','Quam et libero autem sint doloribus. Ut voluptatum et qui distinctio molestias. Quo et expedita quia odit. Et ipsam est porro eum optio eligendi maiores ea.','1998-10-07 02:35:05','2019-11-09 01:59:55'),(9,'Delivery','Atque earum aut aut est sunt architecto odit. Sed rerum facere similique illo est. Odit aut nihil ut ducimus exercitationem quam.','1970-04-11 21:27:29','1990-11-19 15:21:46'),(10,'Delivery','Ut mollitia harum aliquam quia veritatis facere rerum. Possimus necessitatibus et distinctio nulla neque sed at delectus. Distinctio provident est cupiditate aliquam velit.','1987-04-05 02:49:14','1995-08-04 11:00:35'),(11,'HR','Assumenda facere ducimus aut et dolore sed. Aut minima soluta maiores et quidem et. Animi similique voluptatibus ducimus officia vero qui.','2007-12-15 01:51:24','1992-02-02 09:48:14'),(12,'HR','Molestias nam dolorem quos iste velit nostrum ratione. Et pariatur veritatis dicta. Quia veniam voluptatum mollitia.','1977-12-03 13:45:45','1995-09-07 23:13:53'),(13,'Delivery','Vel iste nihil unde maxime corrupti rerum velit. Consequatur et tempora et excepturi vel. Tempora iusto accusantium voluptates corrupti architecto omnis quas aut.','2011-07-26 11:22:10','1993-08-05 18:53:35'),(14,'IT','Omnis veniam nam vero nihil ut maiores. Explicabo nihil nesciunt optio porro quidem officiis repellendus nobis.','2016-08-30 07:01:01','1992-06-10 10:26:41'),(15,'IT','Itaque consectetur itaque enim laboriosam. Ullam autem vero ea possimus voluptatem aspernatur ut ea. Est excepturi odio tempore ut.','2010-02-06 23:36:48','2001-09-07 03:44:08'),(16,'HR','Reprehenderit omnis est laboriosam. Repellendus facere cumque id porro incidunt id. Sit consequatur cumque voluptate occaecati. Ab provident rerum earum reiciendis.','2006-07-10 13:07:59','1976-08-04 14:46:38'),(17,'Admin','Voluptates repudiandae laudantium voluptatem odio. Et atque officia ipsa sint adipisci nemo asperiores. Id placeat quo perspiciatis dignissimos sunt itaque dolores.','1980-05-22 07:31:21','1971-11-03 11:09:22'),(18,'Delivery','Consequuntur iusto error est est quis illo. Repellendus nisi illo aspernatur illo voluptates. Pariatur voluptatem illum ad et. Iusto placeat itaque et repudiandae nulla.','1973-03-06 07:56:46','1998-11-22 05:18:36'),(19,'HR','Neque iste rem dolore harum. Dignissimos nisi maxime quia quia quidem ut reiciendis. Aliquam qui reprehenderit odio distinctio delectus.','1997-05-08 15:04:53','2016-10-13 19:11:56'),(20,'IT','Sapiente sit et voluptatum qui. Consectetur id et pariatur dignissimos dolores veniam. Totam laudantium qui maxime quo dolor.','2005-01-07 12:59:39','1987-12-29 06:43:32');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'et','2007-09-18 08:54:02','2021-03-17 01:11:53'),(2,'labore','1978-12-12 09:10:30','2010-01-14 18:21:17'),(3,'perferendis','2014-04-16 16:07:52','1976-01-02 15:27:12'),(4,'et','1986-12-31 06:23:18','1974-03-22 14:11:08'),(5,'cum','2008-04-29 08:43:10','1975-02-17 14:08:25'),(6,'eveniet','1994-08-04 04:08:49','2010-09-24 09:36:25'),(7,'ut','1978-01-10 23:07:10','2002-06-22 08:33:45'),(8,'nesciunt','1989-10-23 03:37:30','1970-02-19 23:59:16'),(9,'sit','2008-01-02 18:49:32','1989-01-20 16:38:12'),(10,'laudantium','2011-10-26 18:11:49','1986-03-05 02:35:37'),(11,'ducimus','1971-01-25 19:00:40','1993-03-02 11:32:19'),(12,'dolorum','1976-09-24 19:21:27','2001-10-12 01:09:21'),(13,'magnam','1996-05-20 03:28:23','1986-12-02 14:18:01'),(14,'aut','2021-12-29 14:24:05','2001-06-14 13:21:05'),(15,'excepturi','2012-03-01 08:08:28','2006-11-24 09:45:33'),(16,'sunt','1992-08-03 01:04:54','2012-05-08 01:53:14'),(17,'perferendis','2018-06-14 14:27:29','1972-04-30 08:09:34'),(18,'aliquid','2005-04-23 12:16:21','2012-02-25 21:52:05'),(19,'eligendi','2019-08-20 11:11:15','1979-11-26 18:13:22'),(20,'ducimus','2008-08-25 06:54:32','1987-03-22 10:20:44');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary` (
  `salary_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role_id` int(11) DEFAULT NULL,
  `total_salary` double DEFAULT NULL,
  `month` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`salary_id`),
  KEY `user_role_id` (`user_role_id`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (1,1,NULL,NULL,'1983','2000-12-28 17:26:12','1990-03-10 15:18:32'),(2,2,NULL,NULL,'2020','2004-08-14 09:40:00','2011-08-15 11:50:13'),(3,3,NULL,NULL,'1996','2000-11-14 02:32:16','2005-09-05 22:04:02'),(4,4,NULL,NULL,'2001','1981-03-18 20:24:27','2017-08-01 02:40:36'),(5,5,NULL,NULL,'1983','2010-08-17 16:17:13','2016-04-25 14:56:53'),(6,6,NULL,NULL,'1971','1980-06-21 18:31:02','1974-11-21 10:59:42'),(7,7,NULL,NULL,'1998','2016-06-21 08:29:41','2015-06-14 01:46:47'),(8,8,NULL,NULL,'1971','2021-05-06 13:23:49','2003-10-20 12:29:32'),(9,9,NULL,NULL,'2018','2006-09-17 06:43:39','1983-10-12 06:47:41'),(10,10,NULL,NULL,'1980','2006-06-28 19:24:51','1994-08-09 02:41:34'),(11,11,NULL,NULL,'1976','1971-03-28 15:48:35','1982-08-26 18:00:50'),(12,12,NULL,NULL,'1972','2004-11-28 03:54:29','1985-03-24 14:58:52'),(13,13,NULL,NULL,'2018','2006-08-07 09:17:18','1979-05-05 15:04:12'),(14,14,NULL,NULL,'2017','1976-08-22 23:26:49','2012-02-15 00:56:15'),(15,15,NULL,NULL,'2004','1976-08-19 03:06:14','1979-02-21 04:40:03'),(16,16,NULL,NULL,'1970','1999-09-22 21:08:16','1979-03-14 09:58:01'),(17,17,NULL,NULL,'1978','1991-02-01 11:09:14','2017-09-12 17:27:20'),(18,18,NULL,NULL,'1977','1978-03-23 20:14:04','2006-06-06 20:52:43'),(19,19,NULL,NULL,'1979','2000-07-12 23:07:39','2018-08-25 02:38:54'),(20,20,NULL,NULL,'2011','1996-09-09 19:18:39','1983-03-09 17:22:28');
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_detail`
--

DROP TABLE IF EXISTS `salary_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary_detail` (
  `salary_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `salary_id` int(11) DEFAULT NULL,
  `salary_detail_type_id` int(11) DEFAULT NULL,
  `operation` enum('1','2','3','4') COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`salary_detail_id`),
  KEY `salary_id` (`salary_id`),
  KEY `salary_detail_type_id` (`salary_detail_type_id`),
  CONSTRAINT `salary_detail_ibfk_1` FOREIGN KEY (`salary_id`) REFERENCES `salary` (`salary_id`),
  CONSTRAINT `salary_detail_ibfk_2` FOREIGN KEY (`salary_detail_type_id`) REFERENCES `salary_detail_type` (`salary_detail_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_detail`
--

LOCK TABLES `salary_detail` WRITE;
/*!40000 ALTER TABLE `salary_detail` DISABLE KEYS */;
INSERT INTO `salary_detail` VALUES (1,22.7969474,1,1,'3'),(2,1.8,2,2,'1'),(3,7910705.8547442,3,3,'3'),(4,0,4,4,'1'),(5,0.02545,5,5,'3'),(6,205.506794388,6,6,'3'),(7,29193,7,7,'1'),(8,609.58692216,8,8,'4'),(9,854081.5244354,9,9,'3'),(10,178185323.62781,10,10,'1'),(11,1335231.590462,11,11,'1'),(12,5842952.45,12,12,'4'),(13,0,13,13,'3'),(14,473091,14,14,'4'),(15,39558788.236,15,15,'3'),(16,4.56815,16,16,'1'),(17,2.1062,17,17,'3'),(18,900791.8373279,18,18,'1'),(19,0.92,19,19,'1'),(20,5.39,20,20,'3');
/*!40000 ALTER TABLE `salary_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_detail_type`
--

DROP TABLE IF EXISTS `salary_detail_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary_detail_type` (
  `salary_detail_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `salary_detail_type_name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`salary_detail_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_detail_type`
--

LOCK TABLES `salary_detail_type` WRITE;
/*!40000 ALTER TABLE `salary_detail_type` DISABLE KEYS */;
INSERT INTO `salary_detail_type` VALUES (1,'blanditiis','1980-11-14 05:15:14','2010-07-12 15:05:55'),(2,'est','2010-04-08 07:36:43','2016-06-01 16:54:18'),(3,'eum','2010-06-09 12:31:49','2016-12-03 11:14:12'),(4,'voluptatib','1977-10-03 04:13:47','2014-12-25 10:38:12'),(5,'dignissimo','1985-11-21 14:36:18','1991-02-19 18:14:40'),(6,'qui','2010-01-20 04:08:36','1994-09-26 10:10:22'),(7,'vel','1987-08-27 00:03:31','1987-09-14 23:15:03'),(8,'et','2017-04-13 00:53:42','1976-06-11 22:17:26'),(9,'non','1989-09-25 10:33:04','2015-11-27 15:52:05'),(10,'sint','1999-02-19 01:12:48','1994-12-23 10:32:29'),(11,'nemo','1985-10-05 18:08:47','2013-04-03 04:43:51'),(12,'voluptate','1982-05-13 01:26:25','1989-04-09 07:44:16'),(13,'est','1999-08-18 16:52:52','2003-04-14 19:47:50'),(14,'accusamus','1998-11-06 12:08:52','1995-10-09 05:46:54'),(15,'vel','2001-04-11 14:16:13','1993-09-11 15:18:14'),(16,'et','2006-09-03 21:51:43','1983-02-14 03:20:56'),(17,'exercitati','1982-01-24 16:59:23','1973-03-05 07:02:21'),(18,'odio','2015-07-25 12:45:34','2019-04-27 13:22:49'),(19,'nisi','2019-03-17 23:19:25','2006-05-17 01:14:30'),(20,'excepturi','2005-09-04 16:18:30','2019-09-29 05:05:18');
/*!40000 ALTER TABLE `salary_detail_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_department`
--

DROP TABLE IF EXISTS `user_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_department` (
  `user_department_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_department_id`),
  KEY `user_id` (`user_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `user_department_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `user_department_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_department`
--

LOCK TABLES `user_department` WRITE;
/*!40000 ALTER TABLE `user_department` DISABLE KEYS */;
INSERT INTO `user_department` VALUES (1,1,1,'1984-05-11','1973-04-02','1976-07-31 00:49:35','2002-10-28 18:17:59'),(2,2,2,'2002-07-17','1997-07-14','1986-05-22 07:53:46','2021-06-14 20:58:43'),(3,3,3,'1989-07-04','2005-08-03','2003-11-25 09:07:06','2005-05-08 20:00:39'),(4,4,4,'1970-08-26','2018-10-17','1979-10-01 01:20:01','1999-06-12 19:58:11'),(5,5,5,'1980-02-06','2020-08-08','2004-09-14 16:34:44','1996-05-14 17:10:50'),(6,6,6,'1979-04-21','1992-11-04','1998-04-10 08:54:47','2014-07-04 06:39:02'),(7,7,7,'1985-07-25','2019-08-13','2014-01-05 14:43:44','1980-08-21 14:26:51'),(8,8,8,'1972-11-09','2020-03-27','2017-02-19 12:15:52','1970-04-10 19:02:07'),(9,9,9,'2014-09-12','1994-06-29','1998-04-21 03:14:10','2010-10-22 13:25:47'),(10,10,10,'2017-04-23','1972-05-30','2001-04-14 06:45:09','2001-02-03 02:38:50'),(11,11,11,'1980-03-21','2005-01-01','1985-04-26 12:12:16','2014-08-11 15:24:25'),(12,12,12,'2021-12-21','2009-04-16','2016-02-26 17:33:35','2005-11-24 22:01:26'),(13,13,13,'1997-11-27','1992-10-10','2022-02-22 07:16:30','2017-06-09 16:24:25'),(14,14,14,'2015-03-24','1995-05-04','2016-08-21 20:13:16','1992-08-14 12:33:53'),(15,15,15,'2018-08-25','2000-10-05','2009-12-23 04:15:39','2012-11-06 01:37:44'),(16,16,16,'2009-03-18','2004-09-22','1973-09-15 12:55:48','1987-09-13 13:54:57'),(17,17,17,'2002-04-08','2004-12-21','1978-08-15 01:15:47','2011-10-30 03:34:53'),(18,18,18,'1981-02-04','1984-09-23','1990-04-12 23:55:14','1986-07-05 06:18:58'),(19,19,19,'1980-09-23','2006-04-12','1996-07-24 05:45:24','2009-08-22 22:56:58'),(20,20,20,'1987-01-20','1980-04-26','1985-07-12 09:11:24','1981-09-01 06:51:27');
/*!40000 ALTER TABLE `user_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_department_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `user_department_id` (`user_department_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_department_id`) REFERENCES `user_department` (`user_department_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,'1993-09-23','2013-06-17','2003-02-26 19:26:17','1975-01-18 22:26:59'),(2,2,2,'1987-07-10','1982-10-08','1989-11-05 01:14:43','1983-02-16 12:09:04'),(3,3,3,'1978-11-09','1998-05-06','1972-06-21 04:43:25','1972-07-10 08:56:27'),(4,4,4,'2008-09-09','2015-01-23','1991-06-22 03:46:27','2011-01-06 17:12:21'),(5,5,5,'1980-07-23','1994-09-12','2008-07-17 02:45:11','1977-05-01 13:20:30'),(6,6,6,'2004-03-14','1985-01-07','1977-11-09 14:09:25','1983-10-25 00:02:09'),(7,7,7,'1994-08-16','2011-01-09','2009-10-10 18:09:36','1984-05-02 18:37:40'),(8,8,8,'1993-02-27','1975-05-22','2019-01-18 12:52:55','1999-08-09 15:57:27'),(9,9,9,'1997-05-03','1977-02-04','1978-02-13 22:35:01','1992-03-30 22:20:28'),(10,10,10,'1986-11-25','2016-06-21','1980-04-22 16:10:24','2015-10-19 16:40:53'),(11,11,11,'2001-02-23','1974-05-31','1970-08-19 02:10:42','2011-02-19 16:20:33'),(12,12,12,'2001-02-01','1971-09-12','1997-06-11 23:37:18','1978-10-26 12:46:29'),(13,13,13,'1975-12-17','1973-07-01','1973-01-24 12:22:35','1998-05-06 11:43:54'),(14,14,14,'1986-05-10','1989-05-31','2013-08-24 13:49:56','2018-09-03 01:53:41'),(15,15,15,'2011-01-22','1997-07-02','1986-11-22 21:23:27','2012-05-08 16:47:44'),(16,16,16,'2006-11-25','2012-11-15','2019-10-18 23:49:31','1991-10-02 19:03:02'),(17,17,17,'2001-12-30','2002-01-24','2009-07-03 22:57:35','2019-04-26 14:32:27'),(18,18,18,'1990-08-28','2003-01-07','1983-07-27 15:53:26','2004-07-05 12:47:58'),(19,19,19,'2011-09-15','1988-03-22','2020-12-28 23:44:12','1995-09-17 09:43:03'),(20,20,20,'1971-09-26','1998-05-10','1996-04-30 02:28:59','1972-04-11 00:15:14');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `gender` enum('F','M','U') COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Isaiah','O\'Reilly','karl.kohler@example.com','565.901.9826x55007',NULL,1,'M',906070,'2019-12-25 15:55:34','1980-12-07 10:08:53'),(2,'Gideon','Pouros','cale66@example.com','(165)581-8322',NULL,2,'M',96068027,'1970-07-09 07:51:26','2001-09-07 14:08:57'),(3,'Justen','Boyle','christiansen.miller@example.net','515-691-4692',NULL,3,'F',462815381,'1982-10-03 12:18:22','2014-07-05 14:45:11'),(4,'Elsie','Steuber','adams.maybelle@example.org','321.953.3122x542',NULL,4,'U',7,'1993-01-23 17:23:38','2002-02-20 14:52:12'),(5,'Aliza','Pagac','destiney85@example.com','(259)106-4561',NULL,5,'U',0,'2016-08-16 13:56:33','1991-04-07 07:18:16'),(6,'Kaia','Rippin','pietro.schroeder@example.com','01077976624',NULL,6,'M',230712,'2001-03-08 00:18:53','1980-09-16 23:24:17'),(7,'Casimir','McLaughlin','evans.sporer@example.net','+94(5)5392724304',NULL,7,'F',642664,'2015-09-25 10:35:35','1975-01-13 04:28:00'),(8,'Rubye','Weissnat','marcus26@example.com','419-519-1229',NULL,8,'M',3173187,'1991-09-25 19:23:05','1992-02-29 14:44:17'),(9,'Cleo','Fahey','gloria.d\'amore@example.net','339.487.8490x94575',NULL,9,'F',6104964,'2016-08-05 12:19:42','2021-02-09 16:18:23'),(10,'Annalise','Connelly','sluettgen@example.org','977-543-4048',NULL,10,'U',6,'1982-08-14 15:24:24','2003-09-15 01:20:23'),(11,'Erica','Spencer','carmel15@example.org','426-375-4781x05743',NULL,11,'M',4,'2012-03-22 01:24:13','2004-03-25 19:24:29'),(12,'Demetris','Pfeffer','yflatley@example.net','776.295.0062x226',NULL,12,'F',51907,'2012-04-21 22:08:20','1986-03-04 03:55:32'),(13,'Mabelle','Sipes','xernser@example.org','+87(7)0398098079',NULL,13,'U',806802,'1990-10-23 08:52:25','2014-02-07 19:54:47'),(14,'Sienna','Volkman','maryjane65@example.net','08405396004',NULL,14,'U',989,'1976-04-25 12:35:42','1993-12-06 06:37:58'),(15,'Dannie','Legros','mellie94@example.com','1-920-741-2544',NULL,15,'M',45831,'2003-11-05 20:11:01','1973-12-24 22:11:41'),(16,'Franz','Huels','barbara28@example.com','555-016-9696x82907',NULL,16,'F',3,'1982-12-07 16:22:19','2011-05-02 20:54:11'),(17,'Kory','Balistreri','zanderson@example.com','+94(5)7162089098',NULL,17,'F',8065023,'1988-05-05 22:55:38','2016-12-20 23:18:56'),(18,'Timmy','Upton','xkiehn@example.net','198.552.3516',NULL,18,'F',241202,'1979-07-04 13:17:54','1988-08-04 21:48:09'),(19,'Melisa','Parisian','ualtenwerth@example.org','(725)521-3926x62791',NULL,19,'U',8,'1982-12-18 03:50:18','2001-04-16 22:11:19'),(20,'Valerie','Heaney','trantow.kane@example.org','(439)093-3051x72990',NULL,20,'U',9,'1989-10-04 17:23:36','1978-04-10 17:57:41');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-20 17:42:25
