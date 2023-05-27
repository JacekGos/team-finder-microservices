CREATE TABLE events (
	id BIGSERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	activity_type TEXT NOT NULL,
	date TIMESTAMP WITH TIME ZONE NOT NULL,
	price REAL NOT NULL DEFAULT 0,
	venue_id BIGINT NOT NULL,
	creator_user_id BIGINT NOT NULL
);

CREATE TABLE event_user (
	id BIGSERIAL PRIMARY KEY,
	event_id BIGINT NOT NULL,
	user_id BIGINT NOT NULL,
	CONSTRAINT fk_event_user
	 FOREIGN KEY(event_id) 
	   REFERENCES events(id)
);