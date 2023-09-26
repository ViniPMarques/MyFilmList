create table Filme(
                      idFilme serial not null primary key,
                      nomeFilme varchar(50) not null,
                      descrição varchar(5000) not null,
                      duracao int not null,
                      genero varchar(50) not null
)
