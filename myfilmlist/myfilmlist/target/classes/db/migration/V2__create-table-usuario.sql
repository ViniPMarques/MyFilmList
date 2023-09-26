create table Usuario(
                        idUsuario serial not null primary key,
                        nomeUsuario varchar(50) not null,
                        email varchar(50) not null unique,
                        senha varchar(50) not null,
                        idPermissao int not null,
                        Foreign key (idPermissao) references Permissao (idPermissao)
)