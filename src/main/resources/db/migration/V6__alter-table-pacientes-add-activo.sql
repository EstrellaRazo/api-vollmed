alter table pacientes add activo tinyint not null;
update medicos set activo = 1;