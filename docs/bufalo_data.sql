USE bufalo;

INSERT INTO `employee` VALUES (1, "bob2@gmail.com", "boby", true, "boby", "c26387640f55f4c1fab0df2f504a1ee6626e53cbd750eba24312f4417c6148fe4476d8e98af1283e13c9a440beb88736cb5503d09d1db6cd5d22dd1506a3a113", "azertyuiop", "ACME12");

INSERT INTO `employee` VALUES (2, "bob@gmail.com", "bob", true, "bob", "c7df02d7485ac68a605140aad4d8071e8241ad7ad7b9f5fe930a998baea3d0668a40c284734cf79226f4f8cbd1d611532dab8694f1137cef263afe36073ba00a", "123", "ref1");

INSERT INTO `employee` (`email`,`first_name`,`last_name`,`password`,`password_salt`,`reference`,`is_active`) 
	VALUES 
		("placerat.augue@sagittisaugueeu.com","Talon","Donovan","ZZE30KKA5JI","malesuada","E-1414456322",false),
		("Aenean.massa@fringillaeuismod.co.uk","Basil","Parks","LAI08VGP1MH","non,","E-0048241941",false),
		("lobortis.augue@pede.edu","Kylynn","Rollins","HIQ17NKB8ZW","quis","E-8993974179",false),
		("Maecenas@loremvitaeodio.com","Miriam","Gaines","SIN80QTP5RB","Nulla","E-4921500047",true),
		("tristique.aliquet@pulvinararcu.co.uk","Cooper","Leonard","FKC31GBS8SS","Quisque","E-7894384548",false),
		("diam@ipsumCurabiturconsequat.org","Brenden","Berger","LHM07MLD5MJ","vulputate","E-7584246397",false),
		("Cras.eget@nasceturridiculus.co.uk","Colin","Ferguson","KJJ37IAE7PE","posuere","E-1052011527",false),
		("ante.dictum@aliquamenim.org","Macaulay","Bradshaw","ZFH78HWP5GQ","nibh.","E-2153883843",false),
		("posuere.enim@risusat.co.uk","Rae","Jenkins","BKB28TWG3HT","Duis","E-4744208957",false),
		("ad@cursusvestibulum.net","Harper","Macias","DNV62DMH5DX","in","E-1010432099",false);
        
INSERT INTO `city` (`id`,`country`,`name`) VALUES (1,76,"Rennes"); 
INSERT INTO `city` (`id`,`country`,`name`) VALUES (2,76,"Nantes"); 

INSERT INTO `postal_code` (`id`,`number`) VALUES (1,35000); 
INSERT INTO `postal_code` (`id`,`number`) VALUES (2,44000); 

INSERT INTO `postal_code_has_city` (`id_postal_code`,`id_city`) VALUES (1,1); 
INSERT INTO `postal_code_has_city` (`id_postal_code`,`id_city`) VALUES (2,2); 
     
     

INSERT INTO `customer` (`address_line_1`,`address_line_2`,`address_line_3`,`email`,`first_name`,`last_name`,`password`,`password_salt`,`phone_number`,`reference`,`birthdate`,`is_active`,`id_postal_code`,`id_city`) VALUES 
	("b3??&=w~Y4R^e,??v]??RZ??{QiH)r","|FP$RLo=EKe(o??fk*","","Z(+Qh!f??c????Or!gq??--kBXA6J`O']??D??m[","7e??Z*","7j8ZzM","RDJ46GGC1SR","AVV28OPC","02 24 73 43 81","C-808624","2020-06-22",1,1,1),
	("{}???d_[_ZdVB","b3??1%??Fd''9XB??fk","","9Rqi-??4PH??v??Dd??k*-D7zsF??JS??Z}SN8","*)??~","!G+i??","CXX59CZY1VQ","WGE33UHD","06 93 00 63 27","C-468039","2021-02-15",1,1,1),
	("b3??1%t~%V=!e$Sg3r??U'","b3??qT]~%VR??ee6g*NkmH$Wa","","9(+u??^4??sz??hw.??n??L7-ss-F)d??Z]","YRqQz","Yj9??z","HFJ10JWC8RR","GGG93DFB","01 05 89 46 72","C-14734","2020-10-06",1,1,1),
	("b3??k??)~RnB??ev??9S&X??0",":@P$RL]BE??v=r??Hl??","","7C??-zEL'}-EOhh:????1znO#-}ymG*nKP","!??g??","z([zh^","TWC44ZOP5GF","HAH05YHD","06 98 97 88 78","C-5511631","2021-05-13",1,2,2),
	("f1.$??L??JESZ?? @H7R","|a.$??&-dbh Ow??V??Nki'","","V??o7??!t' ??3S !:]*'zR??!:v.d%zZ2=K??R??D@AA^","d??g??h","!Rwi??","CTO85XND4AZ","VOU92NRH","09 64 07 88 98","C-1640624","2020-06-17",1,2,2),
	("7J????*i3J??%H6G72Sz-{'cda","f@??;d4/dv!","","begJ'6q-H???Bx??ZpG'|RsI'Oxc^j??.N<ssxV","%??Ii","dG??uz{","WOC02RGX7PT","WIW25NZJ","08 89 19 32 80","C-436235","2020-11-19",1,2,2),
    ("b3??;Y]~??r%??e@1eKGkZ??t.s","b3??&Rt~Bn=ueu??AS2'~k?Q","","X(9|??{vK??P9??-`e{??1z??.5P??a","3??viz??","6??+Q","EZT20NPO1RP","XAI30AYS","07 95 57 48 07","C-360548","2022-03-07",1,2,2),
    ("faX$R]s??EL??O|rvU/??uk","5}??$Y]yYE@v!whZ;/H??","","9(97??*rZHP:ume3>*6i0,5i??","<Rq??","Y??9??}","JYM50SIW4XJ","SMG17IRK","07 70 58 62 91","C-31999","2022-04-13",1,1,1),
    ("{??#qd0[!E;L","??12&dV????H??HJD","","&G8??z!z'??'xAAd????7R#7f","`??9Wj","b)gQh","GAG38OHO7VC","HVO73LWO","01 01 53 64 38","C-12989491","2020-08-18",1,2,2),
    ("7J????*i3??????H%]??Hx*'76cda",":??)bd??lPT'L??|??H7Rk","","&R+#!??>e ??#?!lx3r'i'z(i kdH??nH/,","!??9Zz^4","'Gv??zM","BSS33GBQ3EM","CHH08KAX","07 53 09 81 54","C-888963","2022-01-12",1,1,1);     
     
-- INSERT INTO `customer` (`address_line_1`,`address_line_2`,`address_line_3`,`email`,`first_name`,`last_name`,`password`,`password_salt`,`phone_number`,`reference`,`birthdate`,`is_active`,`id_postal_code`,`id_city`) VALUES 
-- 	("Ap #180-4935 Feugiat Street","679-3258 Nibh Ave","","nulla.Cras.eu@nislsemconsequat.net","Plato","Potter","RDJ46GGC1SR","AVV28OPC","02 24 73 43 81","C-8086266455","2020-06-22",1,1,1),
-- 	("2685 Nibh St.","Ap #737-2769 Nulla Av.","","pede.malesuada.vel@cursusa.co.uk","Ivor","Miles","CXX59CZY1VQ","WGE33UHD","06 93 00 63 27","C-4680544839","2021-02-15",1,1,1),
-- 	("Ap #271-7388 Donec St.","Ap #304-7336 Ornare, Road","","pulvinar@erosProinultrices.ca","Hedley","Horne","HFJ10JWC8RR","GGG93DFB","01 05 89 46 72","C-1483254734","2020-10-06",1,1,1),
-- 	("Ap #493-3050 Vel Road","309-3265 Augue St.","","Phasellus.fermentum@Duisa.co.uk","Maia","Guzman","TWC44ZOP5GF","HAH05YHD","06 98 97 88 78","C-5590511631","2021-05-13",1,2,2),
-- 	("782-9286 Donec Av.","622-291 Fames Street","","lacus.Quisque@egetmagnaSuspendisse.co.uk","Naida","Meyer","CTO85XND4AZ","VOU92NRH","09 64 07 88 98","C-1640604724","2020-06-17",1,2,2),
-- 	("P.O. Box 667, 3281 Elit, Rd.","7057 At St.","","Aliquam.erat.volutpat@Morbineque.net","Lane","Nieves","WOC02RGX7PT","WIW25NZJ","08 89 19 32 80","C-4361002735","2020-11-19",1,2,2),
--     ("Ap #744-2770 Aliquet Ave","Ap #131-5087 Sed Street","","turpis.Nulla@dictum.co.uk","Kaseem","Wall","EZT20NPO1RP","XAI30AYS","07 95 57 48 07","C-3609385948","2022-03-07",1,2,2),
--     ("727-3422 Pretium Ave","865-4434 Euismod Rd.","","purus@scelerisquesed.org","Veda","Hardy","JYM50SIW4XJ","SMG17IRK","07 70 58 62 91","C-3191119899","2022-04-13",1,1,1),
--     ("2113 Sit St.","4861 Lorem Rd.","","vitae.purus@magnaa.ca","Caryn","Avila","GAG38OHO7VC","HVO73LWO","01 01 53 64 38","C-1298949171","2020-08-18",1,2,2),
--     ("P.O. Box 269, 913 Metus. Rd.","3140 Vulputate Ave","","vel.turpis@consectetueripsum.net","Martena","Fisher","BSS33GBQ3EM","CHH08KAX","07 53 09 81 54","C-8813838963","2022-01-12",1,1,1);


INSERT INTO `customer_has_employee` VALUES 
	(1,1),
	(2,1),
	(3,1),
	(4,1),
	(5,1),
	(6,1),
	(7,1),
	(8,1),
	(9,1),
	(10,1);


INSERT INTO `orders` (`id`,`creation_date`,`is_validated`,`reference`,`validation_date`,`id_customer`) VALUES 
	(1, "2021-05-31",1,"O-85638295", "2021-06-01", 1),
    (2, "2021-05-29",1,"O-57024439", "2021-05-30", 1),
    (3, "2021-05-18",1,"O-12362841", "2021-05-19", 2);
    
INSERT INTO `orders` (`id`,`creation_date`,`is_validated`,`reference`,`id_customer`) VALUES 
    (4, "2021-04-21",0,"O-95720473", 3);

INSERT INTO `status` VALUES (1, "disponible");
INSERT INTO `status` VALUES (2, "non disponible");
INSERT INTO `status` VALUES (3, "archiv??");

INSERT INTO `vat` VALUES (1, 0.2);
INSERT INTO `vat` VALUES (2, 0.1);
INSERT INTO `vat` VALUES (3, 0.055);
INSERT INTO `vat` VALUES (4, 0.021);

INSERT INTO `category` VALUES (1, "montre connect??e");

INSERT INTO `product` (`label`,`reference`,`description`,`picture`,`price`,`stock`,`id_status`,`id_vat`) VALUES 
	("BuFaLo ACE 1","P-429647401","Boostez votre sant?? avec BuFaLo ACE 1, le bracelet d'activit?? pour le sport et le bien-??tre ?? la pointe de la mode","Link picture","64.99",100,1,1),
	("BuFalo ACE 2","P-799519399","Boostez corps et sant?? avec BuFaLo ACE 2, le bracelet d'activit?? pour le sport et le bien-??tre ?? la pointe de la mode.","Link picture","75.99",83,1,1),
	("BuFaLo ACE 3","P-413015097","Boostez esprit, corps et sant?? avec BuFaLo ACE 3, le bracelet d'activit?? pour le sport et le bien-??tre ?? la pointe de la mode.","Link picture","99.99",81,1,1),
	("BuFaLo Inspire 1","P-746350124","Facile ?? utiliser, ce bracelet pour le sport offre un suivi continu de la fr??quence cardiaque et des minutes en zone active","Link picture","128.99",63,1,1),
	("BuFalo Inspire 2","P-682818633","Facile ?? utiliser, ce bracelet pour le sport offre un suivi continu de la fr??quence cardiaque, des minutes en zone active et plus encore","Link picture","158.99",30,1,1),
	("BuFaLo Luxe","P-322976284","Luxe est le bracelet connect?? intelligent pour la sant?? qui vous aide ?? ??tre en harmonie avec votre corps tout en gardant la classe","Link picture","239.99",52,3,1),
	("BuFaLo Versa 1","P-469744515","D??couvrez Versa 1, le bracelet connect?? sant?? et sport qui sait vous motiver pour bouger avec GPS int??gr??","Link picture","104.99",29,1,1),
	("BuFaLo Versa 2","P-946035605","D??couvrez Versa 2, le bracelet connect?? sant?? et sport qui sait vous motiver pour bouger avec GPS int??gr??","Link picture","124.99",16,1,1),
	("BuFaLo FitLord","P-743512360","Fixez-vous des objectifs plus ambitieux gr??ce ?? ce bracelet d'activit?? ??tanche pour la sant?? et le sport avec GPS int??gr??","Link picture","149.99",61,2,1),
	("BuFaLo Sense","P-021776975","Changez de style avec Sense qui comprend un ??l??gant bracelet tiss?? r??fl??chissant et un classique noir suppl??mentaire plus un GPS int??gr??,","Link picture","125.99",52,2,1);

INSERT INTO `product_has_category` (`id_product`, `id_category`) VALUES (1,1), (2,1), (3,1), (4,1), (5,1), (6,1), (7,1), (8,1), (9,1), (10,1);

INSERT INTO `sold_product` (`id`,`price`,`quantity`,`vat`,`id_order`,`id_product`) VALUES
	(1,64.99,1,0.2,1,1),
	(2,128.99,2,0.2,1,4),
	(3,75.99,2,0.2,2,2),
	(4,125.99,1,0.2,3,10),
	(5,124.99,1,0.2,4,8),
	(6,149.99,1,0.2,4,9); 
