--
--  Create the album table
--

CREATE TABLE album (
  albumid INT PRIMARY KEY,
  title CHARACTER VARYING,
  artist CHARACTER VARYING,
  date_released DATE,
  genre CHARACTER VARYING,
  num_of_tracks INT,
  price NUMERIC
);

--
--  Create the album sequence object
--
DROP SEQUENCE public.album_id_seq;

CREATE SEQUENCE public.album_id_seq
  INCREMENT BY 100
  MINVALUE 1
  MAXVALUE 9223372036854775807  -- LONG!
  START 1
  CACHE 100;

--
--  Create application_user table
--
CREATE TABLE application_user (
  id INTEGER PRIMARY KEY,
  username CHARACTER VARYING ,
  password CHARACTER VARYING ,
  is_admin BOOLEAN
);

--
--  Create the game sequence object
--
DROP SEQUENCE public.application_user_id_seq;

CREATE SEQUENCE public.application_user_id_seq
  INCREMENT BY 100
  MINVALUE 1
  MAXVALUE 2147483647 -- INT!
  START 1
  CACHE 100;

CREATE TABLE artist (
  artistID INT PRIMARY KEY,
  artist_name CHARACTER VARYING,
  members INT
);

DROP SEQUENCE public.artist_id_seq;

CREATE SEQUENCE public.artist_id_seq
  INCREMENT BY 100
  MINVALUE 1
  MAXVALUE 2147483647 -- INT!
  START 1
  CACHE 100;








