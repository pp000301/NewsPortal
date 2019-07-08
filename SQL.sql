CREATE DATABASE final_progect_JD2;
CREATE SCHEMA news_portal;
SET SEARCH_PATH = "news_portal";

CREATE TABLE news_portal.news
(
    id            BIGSERIAL PRIMARY KEY,
    title         VARCHAR(256),
    content       VARCHAR,
    count_coments BIGINT,
    created_date  TIMESTAMP,
    autor_id BIGINT REFERENCES autor(id)
);

CREATE TABLE news_portal.category_news
(
    id    BIGSERIAL PRIMARY KEY,
    title VARCHAR(256)
);

CREATE TABLE news_portal.autor
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(128)
);

CREATE TABLE news_portal.mm_news_news_category
(
    news_id          BIGINT REFERENCES news (id),
    news_category_id BIGINT REFERENCES category_news (id),
    PRIMARY KEY (news_id,news_category_id)
);

CREATE TABLE news_portal.users
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(128) NOT NULL UNIQUE ,
    login    VARCHAR(128) NOT NULL UNIQUE ,
    password VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE news_portal.role_users
(
  id BIGSERIAL PRIMARY KEY ,
  role VARCHAR(128),
  users_id BIGINT REFERENCES news_portal.users(id)
);

CREATE TABLE news_portal.comments
(
    id               BIGSERIAL PRIMARY KEY,
    comments_user_id BIGINT REFERENCES news_portal.users (id),
    comments_news_id BIGINT REFERENCES news_portal.news(id),
    comment_body     VARCHAR,
    created_date     TIMESTAMP
);