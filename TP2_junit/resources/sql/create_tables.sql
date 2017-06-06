CREATE TABLE user (

    login VARCHAR(30),

    password VARCHAR(30),

    PRIMARY KEY (login)
)


CREATE TABLE basket (

    id int NOT NULL auto_increment,

    brand VARCHAR(30),

    color VARCHAR(30),
    
    stock int,

    PRIMARY KEY (id)

)

alter table basket add login varchar(255);
alter table basket ADD CONSTRAINT fk_login_user FOREIGN KEY (login) REFERENCES user(login);

insert into user values ('test', 'test');
insert into user values ('testToDelete','testToDelete');
alter table basket auto_increment = 1;
alter table basket add basket_date date;
insert into basket (brand, color, stock, login, basket_date) 
			values ('test','test', 5, 'test', '2015-11-05');
			
DELIMITER |
CREATE procedure printBaskets()
	BEGIN
	select * from basket;
	END |
DELIMITER ;


