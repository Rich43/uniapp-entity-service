CREATE SCHEMA IF NOT EXISTS entities;

create table entities.entities
(
    id     bigint unsigned auto_increment
        primary key,
    name   varchar(255)    not null,
    parent bigint unsigned not null,
    constraint unq_entities_name_parent
        unique (name, parent),
    constraint fk_entities_entities
        foreign key (parent) references entities (id),
    constraint cns_entities_all_lowercase
        check (sha2(`name`, 256) = sha2(lower(`name`), 256)),
    constraint cns_entities_ascii_chars
        check (regexp_like(`name`, '^[a-z]+$') = 1)
);

INSERT INTO entities.entities (id, name, parent) VALUES (1, 'root', 1);

CREATE USER IF NOT EXISTS 'entities'@'%' IDENTIFIED BY 'Password1';
GRANT SELECT, INSERT, UPDATE, DELETE ON entities.entities TO 'entities'@'%';
FLUSH PRIVILEGES;
