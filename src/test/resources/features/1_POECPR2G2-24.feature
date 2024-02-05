@REQ_POECPR2G2-24
Feature: US 1 : Création de compte client


	@POECPR2G2-25 @Test_jira
	Scenario: Création de compte sur l’espace my account
		Given j'ouvre espace myaccount
		When je saisis mail et mot de passe
		And je clique sur Register
		Then Le compte client est cree
		
	@POECPR2G2-89 @Test_jira
	Scenario: Création de compte client avec mot de passe invalide
		Given j'ouvre un espace myaccount
		When je saisis un mail valide et un mot de passe invalide
		And Je clique sur le bouton register
		Then Le compte client n'est pas cree
		
