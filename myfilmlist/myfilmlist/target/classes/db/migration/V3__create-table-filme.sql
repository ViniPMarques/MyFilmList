create table filme(
                      idfilme serial not null primary key,
                      nomefilme varchar(50) not null,
                      descricao varchar(5000) not null,
                      duracao int not null,
                      genero varchar(50) not null
)
