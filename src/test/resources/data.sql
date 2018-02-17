INSERT INTO `address` VALUES (10,'Marszalkowska','Warszawa','02-678');

INSERT INTO `customer` VALUES (1,'mir','Johny','Bravo','REGULAR',10),(2,'rlewandowski','Robert','Lewandowski','VIP',NULL),(3,'jk','Jan','Kowalski','VIP',NULL);

INSERT INTO `product` VALUES (1,'chleb',2.20,'FOOD'),(2,'woda',3.30,'DRINKS'),(3,'jajka',3.00,'FOOD');

INSERT INTO "ORDER" (id, customer_id, status, creation_date) values (1, 1, 'NEW', current_timestamp);

insert INTO `order_item` values (1,2,3);

insert INTO `order_item` values (1,3,4);

commit;