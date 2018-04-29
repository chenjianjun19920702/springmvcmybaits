/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017-11-3 11:12:25                           */
/*==============================================================*/


drop table if exists author;

drop table if exists blog;

drop table if exists comment;

drop table if exists forward;

/*==============================================================*/
/* Table: author                                                */
/*==============================================================*/
create table author
(
   author_id            int not null auto_increment,
   name                 varchar(32),
   age                  smallint,
   address              varchar(128),
   email                varchar(128),
   tel                  varchar(32),
   primary key (author_id)
);

/*==============================================================*/
/* Table: blog                                                  */
/*==============================================================*/
create table blog
(
   blog_id              int not null auto_increment,
   author_id            int,
   name                 varchar(256),
   brief                varchar(256),
   content              varchar(1024),
   source               varchar(256),
   primary key (blog_id)
);

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   comment_id           int not null auto_increment,
   name                 varchar(32),
   content              varchar(256),
   time                 TIMESTAMP not null default CURRENT_TIMESTAMP,
   status               char(1),
   blog_id              int,
   primary key (comment_id)
);

/*==============================================================*/
/* Table: forward                                               */
/*==============================================================*/
create table forward
(
   forward_id           int not null auto_increment,
   direction            varchar(256),
   name                 varchar(32),
   blog_id              int,
   primary key (forward_id)
);

alter table blog add constraint FK_Reference_1 foreign key (author_id)
      references author (author_id) on delete restrict on update restrict;

alter table comment add constraint FK_Reference_4 foreign key (blog_id)
      references blog (blog_id) on delete restrict on update restrict;

alter table forward add constraint FK_Reference_3 foreign key (blog_id)
      references blog (blog_id) on delete restrict on update restrict;
      
insert into author(name,age,address,email,tel) values('cjj',25,'zhfgdgd','cjj@zjipst.com','121313');
insert into author(name,age,address,email,tel) values('test',25,'zhfgdgd','test@zjipst.com','121313');
insert into author(name,age,address,email,tel) values('admin',25,'zhfgdgd','admin@zjipst.com','121313');

insert into blog(author_id,name,brief,content,source) values(1,'博客测试1','博客测试1','博客测试1。。博客测试1。。博客测试1','internet');
insert into blog(author_id,name,brief,content,source) values(1,'博客测试2','博客测试2','博客测试2。。博客测试2。。博客测试3','internet');
insert into blog(author_id,name,brief,content,source) values(1,'博客测试3','博客测试3','博客测试3。。博客测试3。。博客测试3','internet');

insert into comment(blog_id,name,content,status) values(1,'qinglun1','dfcdfd','0');
insert into comment(blog_id,name,content,status) values(1,'qinglun2','dfcdfd','0');
insert into comment(blog_id,name,content,status) values(1,'qinglun3','dfcdfd','0');

insert into forward(blog_id,name,direction) values(1,'qinglun1','qq');
insert into forward(blog_id,name,direction) values(1,'qinglun2','qq');
insert into forward(blog_id,name,direction) values(1,'qinglun3','qq');



