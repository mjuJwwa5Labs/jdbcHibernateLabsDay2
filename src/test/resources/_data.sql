INSERT INTO `address` VALUES (1,'Ulica 1','Miasto 1','00-001'),(2,'Ulica 2','Miasto 2','00-002'),(3,'Ulica 3','Miasto 3','00-003'),(4,'Ulica 4','Miasto 4','00-004'),(5,'Ulica 5','Miasto 5','00-005'),(6,'Ulica 6','Miasto 6','00-006'),(10,'Ulica 10','Miasto 10','00-010');
INSERT INTO `customer` VALUES (1,'piesekleszek','Psiulek','leszek','REGULAR',2),(2,'johnybravo','johny','bravo','REGULAR',1),(3,'maro','Marek','Juszczak','VIP',3),(4,'mike','Michal','Lemko','VIP',3),(6,'robertlewandowski','Robert','Lewandowski','VIP',4),(7,'tomasztomkowy','Tomasz','Tomkowy','REGULAR',5),(8,'dobryklient','Dobry','Klient','REGULAR',10);
INSERT INTO `order` VALUES (1,1,'DELIVERED','2017-02-19 23:00:00'),(2,1,'DELIVERED','2017-03-03 09:00:01'),(3,2,'DELIVERED','2017-12-10 22:01:01'),(4,2,'DELIVERED','2017-12-24 05:30:59'),(5,2,'DELIVERED','2018-01-02 11:10:15'),(6,3,'DELIVERED','2018-01-28 13:02:19'),(7,3,'DELIVERED','2018-02-01 17:02:02'),(8,6,'PAID','2018-02-10 14:30:21'),(9,1,'CONFIRMED','2018-02-12 16:30:01'),(10,2,'CONFIRMED','2018-02-12 11:00:00'),(11,7,'NEW','2018-02-12 18:10:01'),(12,1,'NEW','2018-02-13 10:19:59'),(13,7,'PAID','2018-02-13 19:10:01');
INSERT INTO `order_item` VALUES (1,3,5),(1,29,20),(1,31,12),(1,35,3),(1,37,2),(1,39,20),(2,4,9),(2,31,9),(2,32,13),(2,34,15),(2,35,17),(2,36,7),(2,37,16),(3,4,13),(3,31,4),(3,32,7),(3,35,11),(3,36,12),(3,37,11),(4,29,6),(4,30,11),(4,31,13),(4,33,18),(4,39,19),(5,3,18),(5,4,10),(5,31,11),(5,32,18),(5,33,13),(5,35,19),(5,38,5),(6,4,14),(6,29,18),(6,32,20),(6,33,10),(6,34,2),(6,35,4),(6,38,7),(6,39,20),(7,30,8),(7,31,14),(7,33,5),(7,38,20),(7,39,17),(8,3,13),(8,4,11),(8,32,4),(8,33,14),(8,34,1),(8,39,15),(9,30,17),(9,31,19),(9,32,16),(9,34,6),(9,35,2),(9,36,1),(10,4,7),(10,29,6),(10,30,14),(10,31,13),(10,32,8),(10,33,13),(10,39,6),(11,3,11),(11,4,13),(11,29,16),(11,30,4),(11,32,18),(12,4,16),(12,29,9),(12,35,6),(12,36,13),(12,37,18),(12,38,10);
INSERT INTO `product` VALUES (3,'Koszula',189.56,'Odzież'),(4,'Spodnie',99.99,'Odzież'),(29,'Buty',145.50,'Obuwie'),(30,'Laptop',1999.99,'Elektro'),(31,'Telewizor',4999.99,'Elektro'),(32,'Kubek',19.99,'Naczynia'),(33,'Talerz',9.00,'Naczynia'),(34,'Suszarka do włosów',46.00,'Agd.Drobne'),(35,'Szczoteczka do zębów na prund',80.00,'Agd.Drobne'),(36,'Pralka tubro wirek',1300.00,'Agd.Duże'),(37,'Suszarka do prania',890.00,'Agd.Duże'),(38,'Whisky Wyśmienita',98.50,'Alkohole'),(39,'Wódka Najczystsza',38.15,'Alkohole'),(40,'Piwo Zimne',3.40,'Alkohole');