CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
	id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
	username varchar(100) NULL,
	password varchar(100) NULL,
	email varchar(100) NULL,
	created timestamp NOT NULL default current_timestamp,
	updated timestamp NOT NULL default current_timestamp
)
WITH (
	OIDS=FALSE
) ;