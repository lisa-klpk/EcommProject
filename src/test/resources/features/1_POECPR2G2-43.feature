@REQ_POECPR2G2-43
Feature: US 2: Connexion au compte

	@POECPR2G2-44 @Test_jira
	Scenario: Connexion à l'espace "Myaccount"
		Given jouvre l'espace My Account
		When je saisis Login et mot de passe
		And je clique sur bouton Login
		Then lécran Dashboard doit s'afficher
		And Les liens renvoyant aux pages Dashboard, Orders, Download, Adresses, Account details, Logout doivent s'afficher
		
	@POECPR2G2-45 @Test_jira
	Scenario: Connexion avec mot de passe erroné
		Given j'accède à la page Myaccount
		When je saisis un login valide et mot de passe invalide
		And je clique sur login
		Then un message d'erreur s'affiche
		
	@POECPR2G2-48 @Test_jira
	Scenario: Case "Remember me"
		Given J'ouvre le site Myaccount
		When je me connecte et je clique sur checkbox
		Then le login de la connexion précédente apparait lors de la prochaine connexion
		
