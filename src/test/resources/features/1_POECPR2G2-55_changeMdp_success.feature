@REQ_POECPR2G2-55
Feature: US 5 : Gestion de "My Account"

	@POECPR2G2-79 @lisa
	Scenario: Changement mot de passe : Succès
		Given je me dirige sur la page My Account
		When je me connect
		And je clique sur Account details
		And je saisie mon mot de passe actuel dans l’espace dedie
		And je saisie un nouveau mot de passe
		And je confirme le nouveau mot de passe
		And je clique sur le bouton Save Changes
		Then un message de succès "Account details changed successfully." s'affiche
		
