/* Lógico_1: */

CREATE TABLE administrador (
    engenheiroDeSoftwareId Integer PRIMARY KEY
);

CREATE TABLE projeto (
    nome VARCHAR(50),
    id Integer PRIMARY KEY,
    administradorId Integer
);

CREATE TABLE atividade (
    id Integer PRIMARY KEY,
    nome VARCHAR(50),
    dataInicio DATE,
    dataEntrega DATE,
    concluida BOOLEAN,
    projetoId Integer
);

CREATE TABLE anotacao (
    id Integer PRIMARY KEY,
    texto VARCHAR(250),
    dataAnotacao DATE,
    engenheiroDeSoftwareId Integer
);

CREATE TABLE engenheiro_de_software (
    email VARCHAR(50),
    nome VARCHAR(50),
    id Integer auto_increment PRIMARY KEY,
    senha VARCHAR(50)
);

CREATE TABLE membro_participa (
    cargo VARCHAR(50),
    engenheiroDeSoftwareId Integer,
    projetoId INTEGER,
    id Integer
);

CREATE TABLE link (
    descricao VARCHAR(250),
    id Integer PRIMARY KEY,
    urlLink VARCHAR(250),
    projetoId Integer
);

CREATE TABLE realizada (
    atividadeId Integer
);
 
ALTER TABLE administrador ADD CONSTRAINT FK_Administrador_2
    FOREIGN KEY (engenheiroDeSoftwareId)
    REFERENCES engenheiro_de_software (id)
    ON DELETE CASCADE;
 
ALTER TABLE projeto ADD CONSTRAINT FK_Projeto_2
    FOREIGN KEY (administradorId)
    REFERENCES administrador (engenheiroDeSoftwareId)
    ON DELETE CASCADE;
 
ALTER TABLE atividade ADD CONSTRAINT FK_Atividade_2
    FOREIGN KEY (projetoId)
    REFERENCES projeto (id)
    ON DELETE CASCADE;
 
ALTER TABLE anotacao ADD CONSTRAINT FK_Anotacao_2
    FOREIGN KEY (engenheiroDeSoftwareId)
    REFERENCES engenheiro_de_software (id)
    ON DELETE CASCADE;
 
ALTER TABLE membro_participa ADD CONSTRAINT FK_Membro_Participa_1
    FOREIGN KEY (engenheiroDeSoftwareId)
    REFERENCES engenheiro_de_software (id);
 
ALTER TABLE membro_participa ADD CONSTRAINT FK_Membro_Participa_2
    FOREIGN KEY (projetoId)
    REFERENCES projeto (id);
 
ALTER TABLE link ADD CONSTRAINT FK_Link_2
    FOREIGN KEY (projetoId)
    REFERENCES projeto (id)
    ON DELETE CASCADE;
 
ALTER TABLE realizada ADD CONSTRAINT FK_Realizada_1
    FOREIGN KEY (atividadeId)
    REFERENCES atividade (id)
    ON DELETE SET NULL;