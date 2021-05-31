CREATE EXTENSION IF NOT EXISTS pgcrypto;


CREATE TABLE public.group
(
    group_id BIGINT NOT NULL,
    group_description VARCHAR(255) NOT NULL,
    CONSTRAINT pk_group PRIMARY KEY (group_id)
);

CREATE SEQUENCE group_sequence OWNED BY public.group.group_id;


CREATE TABLE public.person
(
    person_id BIGINT NOT NULL,
    person_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email_adress VARCHAR(255) NOT NULL,
    telephone_number VARCHAR(255),
    CONSTRAINT pk_person PRIMARY KEY (person_id)
);

CREATE SEQUENCE person_sequence OWNED BY public.person.person_id;


CREATE TABLE public.user
(
    user_id BIGINT NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    fk_person_id BIGINT NOT NULL,
    fk_group_id BIGINT NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id),
    CONSTRAINT fk_person FOREIGN KEY (fk_person_id) REFERENCES public.person (person_id),
    CONSTRAINT fk_group FOREIGN KEY (fk_group_id) REFERENCES public.group (group_id)
);

CREATE SEQUENCE user_sequence OWNED BY public.user.user_id;


CREATE TABLE public.building
(
    building_id BIGINT NOT NULL,
    building_description VARCHAR(255),
    adress VARCHAR(255) NOT NULL,
    price REAL NOT NULL,
    fk_person_id BIGINT,
    CONSTRAINT pk_building PRIMARY KEY (building_id),
    CONSTRAINT fk_person FOREIGN KEY (fk_person_id) REFERENCES public.person (person_id)
);

CREATE SEQUENCE building_sequence OWNED BY public.building.building_id;


CREATE TABLE public.floor
(
    floor_id BIGINT NOT NULL,
    floor_number INT NOT NULL,
    floor_description VARCHAR(255),
    fk_building_id BIGINT NOT NULL,
    CONSTRAINT pk_floor PRIMARY KEY (floor_id),
    CONSTRAINT fk_building FOREIGN KEY (fk_building_id) REFERENCES public.building (building_id)
);

CREATE SEQUENCE floor_sequence OWNED BY public.floor.floor_id;


CREATE TABLE public.room
(
    room_id BIGINT NOT NULL,
    room_description VARCHAR(255),
    fk_floor_id BIGINT NOT NULL,
    CONSTRAINT pk_room PRIMARY KEY(room_id),
    CONSTRAINT fk_floor FOREIGN KEY(fk_floor_id) REFERENCES public.floor(floor_id)
);

CREATE SEQUENCE room_sequence OWNED BY public.room.room_id;


CREATE TABLE public.furniture
(
    furniture_id BIGINT NOT NULL,
    furniture_description VARCHAR(255) NOT NULL,
    price REAL NOT NULL,
    CONSTRAINT pk_furniture PRIMARY KEY (furniture_id)
);

CREATE SEQUENCE furniture_sequence OWNED BY public.furniture.furniture_id;


CREATE TABLE public.furniture_placement(
    furniture_placement_id BIGINT NOT NULL,
    fk_room_id BIGINT NOT NULL,
    fk_furniture_id BIGINT NOT NULL,
    amount INT,
    CONSTRAINT pk_placement_furniture PRIMARY KEY (furniture_placement_id),
    CONSTRAINT fk_room FOREIGN KEY (fk_room_id) REFERENCES public.floor (floor_id),
    CONSTRAINT fk_furniture FOREIGN KEY (fk_furniture_id) REFERENCES public.furniture (furniture_id)
);

CREATE SEQUENCE furniture_placement_sequence OWNED BY public.furniture_placement.furniture_placement_id;
