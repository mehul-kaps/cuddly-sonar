CREATE TABLE user (
	user_id serial PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL,
        last_login TIMESTAMP 
);


insert into postgres.public."user" (user_id,username, password, email, created_on, last_login)  
values(1,'mkapadia','abcd1234','mehul.kapadia@ithaka.org', Now(), Now());

commit;

select * from postgres.public."user"