SELECT sname, pname
FROM Supplier natural join Product
WHERE not exists(	SELECT * 
			FROM Supplier AS S natural join Product AS P
			WHERE Supplier.sid = S.sid and Product.code <> P.code)