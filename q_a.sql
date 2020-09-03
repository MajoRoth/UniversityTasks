CREATE TABLE Supplier(
	sid int,
	sname varchar(30),
	address varchar(50),
	phone numeric(9,0),
	PRIMARY KEY(sid)
);

CREATE TABLE Product(
	code int,
	pname varchar(30),
	descr varchar(50),
	utype varchar(30),
	uprice float,
	manu varchar(30),
	sid int,

	PRIMARY KEY(code)
	FOREIGN key(sid) references Supplier

);


CREATE TABLE Branch(
	bid int,
	bname varchar(30),
	baddress varchar(50),

	PRIMARY KEY(bid)
);


CREATE TABLE Stock(
	code int,
	bid int,
	units float,

	PRIMARY KEY(bid, code),
	FOREIGN KEY(code) REFERENCES Product(code),
	FOREIGN KEY(bid) REFERENCES Branch(bid)
);


CREATE TABLE Receipt(
	bid int,
	rdate date,
	rtime time,
	ptype varchar(30),
	total float,

	PRIMARY KEY(bid, rdate, rtime),
	FOREIGN KEY(bid) REFERENCES Branch(bid)
);


CREATE TABLE Purchase(
	bid int,
	rdate date,
	rtime time,
	code int,
	units float,

	CHECK (units > 0),

	PRIMARY KEY(bid, rdate, rtime, code),
	FOREIGN KEY(bid, rdate, rtime) REFERENCES Receipt,
	FOREIGN KEY(code) REFERENCES Product(code)
);














