create table ${schema_name}.b13_order_table
(
	id int not null
		constraint B13_ORDER_TABLE_PK
			primary key,
	customerId varchar2(10) not null,
	shippingId varchar2(10) not null,
	invoiceUrl varchar2(100) not null,
	orderPlaced date not null,
	total number(10,2),
	subtotal number(10,2) not null,
	tax number(2,2) not null,
	shippingCost number(10,2),
	priceAdjustment number(10,2) not null,
	paid number(10,2) not null,
	refunded number(10,2) not null,
	status varchar2(20),
	timestamp timestamp default current_timestamp not null
)/

CREATE TABLE ${schema_name}.b13_order_product_table(
    order_id int not null
        constraint order_product_fk
		foreign key references ${schema_name}.b13_order_table(id)
			on delete cascade,
	productId not null,
	imageUrl int not null
)