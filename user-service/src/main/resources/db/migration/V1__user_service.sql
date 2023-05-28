CREATE TABLE "user" (
	id BIGSERIAL PRIMARY KEY,
	username TEXT NOT NULL,
	password TEXT NOT NULL,
	email TEXT NOT NULL,
	is_enabled BOOLEAN DEFAULT TRUE,
	is_non_expired BOOLEAN DEFAULT TRUE,
	is_credentials_non_expired BOOLEAN DEFAULT TRUE,
	is_non_locked BOOLEAN DEFAULT TRUE
);

CREATE TABLE role (
	id BIGSERIAL PRIMARY KEY,
	name BIGINT NOT NULL
);

CREATE TABLE user_role (
	id BIGSERIAL PRIMARY KEY,
	user_id BIGINT NOT NULL,
	role_id BIGINT NOT NULL,
	CONSTRAINT fk_user
	 FOREIGN KEY(user_id) 
	   REFERENCES "user"(id),
	CONSTRAINT fk_role
	 FOREIGN KEY(role_id) 
	   REFERENCES role(id)
);

