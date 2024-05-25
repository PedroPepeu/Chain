/* Lógico_1: */

CREATE TABLE Administrador (
    engenheiroDeSoftwareId VARCHAR(10) PRIMARY KEY
);

CREATE TABLE Projeto (
    nome VARCHAR(50),
    idProjeto VARCHAR(10) PRIMARY KEY,
    administradorId VARCHAR(10)
);

CREATE TABLE Atividade (
    idAtividade VARCHAR(10) PRIMARY KEY,
    nome VARCHAR(50),
    dataInicio DATE,
    dataEntrega DATE,
    concluida BOOLEAN,
    projetoId VARCHAR(10)
);

CREATE TABLE Anotacao (
    idAnotacao VARCHAR(10) PRIMARY KEY,
    texto VARCHAR(250),
    dataAnotacao DATE,
    engenheiroDeSoftwareId VARCHAR(10)
);

CREATE TABLE EngenheiroDeSoftware (
    email VARCHAR(50),
    nome VARCHAR(50),
    idEngenheiro VARCHAR(10) PRIMARY KEY,
    senha VARCHAR(50)
);

CREATE TABLE MembroParticipa (
    cargo VARCHAR(50),
    engenheiroDeSoftwareId VARCHAR(10),
    projetoId VARCHAR(10)
);

CREATE TABLE Link (
    descricao VARCHAR(250),
    idLink VARCHAR(10) PRIMARY KEY,
    urlLink VARCHAR(250),
    projetoId VARCHAR(10)
);

CREATE TABLE Realizada (
    atividadeId VARCHAR(10)
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