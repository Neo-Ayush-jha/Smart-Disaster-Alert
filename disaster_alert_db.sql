-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2025 at 09:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `disaster_alert_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `disaster_alert`
--

CREATE TABLE `disaster_alert` (
  `id` bigint(20) NOT NULL,
  `alert_message` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `disaster_type` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `disaster_alert`
--

INSERT INTO `disaster_alert` (`id`, `alert_message`, `description`, `disaster_type`, `location`) VALUES
(1, 'Severe Flood Warning', 'Heavy rainfall causing floods in low-lying areas.', 'Flood', 'Mumbai'),
(2, 'Major Earthquake Alert', '6.5 magnitude earthquake detected near city center.', 'Earthquake', 'Delhi'),
(3, 'Cyclone Alert Issued', 'Cyclone forming in the Bay of Bengal, high winds expected.', 'Cyclone', 'Kolkata'),
(4, 'Fire Outbreak Warning', 'Major fire outbreak in industrial area, evacuate immediately.', 'Fire', 'Bangalore'),
(5, 'Landslide Risk High', 'Heavy rains increasing landslide risks in hilly regions.', 'Landslide', 'Shimla'),
(6, 'Tornado Watch Issued', 'A tornado has been spotted, take shelter immediately.', 'Tornado', 'Rajasthan'),
(7, 'Extreme Heatwave Alert', 'Temperatures expected to rise above 50°C.', 'Heatwave', 'Nagpur'),
(8, 'Tsunami Warning', 'Tsunami waves detected, immediate evacuation required.', 'Tsunami', 'Chennai'),
(9, 'Hurricane Approaching', 'Hurricane forming over Arabian Sea, heavy damage expected.', 'Hurricane', 'Goa'),
(10, 'Thunderstorm Advisory', 'Severe thunderstorm expected with hail and strong winds.', 'Thunderstorm', 'Lucknow'),
(11, 'Drought Alert', 'Water levels critically low, drought declared in affected areas.', 'Drought', 'Madhya Pradesh'),
(12, 'Chemical Spill Emergency', 'Toxic chemical leak in industrial area, avoid the zone.', 'Chemical Spill', 'Gujarat'),
(13, 'Radiation Hazard Alert', 'Nuclear radiation detected, maintain safe distance.', 'Radiation Leak', 'Rajasthan'),
(14, 'Poisonous Gas Leak', 'Harmful gas leak in factory, wear masks and evacuate.', 'Gas Leak', 'Andhra Pradesh'),
(15, 'Forest Fire Spreading', 'Wildfire spreading rapidly due to strong winds.', 'Wildfire', 'Odisha'),
(16, 'Building Collapse Reported', 'Old building collapsed, rescue operations underway.', 'Building Collapse', 'Patna'),
(17, 'Bridge Collapse Warning', 'Bridge collapse due to heavy rain, avoid the route.', 'Bridge Collapse', 'Kerala'),
(18, 'Train Accident Alert', 'Major train derailment, rescue operations in progress.', 'Train Accident', 'Punjab'),
(19, 'Dam Breach Emergency', 'Dam failure due to overflow, flooding expected.', 'Dam Failure', 'Uttarakhand'),
(20, 'Heavy Snowstorm Warning', 'Roads blocked due to extreme snowfall, travel unsafe.', 'Snowstorm', 'Kashmir');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `disaster_alert`
--
ALTER TABLE `disaster_alert`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `disaster_alert`
--
ALTER TABLE `disaster_alert`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
