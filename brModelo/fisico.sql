/* Lógico_1: */

CREATE TABLE administrador (
    engenheiro_de_software_id Integer PRIMARY KEY
);

CREATE TABLE projeto (
    nome VARCHAR(50),
    id Integer PRIMARY KEY,
    administrador_id Integer
);

CREATE TABLE atividade (
    id Integer PRIMARY KEY,
    nome VARCHAR(50),
    data_inicio DATE,
    data_entrega DATE,
    concluida BOOLEAN,
    projeto_id Integer
);

CREATE TABLE anotacao (
    id Integer PRIMARY KEY,
    texto VARCHAR(250),
    data_anotacao DATE,
    engenheiro_de_software_id Integer
);

CREATE TABLE engenheiro_de_software (
    email VARCHAR(50),
    nome VARCHAR(50),
    id Integer auto_increment PRIMARY KEY,
    senha VARCHAR(50)
);

CREATE TABLE membro_participa (
    cargo VARCHAR(50),
    engenheiro_de_software_id Integer,
    projeto_id INTEGER,
    id Integer
);

CREATE TABLE link (
    descricao VARCHAR(250),
    id Integer PRIMARY KEY,
    url_link VARCHAR(250),
    projeto_id Integer
);

CREATE TABLE realizada (
    atividade_id Integer
);
 
ALTER TABLE administrador ADD CONSTRAINT FK_Administrador_2
    FOREIGN KEY (engenheiro_de_software_id)
    REFERENCES engenheiro_de_software (id)
    ON DELETE CASCADE;
 
ALTER TABLE projeto ADD CONSTRAINT FK_Projeto_2
    FOREIGN KEY (administrador_id)
    REFERENCES administrador (engenheiro_de_software_id)
    ON DELETE CASCADE;
 
ALTER TABLE atividade ADD CONSTRAINT FK_Atividade_2
    FOREIGN KEY (projeto_id)
    REFERENCES projeto (id)
    ON DELETE CASCADE;
 
ALTER TABLE anotacao ADD CONSTRAINT FK_Anotacao_2
    FOREIGN KEY (engenheiro_de_software_id)
    REFERENCES engenheiro_de_software (id)
    ON DELETE CASCADE;
 
ALTER TABLE membro_participa ADD CONSTRAINT FK_Membro_Participa_1
    FOREIGN KEY (engenheiro_de_software_id)
    REFERENCES engenheiro_de_software (id);
 
ALTER TABLE membro_participa ADD CONSTRAINT FK_Membro_Participa_2
    FOREIGN KEY (projeto_id)
    REFERENCES projeto (id);
 
ALTER TABLE link ADD CONSTRAINT FK_Link_2
    FOREIGN KEY (projeto_id)
    REFERENCES projeto (id)
    ON DELETE CASCADE;
 
ALTER TABLE realizada ADD CONSTRAINT FK_Realizada_1
    FOREIGN KEY (atividade_id)
    REFERENCES atividade (id)
    ON DELETE SET NULL;