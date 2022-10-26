# A15TP
This is the practical project for RESTful API

Objectif:

  We want to develop REST API Web in JAX-RS (Jersey implementation) for the management of tasks based on the following conceptual model:
  1. Table Utilisateur:
  
    -id: int
    -NomComplet: varchar(255)
    
  2. Table Tache:
  
    -id: int
    -Description: varchar(255)
    -DateCreation: datetime
    -Duree: int
    -IdUtilisateur:int
    
  3. Relation between two tables:
  
    FK_Utilisateur_Tache FOREIGN KEY(UtilisateurID) REFERENCES TbL_Utilisateur(UtilisateurID)
  
  4. DataBase:

    We use MySQL online(https://www.alwaysdata.com) for access anywhere and anytime

      server: mysql-thomaswang.alwaysdata.net
      port: 3306
      database: thomaswang_a15_tp
      useSSL: false

      We use JDBC for access database
      -String connection for JDBC: "jdbc:mysql://mysql-thomaswang.alwaysdata.net:3306/thomaswang_a15_tp?useSSL=false";
      -user: "278692_a15_tp"
      -pwd: "xyz098!!"
  5. Script SQL
  
    
    CREATE TABLE TbL_Utilisateur
    (UtilisateurID int PRIMARY KEY AUTO_INCREMENT,
    NomComplet varchar(255));

    CREATE TABLE TbL_Tache
    (TacheID int PRIMARY KEY AUTO_INCREMENT,
    Description varchar(255),
    DateCreation datetime,
    Duree int,
    UtilisateurID int);

    ALTER TABLE TbL_Tache
      ADD CONSTRAINT FK_Utilisateur_Tache FOREIGN KEY(UtilisateurID) REFERENCES TbL_Utilisateur(UtilisateurID);
