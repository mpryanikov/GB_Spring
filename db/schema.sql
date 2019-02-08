DROP SCHEMA IF EXISTS advertisement CASCADE;

CREATE SCHEMA "advertisement";

CREATE TABLE advertisement.company (
  company_id          SERIAL,
  company_name        TEXT NOT NULL,
  company_description TEXT,
  company_address     TEXT,
  PRIMARY KEY (company_id)
);

CREATE TABLE advertisement."category" (
  category_id            SERIAL,
  category_name          TEXT NOT NULL,
  PRIMARY KEY (category_id)
);

CREATE TABLE advertisement.ad (
  ad_id          SERIAL,
  category_id    INT4 NOT NULL REFERENCES advertisement.category,
  ad_name        TEXT NOT NULL,
  ad_content     TEXT NOT NULL,
  ad_phone       CHAR(10) NOT NULL,
  PRIMARY KEY (ad_id)
);

