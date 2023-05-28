CREATE TABLE venues (
	id BIGSERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	price INT DEFAULT 0
);

CREATE TABLE activity_type (
	id BIGSERIAL PRIMARY KEY,
	name BIGINT NOT NULL
);

CREATE TABLE venue_sport_discipline (
	id BIGSERIAL PRIMARY KEY,
	venue_id BIGINT NOT NULL,
	activity_type_id BIGINT NOT NULL,
	CONSTRAINT fk_venue
	 FOREIGN KEY(venue_id) 
	   REFERENCES venues(id),
	CONSTRAINT fk_activity_type
	 FOREIGN KEY(activity_type_id) 
	   REFERENCES activity_type(id)
);

CREATE TABLE venue_event_date (
	id BIGSERIAL PRIMARY KEY,
	venue_id BIGINT NOT NULL,
	date TIMESTAMP WITH TIME ZONE NOT NULL,
	CONSTRAINT fk_venue_event_date
	 FOREIGN KEY(venue_id) 
	   REFERENCES venues(id)
);