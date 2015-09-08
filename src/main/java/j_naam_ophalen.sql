drop function if exists naam_ophalen;
delimiter //
create function naam_ophalen (f_klantnummer int) returns varchar(100)
DETERMINISTIC
READS SQL DATA
BEGIN
DECLARE finished INT DEFAULT false;
DECLARE v_naam varchar(30) default "";
declare	c_vraagnaam cursor for
	select naam	from j_klanten where klantnr = f_klantnummer;
declare continue handler for not found set finished = TRUE;
	open c_vraagnaam;
	fetch c_vraagnaam into v_naam;
		if finished = 1 then 
			close c_vraagnaam;
			return 'Klant onbekend';
		end if; 
	close c_vraagnaam;
	return v_naam;
end//

delimiter ;

