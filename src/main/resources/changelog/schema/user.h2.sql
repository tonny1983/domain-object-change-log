--liquibase formatted sql

--changeset eorion-tc:1 dbms:h2
CREATE TABLE revinfo
(
    rev         INT auto_increment,
    revtstmp    BIGINT,
    CONSTRAINT pk_revinfo PRIMARY KEY (rev)
);

CREATE TABLE user
(
    id          INT auto_increment,
    account     VARCHAR(255),
    password    VARCHAR(255),
    name        VARCHAR(255),
    create_time TIMESTAMP,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_aud
(
    rev         INT,
    revtype     SMALLINT,
    id          INT,
    account     VARCHAR(255),
    password    VARCHAR(255),
    name        VARCHAR(255),
    create_time TIMESTAMP,
    CONSTRAINT fk_users_aud_revinfo FOREIGN KEY (rev) REFERENCES revinfo(rev)
);