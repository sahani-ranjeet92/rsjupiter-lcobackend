INSERT INTO `lco_db`.`catalog` (`NAME`,`DESCRIPTION`,`FIELD1`,`FIELD2`)VALUES('HATHWAY','',NULL,NULL);


INSERT INTO `lco_db`.`catgroup`(`NAME`,`DESCRIPTION`, 
`LONGDESCRIPTION`, 
`THUMBNAIL`, 
`FULLIMAGE`, 
`MARKFORDELETE`,
`FIELD1`, 
`FIELD2`, 
`FIELD3`
)
VALUES
('Hindi Entertainment','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('English Entertainment','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('Hindi Movie','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('English Movie','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('Sport','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('Hindi News','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('All Music','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('Kids Entertainment','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('Info','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('Marathi','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('Regional','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('International','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL),
('LifeStyle','DESCRIPTION','LONGDESCRIPTION','THUMBNAIL','FULLIMAGE',0,NULL,NULL,NULL);


INSERT INTO `lco_db`.`catentry` 
(`CHNUMBER`, 
`CHNAME`, 
`MARKFORDELETE`, 
`URL`,
`BUYABLE`, 
`STARTDATE`, 
`ENDDATE`, 
`AVAILABILITYDATE`, 
`FIELD1`, 
`FIELD2`, 
`FIELD3`
)
VALUES
('1','Star Plus',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('2','Zee TV',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('3','Life Ok',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('4','Colors',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('5','Sony Tv',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('6','SAB TV',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('7','Channel V',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('8','&TV',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('9','Shop CJ',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('10','Star Utsav',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('11','Zindigi',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('12','Zee Anmol',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('13','Bindaas',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('14','Bindass Play',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('15','Zoom',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('16','HomeShop 18',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('17','Rishtey',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('18','Sony Pal',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('19','Best Deal TV',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('20','Sahara ONE',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('22','Living Foodz',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('24','Investigation Discovery',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('28','Comedy Walas',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('29','H Tube',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('30','DD National',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('31','STAR Ustav',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('32','Firangi',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('34','Food Food',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('35','AsiaNet Teleshop',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('36','Shop Direct',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('38','Big Magic',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('39','DD Kisan',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL),
('47','Divine',0,'URL',0,NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),NOW(),NULL,NULL,NULL);



INSERT INTO `lco_db`.`catgpenrel` 
(`CATGROUP_ID`, 
`CATENTRY_ID`, 
`CATALOG_ID`, 
`FIELD1`, 
`FIELD2`, 
`FIELD3`
)
VALUES
(3001,4001,2001,NULL,NULL,NULL),
(3001,4002,2001,NULL,NULL,NULL),
(3001,4003,2001,NULL,NULL,NULL),
(3001,4004,2001,NULL,NULL,NULL),
(3001,4005,2001,NULL,NULL,NULL),
(3001,4006,2001,NULL,NULL,NULL),
(3001,4007,2001,NULL,NULL,NULL),
(3001,4008,2001,NULL,NULL,NULL),
(3001,4009,2001,NULL,NULL,NULL),
(3001,4010,2001,NULL,NULL,NULL),
(3001,4011,2001,NULL,NULL,NULL),
(3001,4012,2001,NULL,NULL,NULL),
(3001,4013,2001,NULL,NULL,NULL),
(3001,4014,2001,NULL,NULL,NULL),
(3001,4015,2001,NULL,NULL,NULL),
(3001,4016,2001,NULL,NULL,NULL),
(3001,4017,2001,NULL,NULL,NULL),
(3001,4018,2001,NULL,NULL,NULL),
(3001,4019,2001,NULL,NULL,NULL),
(3001,4020,2001,NULL,NULL,NULL),
(3001,4021,2001,NULL,NULL,NULL),
(3001,4022,2001,NULL,NULL,NULL),
(3001,4023,2001,NULL,NULL,NULL),
(3001,4024,2001,NULL,NULL,NULL),
(3001,4025,2001,NULL,NULL,NULL),
(3001,4026,2001,NULL,NULL,NULL),
(3001,4027,2001,NULL,NULL,NULL),
(3001,4028,2001,NULL,NULL,NULL),
(3001,4029,2001,NULL,NULL,NULL),
(3001,4030,2001,NULL,NULL,NULL),
(3001,4031,2001,NULL,NULL,NULL),
(3001,4032,2001,NULL,NULL,NULL),
(3001,4033,2001,NULL,NULL,NULL);


INSERT INTO `lco_db`.`offerprice` 
	(`startdate`, 
	`ENDDATE`, 
	`PRECEDENCE`, 
	`PUBLISHED`, 
	`LASTUPDATE`, 
	`PRICE`, 
	`CATENTRY_ID`, 
	`PRICETYPE`, 
	`FIELD1`, 
	`FIELD2`, 
	`FIELD3`
	)
	VALUES
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4001,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4002,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4003,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4004,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4005,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4006,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4007,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4008,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4009,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4010,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4011,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4012,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4013,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4014,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4015,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4016,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4017,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4018,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4019,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4020,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4021,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4022,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4023,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4024,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4025,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4026,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4027,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4028,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4029,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4030,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4031,'list', NULL, NULL, NULL),
	(NOW(),DATE_ADD(NOW(), INTERVAL 1 YEAR),0,1,NOW(),19,4032,'list', NULL, NULL, NULL);