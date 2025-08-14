CREATE USER tester WITH PASSWORD '1234';

CREATE DATABASE simple_library OWNER tester;

GRANT ALL PRIVILEGES ON DATABASE simple_library TO tester;

\c simple_library tester

CREATE TYPE "book_condition" AS ENUM (
  'NEW',
  'USED',
  'DAMAGED',
  'UNRECOVERABLE',
  'LOST'
);

CREATE TYPE "book_status" AS ENUM (
  'AVAILABLE',
  'OUT_OF_STOCK',
  'LOST',
  'UNAVAILABLE',
  'DELETED'
);

CREATE TYPE "user_status" AS ENUM (
  'REGISTERED',
  'BANNED',
  'DELETED'
);

CREATE TYPE "author_status" AS ENUM (
  'ALIVE',
  'DECEASED',
  'DELETED'
);

CREATE TYPE "reservation_status" AS ENUM (
  'BORROWED',
  'CANCELLED',
  'LOST',
  'RETURNED',
  'OVERDUE'
);

CREATE TABLE "users" (
  "id" uuid PRIMARY KEY NOT NULL,
  "name" varchar(100) UNIQUE NOT NULL,
  "nickname" varchar(32) NOT NULL,
  "email" varchar(254) UNIQUE NOT NULL,
  "hashed_password" bytea NOT NULL,
  "status" user_status NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT (now()),
  "last_update_at" timestamp NOT NULL DEFAULT (now())
);

CREATE TABLE "reviews" (
  "id" uuid PRIMARY KEY NOT NULL,
  "user_id" uuid NOT NULL,
  "book_id" uuid NOT NULL,
  "title" varchar(120) NOT NULL,
  "comment" text,
  "score" int NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT (now()),
  "last_update_at" timestamp NOT NULL DEFAULT (now())
);

CREATE TABLE "books" (
  "id" uuid PRIMARY KEY NOT NULL,
  "title" varchar(120) NOT NULL,
  "description" text,
  "language" varchar(10) NOT NULL,
  "publication_date" timestamp,
  "price" numeric(8,2) NOT NULL,
  "condition" book_condition NOT NULL,
  "status" book_status NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT (now()),
  "last_update_at" timestamp NOT NULL DEFAULT (now())
);

CREATE TABLE "books_authors" (
  "id" uuid PRIMARY KEY NOT NULL,
  "book_id" uuid NOT NULL,
  "author_id" uuid NOT NULL
);

CREATE TABLE "authors" (
  "id" uuid PRIMARY KEY NOT NULL,
  "name" varchar(100) NOT NULL,
  "bios" text,
  "birth_date" timestamp,
  "nationality" varchar(32) NOT NULL,
  "status" author_status NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT (now()),
  "last_update_at" timestamp NOT NULL DEFAULT (now())
);

CREATE TABLE "reservations" (
  "id" uuid PRIMARY KEY NOT NULL,
  "user_id" uuid NOT NULL,
  "book_id" uuid NOT NULL,
  "borrowing_date" timestamp NOT NULL,
  "expected_return_date" timestamp NOT NULL,
  "return_date" timestamp,
  "applied_price" numeric(8,2) NOT NULL,
  "status" reservation_status NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT (now()),
  "last_update_at" timestamp NOT NULL DEFAULT (now())
);

ALTER TABLE "reviews" ADD CONSTRAINT "user_reviews" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "reviews" ADD CONSTRAINT "book_reviews" FOREIGN KEY ("book_id") REFERENCES "books" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "reservations" ADD CONSTRAINT "user_reservations" FOREIGN KEY ("user_id") REFERENCES "users" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "reservations" ADD CONSTRAINT "book_reservations" FOREIGN KEY ("book_id") REFERENCES "books" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "books_authors" ADD CONSTRAINT "author_to_books" FOREIGN KEY ("author_id") REFERENCES "authors" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "books_authors" ADD CONSTRAINT "book_to_authors" FOREIGN KEY ("book_id") REFERENCES "books" ("id") ON DELETE RESTRICT ON UPDATE CASCADE;


GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO tester;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO tester;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO tester;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO tester;

CREATE CAST (varchar AS book_condition) WITH INOUT AS IMPLICIT;
CREATE CAST (varchar AS book_status) WITH INOUT AS IMPLICIT;
CREATE CAST (varchar AS user_status) WITH INOUT AS IMPLICIT;
CREATE CAST (varchar AS author_status) WITH INOUT AS IMPLICIT;
CREATE CAST (varchar AS reservation_status) WITH INOUT AS IMPLICIT;

CREATE CAST (book_condition AS varchar) WITH INOUT AS IMPLICIT;
CREATE CAST (book_status AS varchar) WITH INOUT AS IMPLICIT;
CREATE CAST (user_status AS varchar) WITH INOUT AS IMPLICIT;
CREATE CAST (author_status AS varchar) WITH INOUT AS IMPLICIT;
CREATE CAST (reservation_status AS varchar) WITH INOUT AS IMPLICIT;
