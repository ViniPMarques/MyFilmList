create table usuario(
                        idusuario serial not null primary key,
                        nomeusuario varchar(50) not null,
                        email varchar(50) not null unique,
                        senha varchar(255) not null,
                        idpermissao int not null,
                        ativo boolean default true,
                        foreign key (idpermissao) references permissao (idpermissao)
)