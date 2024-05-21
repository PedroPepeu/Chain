/* Lógico_1: */

CREATE TABLE Administrador (
    Engenheiro_de_Software_Id VARCHAR[10] PRIMARY KEY
);

CREATE TABLE Projeto (
    Nome VARCHAR[50],
    Id_projeto VARCHAR[10] PRIMARY KEY,
    Administrador_Id VARCHAR[10]
);

CREATE TABLE Atividade (
    Id_atividade VARCHAR[10] PRIMARY KEY,
    Nome VARCHAR[50],
    Data_inicio DATE,
    Data_entrega DATE,
    Concluida BOOLEAN,
    Projeto_Id VARCHAR[10]
);

CREATE TABLE Anotacao (
    Id_anotacao VARCHAR[10] PRIMARY KEY,
    Texto VARCHAR[250],
    Data_anotacao DATE,
    Engenheiro_de_Software_Id VARCHAR[10]
);

CREATE TABLE Engenheiro_de_Software (
    Email VARCHAR[50],
    Nome VARCHAR[50],
    Id_engenheiro VARCHAR[10] PRIMARY KEY,
    Senha VARCHAR[50]
);

CREATE TABLE Membro_Participa (
    Cargo VARCHAR[50],
    Engenheiro_de_Software_Id VARCHAR[10],
    Projeto_Id VARCHAR[10]
);

CREATE TABLE Link (
    Descricao VARCHAR[250],
    Id_link VARCHAR[10] PRIMARY KEY,
    Url_link VARCHAR[250],
    Projeto_Id VARCHAR[10]
);

CREATE TABLE Realizada (
    Atividade_Id VARCHAR[10]
);
 
ALTER TABLE Administrador ADD CONSTRAINT FK_Administrador_2
    FOREIGN KEY (Engenheiro_de_Software_Id)
    REFERENCES Engenheiro_de_Software (Id_engenheiro)
    ON DELETE CASCADE;
 
ALTER TABLE Projeto ADD CONSTRAINT FK_Projeto_2
    FOREIGN KEY (Administrador_Id)
    REFERENCES Administrador (Engenheiro_de_Software_Id)
    ON DELETE CASCADE;
 
ALTER TABLE Atividade ADD CONSTRAINT FK_Atividade_2
    FOREIGN KEY (Projeto_Id)
    REFERENCES Projeto (Id_projeto)
    ON DELETE CASCADE;
 
ALTER TABLE Anotacao ADD CONSTRAINT FK_Anotacao_2
    FOREIGN KEY (Engenheiro_de_Software_Id)
    REFERENCES Engenheiro_de_Software (Id_engenheiro)
    ON DELETE CASCADE;
 
ALTER TABLE Membro_Participa ADD CONSTRAINT FK_Membro_Participa_1
    FOREIGN KEY (Engenheiro_de_Software_Id)
    REFERENCES Engenheiro_de_Software (Id_engenheiro);
 
ALTER TABLE Membro_Participa ADD CONSTRAINT FK_Membro_Participa_2
    FOREIGN KEY (Projeto_Id)
    REFERENCES Projeto (Id_projeto);
 
ALTER TABLE Link ADD CONSTRAINT FK_Link_2
    FOREIGN KEY (Projeto_Id)
    REFERENCES Projeto (Id_projeto)
    ON DELETE CASCADE;
 
ALTER TABLE Realizada ADD CONSTRAINT FK_Realizada_1
    FOREIGN KEY (Atividade_Id)
    REFERENCES Atividade (Id_atividade)
    ON DELETE SET NULL;