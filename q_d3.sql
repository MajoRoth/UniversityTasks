SELECT Receipt
FROM purchase NATURAL JOIN Receipt  
WHERE units<3 and
		date_part('month', current_date) = date_part('month', rdate) and
		date_part('year', current_date) = date_part('year', rdate);