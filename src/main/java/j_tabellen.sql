drop table j_klanten;
drop table j_werknemers;
drop table j_kantoren;
drop table j_saldomutatie;

create table if not exists j_klanten  (
  KLANTNR                         	       INTEGER(4) NOT NULL primary key
, NAAM                                     VARCHAR(20)
, STRAAT                                   VARCHAR(20)
, NUMMER                                   VARCHAR(10)
, POSTCODE                                 VARCHAR(6)
, PLAATS                                   VARCHAR(20)
, OPENSALDO                                NUMERIC(7,2)
);
begin;
insert into j_klanten values (1001, 'Willemsen', 'Middenweg', '4', '3874HH', 'Rotterdam', 1500);
insert into j_klanten values (1002, 'Gerritsen', 'Kanaalstraat', '352', '1089JS', 'Rotterdam', 300.5);
insert into j_klanten values (1003, 'de Jong', 'Breedstraat', '6 bis', '3901II', 'Den Haag', 0);
insert into j_klanten values (1004, 'Admiraal', 'Biltstraat', '22', '7299JT', 'Utrecht', 0);
insert into j_klanten values (1005, 'Pietersen', 'Middelweg', '82', '3469ZA', 'Haarlem', 0);
insert into j_klanten values (1006, 'de Winter', 'Langestraat', '201202', '2012HU', 'Alkmaar', 25.5);
insert into j_klanten values (1007, 'de Vries', 'Stationsplein', '2', '2349DF', 'Amsterdam', 50);
insert into j_klanten values (1008, 'Bakker', 'Haarlemse straat', '304', '2347GH', 'Haarlem', 0);
commit;

create table if not exists j_kantoren(
  kantnr integer(2) not null primary key
, naam varchar(15)
, plaats varchar(10));
begin;
insert into j_kantoren values(10, 'BOEKHOUDING','AMSTERDAM');
insert into j_kantoren values(20, 'ONDERZOEK','UTRECHT');
insert into j_kantoren values(30, 'VERKOOP','DEN HAAG');
insert into j_kantoren values(40, 'PRODUCTIE','ARNHEM');
commit;

create table if not exists j_werknemers
 (
 persnr integer(4) primary key,
 naam varchar(10),
 functie varchar(9),
 mgr integer(4),
 sal integer(5),
 toeslag integer(5),
 kantnr integer(2),
 foreign key (kantnr) references j_kantoren (kantnr)
 );
begin;
insert into j_werknemers values (3381,'SMITS','KLERK',7902,2400,NULL,20);
insert into j_werknemers values (3462,'ALKEMA','VERKOPER',4621,2600,300,30);
insert into j_werknemers values (3518,'WALSTRA','VERKOPER',4621,2250,500,30);
insert into j_werknemers values (3930,'PIETERS','MANAGER',6221,3975,NULL,20);
insert into j_werknemers values (4510,'VERGEER','VERKOPER',4621,2250,1400,30);
insert into j_werknemers values (4621,'KLAASEN','MANAGER',6221,3850,NULL,30);
insert into j_werknemers values (5810,'HEUVEL','MANAGER',6221,3450,NULL,10);
insert into j_werknemers values (5931,'SANDERS','ANALIST',3930,4000,NULL,20);
insert into j_werknemers values (6221,'KRAAY','DIRECTEUR',NULL,6000,NULL,10);
insert into j_werknemers values (6500,'DROST','VERKOPER',4621,2500,0,30);
insert into j_werknemers values (6681,'ADELAAR','KLERK',5931,2100,NULL,20);
insert into j_werknemers values (7900,'APPEL','KLERK',4621,1950,NULL,30);
insert into j_werknemers values (7902,'VERMEULEN','ANALIST',3930,3900,NULL,20);
insert into j_werknemers values (8222,'MANDERS','KLERK',5810,2300,NULL,10);
commit;

create table if not exists j_saldomutatie (
 ID int primary key auto_increment,
 KLANTNR integer(4)
,MUTATIE numeric(7,2)
,UITGEVOERD integer(1)
);
begin;
insert into j_saldomutatie (klantnr, mutatie, uitgevoerd) values(1001, 200.5, 0);
insert into j_saldomutatie (klantnr, mutatie, uitgevoerd) values(1004, 205, 0);
insert into j_saldomutatie (klantnr, mutatie, uitgevoerd) values(1004, -175, 0);
insert into j_saldomutatie (klantnr, mutatie, uitgevoerd) values(1002, -450, 0);
insert into j_saldomutatie (klantnr, mutatie, uitgevoerd) values(1007, 150.75, 0);
insert into j_saldomutatie (klantnr, mutatie, uitgevoerd) values(1008, -45, 0);
insert into j_saldomutatie (klantnr, mutatie, uitgevoerd) values(1001, -1203, 0);
insert into j_saldomutatie (klantnr, mutatie, uitgevoerd) values(1007, -45, 0);
commit;

