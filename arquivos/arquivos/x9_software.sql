CREATE DATABASE "X9" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';

CREATE TABLE professor (
    id_professor serial NOT NULL primary key,
    nome character(200),
    sexo character(1),
    cpf character(15),
    cep character(15),
    rua character(150),
    numero integer,
    bairro character(130),
    cidade character(100),
    cod_siape character(50),
    email character(200),
    celular character(30),
    "uf" character(2),
    telefone_fixo character(30)
);

CREATE TABLE curso (
    id_curso serial NOT NULL primary key,
    descricao_curso character varying(60),
    quantidadeModulos int not null
);

CREATE TABLE disciplina (
    id_disciplina serial NOT NULL primary key,
    descricao_disciplina character(200),
    carga_horaria integer
);

CREATE TABLE CursoDisciplina (
    id_disciplina int NOT NULL,
    id_curso int not null,
    modulo integer,
foreign key (id_curso) references curso (id_curso)
);

CREATE TABLE turma (
    id_turma serial NOT NULL primary key,
    id_curso int not null,
    descricao_turma character varying(60),
    turno_turma character varying(15),
    ano_turma integer,
foreign key (id_disciplina)references disciplina (id_disciplina),
foreign key (id_curso) references curso (id_curso)
);

CREATE TABLE periodo (
    id_periodo serial NOT NULL primary key,
    id_disciplina integer,
    id_curso integer,
    ano character(150),
foreign key (id_disciplina)references disciplina (id_disciplina),
foreign key (id_curso)references curso (id_curso)
);

CREATE TABLE horario (
    "id_horario" serial NOT NULL primary key,
    id_professor integer not null,
    "id_turma" integer,
    "id_disciplina" character(300),
    "hora_inicio" character(20),
    "hora_fim" character(20), 
    "data" date,
    "status" character(50),
foreign key (id_professor)references professor (id_professor)
);


CREATE TABLE ocorrencia (
    "idOcorrencia" serial NOT NULL primary key,
id_professor integer not null,
    "dataOcorrencia" date,
    observacao character(300),
    "descricaoOcorrencia" character(500),
foreign key (id_professor)references professor (id_professor)
);











