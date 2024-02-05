@REQ_POECPR2G2-65
Feature: US 6 : Déconnexion espace client

	@POECPR2G2-67 @lisa
	Scenario: Déconnexion espace client
		Given je me dirige sur la page “My account”
		When je saisis Login et mot de passe
		And je clique sur bouton Login
		And je clique sur le lien “Logout”
		Then je suis déconnecté de mon espace
		
