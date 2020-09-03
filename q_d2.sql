SELECT pname, sname
FROM Product, Supplier
WHERE Supplier.sid = Product.sid and descr = 'Vegetable' and uprice>15;