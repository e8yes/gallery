SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;;

SET search_path = public, pg_catalog;
SET default_tablespace = '';
SET default_with_oids = false;

CREATE TABLE IF NOT EXISTS HealthChecker (
    id CHARACTER VARYING NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE HealthChecker OWNER TO postgres;

INSERT INTO HealthChecker(id) VALUES ('e574abc3-2a08-4cd5-8324-34c1a5500c23')
ON CONFLICT (id) DO NOTHING;
