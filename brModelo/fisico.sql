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
    id Integer
);

CREATE TABLE link (
    descricao VARCHAR(250),
    id Integer PRIMARY KEY,
    urlLink VARCHAR(250),
    projetoId Integer
);

CREATE TABLE realizada (
    id Integer
);
 
ALTER TABLE Administrador ADD CONSTRAINT FK_Administrador_2
    FOREIGN KEY (engenheiroDeSoftwareId)
    REFERENCES EngenheiroDeSoftware (idEngenheiro)
    ON DELETE CASCADE;
 
ALTER TABLE Projeto ADD CONSTRAINT FK_Projeto_2
    FOREIGN KEY (administradorId)
    REFERENCES Administrador (engenheiroDeSoftwareId)
    ON DELETE CASCADE;
 
ALTER TABLE Atividade ADD CONSTRAINT FK_Atividade_2
    FOREIGN KEY (projetoId)
    REFERENCES Projeto (idProjeto)
    ON DELETE CASCADE;
 
ALTER TABLE Anotacao ADD CONSTRAINT FK_Anotacao_2
    FOREIGN KEY (engenheiroDeSoftwareId)
    REFERENCES EngenheiroDeSoftware (idEngenheiro)
    ON DELETE CASCADE;
 
ALTER TABLE MembroParticipa ADD CONSTRAINT FK_Membro_Participa_1
    FOREIGN KEY (engenheiroDeSoftwareId)
    REFERENCES EngenheiroDeSoftware (idEngenheiro);
 
ALTER TABLE MembroParticipa ADD CONSTRAINT FK_Membro_Participa_2
    FOREIGN KEY (projetoId)
    REFERENCES Projeto (idProjeto);
 
ALTER TABLE Link ADD CONSTRAINT FK_Link_2
    FOREIGN KEY (projetoId)
    REFERENCES Projeto (idProjeto)
    ON DELETE CASCADE;
 
ALTER TABLE Realizada ADD CONSTRAINT FK_Realizada_1
    FOREIGN KEY (atividadeId)
    REFERENCES Atividade (idAtividade)
    ON DELETE SET NULL;