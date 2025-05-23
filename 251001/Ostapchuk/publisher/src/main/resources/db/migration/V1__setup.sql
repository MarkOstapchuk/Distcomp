create table tbl_post
(
    id       bigint generated by default as identity,
    tweet_id bigint,
    content  varchar(2048) not null,
    primary key (id)
);

create table tbl_mark
(
    id   bigint generated by default as identity,
    name varchar(32) not null unique,
    primary key (id)
);

create table tbl_tweet
(
    created  timestamp(6)  not null,
    id       bigint generated by default as identity,
    modified timestamp(6),
    user_id  bigint,
    title    varchar(64)   not null,
    content  varchar(2048) not null,
    primary key (id)
);

create table tbl_user
(
    id        bigint generated by default as identity,
    firstname varchar(64)  not null,
    lastname  varchar(64)  not null,
    login     varchar(128) not null unique,
    password  varchar(128) not null,
    primary key (id)
);

alter table if exists tbl_post add constraint FK6qubiawume1w29ujtgksyft9p foreign key (tweet_id) references tbl_tweet;
alter table if exists tbl_tweet add constraint FKf6e9pviqql8um1pk96vebj4n7 foreign key (user_id) references tbl_user on delete set null;