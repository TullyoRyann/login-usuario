insert into USUARIO  (ID_USUARIO, LOGIN, SENHA ) values (1, 'tullyo', '$2a$10$DdLFbdt/bYWEw.3jq90Yvu87H5dfnThDfp5gEviBzc5I32MWTfpLO');
insert into USUARIO  (ID_USUARIO, LOGIN, SENHA ) values (2, 'jessica', '$2a$10$DdLFbdt/bYWEw.3jq90Yvu87H5dfnThDfp5gEviBzc5I32MWTfpLO');
insert into USUARIO  (ID_USUARIO, LOGIN, SENHA ) values (3, 'pedro', '$2a$10$DdLFbdt/bYWEw.3jq90Yvu87H5dfnThDfp5gEviBzc5I32MWTfpLO');
insert into USUARIO  (ID_USUARIO, LOGIN, SENHA ) values (4, 'jô', '$2a$10$DdLFbdt/bYWEw.3jq90Yvu87H5dfnThDfp5gEviBzc5I32MWTfpLO');

insert into PERFIL  (ID_PERFIL , NOME) values (1, 'ADMIN');
insert into PERFIL  (ID_PERFIL , NOME ) values (2, 'FUNCIONARIO');
insert into PERFIL  (ID_PERFIL , NOME ) values (3, 'RH');

insert into USUARIO_PERFIL   (ID_USUARIO, ID_PERFIL) values (1, 1);
insert into USUARIO_PERFIL  (ID_USUARIO, ID_PERFIL) values (2, 2);
insert into USUARIO_PERFIL  (ID_USUARIO, ID_PERFIL) values (2, 3);
insert into USUARIO_PERFIL  (ID_USUARIO, ID_PERFIL) values (3, 2);
insert into USUARIO_PERFIL  (ID_USUARIO, ID_PERFIL) values (3, 3);