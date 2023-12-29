


DROP TABLE project_shopping_member;

SELECT * FROM project_shopping_member;

CREATE TABLE project_shopping_product(
	psp_no number(10) PRIMARY KEY,
	psp_name varchar2(100 char) NOT NULL,
	psp_price number(10) NOT NULL,
	psp_num number(10) NOT NULL,
	psp_sub varchar2(100 char) NULL,
	psp_photo varchar2(100 char) not null
);

CREATE SEQUENCE project_shopping_product_seq;

SELECT * FROM project_shopping_product;
drop sequence project_shopping_product_seq;
DROP TABLE project_shopping_product;

CREATE TABLE project_shopping_order(
	pspo_no number(10) PRIMARY KEY,
	pspo_name varchar2(100 char) NOT NULL,
	pspo_price number(10) NOT NULL,
	pspo_num number(10) NOT NULL
);

CREATE SEQUENCE project_shopping_order_seq;

SELECT * FROM project_shopping_order;

DROP TABLE project_shopping_order;
drop sequence project_shopping_order_seq;
----

