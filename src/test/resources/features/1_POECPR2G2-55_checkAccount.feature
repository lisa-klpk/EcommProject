@REQ_POECPR2G2-55
Feature: US 5 : Gestion de "My Account"

	@POECPR2G2-56 @lisa
	Scenario: Check Account Details
		Given je vais sur la page “My account”
		When je me connecte
		And je clique sur le lien “Account details”
		Then le lien affiche les informations de compte (nom, prenom, mail)
		
