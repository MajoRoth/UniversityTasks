select bid, bname
FROM Branch NATURAL JOIN Receipt
GROUP BY bid
HAVING sum(Total) >= ANY (SELECT SUM(total)
						  FROM Branch AS B NATURAL JOIN Receipt
						  GROUP BY B.bid);
