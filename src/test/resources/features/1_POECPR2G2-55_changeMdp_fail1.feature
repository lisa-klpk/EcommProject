@REQ_POECPR2G2-55
Feature: US 5 : Gestion de "My Account"

	@POECPR2G2-58 @lisa
	Scenario: Changement de mot de passe : Fail message 1
		Given je clique sur la page My Account
		When je me log
		And je me dirige sur Account details
		And je saisie un mot de passe errone dans l’espace dedie
		And je saisis un nouveau mot de passe
		And je saisis la confirmation du mot de passe
		And je clique sur Save Changes
		Then un message d’erreur s’affiche "Your current password is incorrect"
		
