/* Lógico_1: */

CREATE TABLE projeto (
    nome VARCHAR(50) NOT NULL,
    id INTEGER auto_increment PRIMARY KEY,
    administrador_id INTEGER NOT NULL
);

CREATE TABLE atividade (
    id INTEGER auto_increment PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(250),
    data_inicio DATE,
    data_entrega DATE,
    concluida BOOLEAN,
    projeto_id INTEGER NOT NULL
);

CREATE TABLE anotacao (
    id INTEGER auto_increment PRIMARY KEY,
    texto VARCHAR(250) NOT NULL,
    data_anotacao DATE NOT NULL,
    engenheiro_de_software_id INTEGER NOT NULL
);

CREATE TABLE engenheiro_de_software (
    email VARCHAR(50) NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL,
    id INTEGER auto_increment PRIMARY KEY,
    senha VARCHAR(50) NOT NULL
);

CREATE TABLE link (
    descricao VARCHAR(250),
    id INTEGER auto_increment PRIMARY KEY,
    url_link VARCHAR(250) NOT NULL,
    projeto_id INTEGER NOT NULL
);

CREATE TABLE participa (
    id INTEGER auto_increment PRIMARY KEY,
    engenheiro_de_software_id INTEGER,
    projeto_id INTEGER,
    cargo INTEGER NOT NULL
);

CREATE TABLE realiza (
    engenheiro_de_software_id INTEGER,
    atividade_id INTEGER
);
 
ALTER TABLE projeto ADD CONSTRAINT FK_projeto_2
    FOREIGN KEY (administrador_id)
    REFERENCES engenheiro_de_software (id)
    ON DELETE CASCADE;
 
ALTER TABLE atividade ADD CONSTRAINT FK_atividade_2
    FOREIGN KEY (projeto_id)
    REFERENCES projeto (id)
    ON DELETE CASCADE;
 
ALTER TABLE anotacao ADD CONSTRAINT FK_anotacao_2
    FOREIGN KEY (engenheiro_de_software_id)
    REFERENCES engenheiro_de_software (id)
    ON DELETE CASCADE;
 
ALTER TABLE link ADD CONSTRAINT FK_link_2
    FOREIGN KEY (projeto_id)
    REFERENCES projeto (id)
    ON DELETE CASCADE;
 
ALTER TABLE participa ADD CONSTRAINT FK_participa_1
    FOREIGN KEY (engenheiro_de_software_id)
    REFERENCES engenheiro_de_software (id)
    ON DELETE RESTRICT;
 
ALTER TABLE participa ADD CONSTRAINT FK_participa_2
    FOREIGN KEY (projeto_id)
    REFERENCES projeto (id)
    ON DELETE SET NULL;
 
ALTER TABLE realiza ADD CONSTRAINT FK_realiza_1
    FOREIGN KEY (engenheiro_de_software_id)
    REFERENCES engenheiro_de_software (id)
    ON DELETE SET NULL;
 
ALTER TABLE realiza ADD CONSTRAINT FK_realiza_2
    FOREIGN KEY (atividade_id)
    REFERENCES atividade (id)
    ON DELETE SET NULL;