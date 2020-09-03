create or replace function trigf1() RETURNS trigger as $$
BEGIN
	IF(new.units > (SELECT units FROM Stock WHERE Stock.code = new.code and Stock.bid = new.bid)) THEN 
		BEGIN 

			RAISE NOTICE 'NOT ENOUGH ITEMS IN STOCK.';
			RETURN NULL;

		END;
	END IF;

	UPDATE Stock
	SET units = units - new.units
	WHERE code = new.code and bid = new.bid;
	
	UPDATE Receipt
	SET total = total + new.units * (SELECT uprice FROM Product WHERE new.code = code)
	WHERE bid = new.bid and rdate = new.rdate and rtime=new.rtime;
		
	RETURN new;
END;
$$ LANGUAGE plpgsql
		
