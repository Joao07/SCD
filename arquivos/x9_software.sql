CREATE DATABASE "X9" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';

connect "X9";

CREATE TABLE curso (
    id_curso serial NOT NULL primary key,
    descricao_curso character varying(60)
);

CREATE TABLE disciplina (
    id_disciplina serial NOT NULL primary key,
    descricao_disciplina character(200),
    carga_horaria integer
);

CREATE TABLE ocorrencia (
    "idOcorrencia" serial NOT NULL primary key,
    "dataOcorrencia" date,
    observacao character(300),
    "descricaoOcorrencia" character(500)
);

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
    telefone_fixo character(30)
);


CREATE TABLE turma (
    id_turma serial NOT NULL primary key,
    descricao_turma character varying(60),
    turno_turma character varying(15),
    ano_turma integer
);

