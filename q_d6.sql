SELECT bid
FROM Stock
GROUP BY bid
HAVING count(Stock.code) = (	SELECT count(code)
				FROM Product)