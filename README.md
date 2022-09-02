# A15TP
This is the practical project for course A15

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
  relation between two tables:
    FK_Utilisateur_Tache FOREIGN KEY(UtilisateurID) REFERENCES TbL_Utilisateur(UtilisateurID)
  
we use MySQL online(https://www.alwaysdata.com) for access anywhere and anytime
  server: mysql-thomaswang.alwaysdata.net
  port: 3306
  database: thomaswang_a15_tp
  useSSL: false
We use JDBC for manipulate database
  String for JDBC: "jdbc:mysql://mysql-thomaswang.alwaysdata.net:3306/thomaswang_a15_tp?useSSL=false";

