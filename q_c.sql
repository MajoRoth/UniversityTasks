INSERT INTO Supplier (sid, sname, address, phone) VALUES
        (111, 'Supplier2', 'Road 2, Tel Aviv',  111111111),
        (222, 'Supplier3', 'Road 3, Jerusalem', 222222222),
        (333, 'Supplier4', 'Road 2, Eilat',     333333333);

INSERT INTO Branch (bid, bname, baddress) VALUES
        (989, 'Tel Aviv', 'Road 1, tel aviv'),
        (878, 'Raanana',  'Road 1, raanana'),
        (767, 'Holon',    'Road 1, holon');
       
INSERT INTO Product (code, pname, descr, utype, uprice, manu, sid) VALUES
        (987, 'Tomatoes',       'Vegetable',  'Kg',  5.99,  'Manufacturer1', 111),
        (876, 'Cucumbers',      'Vegetable',  'Kg',  4.99,  'Manufacturer2', 222),
        (765, 'Cornflakes',     'Cornflakes', 'Box', 15.9,  'Manufacturer2', 222),
        (654, 'Camembert',      'Cheese',     'Box', 12.50, 'Manufacturer2', 111),
        (543, 'Sweet potato',   'Vegetable',  'Kg',  16.40, 'Manufacturer3', 333),
        (432, 'Red pepper',     'Vegetable',  'Kg',  15.99, 'Manufacturer1', 111);
 
INSERT INTO Stock (code, bid, units) VALUES
        (987, 989, 50),
        (987, 878, 75),
        (987, 767, 100),
        (876, 989, 30),
        (876, 878, 60),
        (876, 767, 25),
        (765, 989, 20),
        (765, 878, 15),
        (654, 878, 10),
        (654, 767, 5),
        (543, 989, 50),
        (543, 767, 165),
        (432, 989, 17),
        (432, 878, 25),
        (432, 767, 30);
 
INSERT INTO Receipt (bid, rdate, rtime, ptype) VALUES
        (989, '2020-7-18', '10:00', 'Cash'),
        (878, '2020-7-17', '8:30',  'Credit'),
        (767, '2020-7-10', '20:30', 'Debit');
 
 
INSERT INTO Purchase (bid, rdate, rtime, code, units) VALUES
        (989, '2020-7-18', '10:00', 987, 5),
        (989, '2020-7-18', '10:00', 876, 3),
        (989, '2020-7-18', '10:00', 543, 4),
        (989, '2020-7-18', '10:00', 432, 1),
        (878, '2020-7-17', '8:30',  654, 1),
        (878, '2020-7-17', '8:30',  432, 3),
        (767, '2020-7-10', '20:30', 654, 2),
        (767, '2020-7-10', '20:30', 987, 3);
