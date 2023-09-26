create table ParaAssistir(
                             idUsuario int not null primary key,
                             idFilme int not null,
                             foreign key (idUsuario) references Usuario (idUsuario),
                             foreign key (idFilme) references Filme (idFilme)
)