CREATE TABLE user_event (
	id BIGSERIAL PRIMARY KEY,
	event_id BIGINT NOT NULL,
	user_id BIGINT NOT NULL,
	CONSTRAINT fk_user_event
	 FOREIGN KEY(user_id) 
	   REFERENCES "user"(id)
);