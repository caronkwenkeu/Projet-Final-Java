**Projet Gestion des Étudiants, leurs Cours et Notes en Java**

**Description**
Ce projet est une base pour un système de gestion des étudiants, leurs cours et notes en Java.
Il contient la structure initiale des classes nécessaires à la modélisation des entités suivantes :
- Étudiant
- Gestion Etudiants
- Classe principale pour exécuter l'application
  
Le projet comporte les éléments suivants :

├── Etudiant.java            # Classe représentant un étudiant avec matricule, nom, cours et note

├── GestionEtudiants.java    # Classe gérant la liste d'étudiants, import/export des données, calculs

├── Notes_Etudiants.csv      # Fichier CSV contenant les notes des étudiants

├── Test.java                # Programme principal avec menu interactif pour gérer les notes

**Contributions**

-***Mbomegni Nana Carole*** : Conception de la structure de la classe Etudiant à travers la création du modèle objet, définition des attributs et constructeurs, et développement de la sortie console classe (Test).

-***Roslin Ivan Jouanang Komguep*** : Implémentation de la gestion des étudiants (GestionEtudiants) et conception du fichier de données (Notes_Etudiants).

**Description des fichiers**
1. Etudiant.java
Définit les attributs : Matricule, Nom, Cours, Note.
Fournit un constructeur pour initialiser un étudiant.
Contient des méthodes pour accéder aux données (getters) et éventuellement afficher les informations.

2.GestionEtudiants.java
Contient une List<Etudiant> pour stocker les étudiants.
Méthodes principales :
importerDonnees(String cheminFichier) : Lit un fichier CSV et ajoute les étudiants à la liste.
calculerMoyennes() : Calcule la moyenne des notes par étudiant.
classerEtudiants() : Trie les étudiants par moyenne décroissante.
sauvegarderResultats(String fichierSortie) : Enregistre les résultats dans un fichier CSV.

3.Notes_Etudiants.csv
Fichier CSV (séparateur ;) contenant les données d’entrée.

4. Test.java
Interface console interactive.
Menu avec options :
Afficher la liste des étudiants
Calculer la moyenne de chaque étudiant
Classer les étudiants par moyenne
Sauvegarder les résultats dans un fichier
Quitter


**INSTALLATION ET EXECUTION**
javac Etudiant.java GestionEtudiants.java Test.java
java Test
