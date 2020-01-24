CREATE TABLE IF NOT EXISTS `states` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `external_id` varchar(10) DEFAULT NULL,
  `location_type` varchar(20) NOT NULL,
  `pin` varchar(10) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `districts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `external_id` varchar(10) DEFAULT NULL,
  `location_type` varchar(20) NOT NULL,
  `pin` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `subdistricts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `external_id` varchar(10) DEFAULT NULL,
  `location_type` varchar(20) NOT NULL,
  `pin` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;