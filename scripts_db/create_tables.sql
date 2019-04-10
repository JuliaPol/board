CREATE TABLE user (
  id         SERIAL PRIMARY KEY,
  login      VARCHAR(50) UNIQUE NOT NULL,
  password   VARCHAR(255)       NOT NULL,
  first_name VARCHAR(255),
  last_name  VARCHAR(255),
  email      VARCHAR(255)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE board (
  id         SERIAL PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  board_link VARCHAR(255) NOT NULL UNIQUE,
  background VARCHAR(255)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE column_status (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE task_marker (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE column_in_board (
  id               SERIAL PRIMARY KEY,
  name             VARCHAR(255) NOT NULL,
  number           INT UNSIGNED,
  column_link      VARCHAR(255) NOT NULL UNIQUE,
  board_id         BIGINT REFERENCES board (id),
  column_status_id BIGINT REFERENCES column_status (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE task (
  id               SERIAL PRIMARY KEY,
  name             VARCHAR(255) NOT NULL,
  description      TEXT(1500),
  column_id        BIGINT REFERENCES column_in_board (id),
  date_of_creation DATE,
  expiration_date  DATE,
  email            VARCHAR(255),
  task_link        VARCHAR(255) NOT NULL UNIQUE,
  task_marker_id   BIGINT REFERENCES task_marker (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE user_board (
  user_id  BIGINT REFERENCES user (id),
  board_id BIGINT REFERENCES board (id),
  PRIMARY KEY (user_id, board_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE user_task (
  user_id BIGINT REFERENCES user (id),
  task_id BIGINT REFERENCES task (id),
  PRIMARY KEY (user_id, task_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE user_comment (
  id               SERIAL PRIMARY KEY,
  description      TEXT(700),
  date_of_creation DATE,
  user_id          BIGINT REFERENCES user (id),
  task_id          BIGINT REFERENCES task (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;