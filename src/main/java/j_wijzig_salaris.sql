delimiter //

create procedure wijzig_salaris (IN persoonsnr integer, IN bedrag integer) 
	begin
		update j_werknemers set sal = sal + bedrag where persnr = persoonsnr;
end//

delimiter ;
