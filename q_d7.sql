SELECT bid, rdate, rtime
FROM Receipt natural join Purchase natural join Product
WHERE total > 50 and NOT EXISTS(SELECT Pu
				FROM Product AS Pr NATURAL JOIN Purchase AS Pu
			        WHERE Receipt.bid = Pu.bid and Receipt.rdate = Pu.rdate and Receipt.rtime = Pu.rtime and Pr.pname = 'Cucumbers')
								
GROUP BY  bid, rdate, rtime
HAVING count(DISTINCT Product.sid) <= ALL (	SELECT count(Pr.sid)
						FROM Receipt AS Re NATURAL JOIN Product AS Pr NATURAL JOIN Purchase AS Pu
						GROUP BY Re.bid, RE.rdate, RE.rtime)