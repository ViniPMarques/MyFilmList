create table assistir(
                          idusuario int not null,
                          idfilme int not null,
                          situacao varchar(20) not null,
                          primary key(idusuario, idfilme),
                          foreign key (idusuario) references Usuario (idusuario),
                          foreign key (idfilme) references Filme (idfilme)
)