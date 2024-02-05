@REQ_POECPR2G2-55
Feature: US 5 : Gestion de "My Account"

	@POECPR2G2-61 @lisa
	Scenario: Changement de mot de passe : Fail message 2
		Given le user va sur la page “My account”
		When le user se connecte
		And le user clique sur le lien “Account details”
		And le user saisi mon mot de passe actuel dans l’espace dédié
		And le user saisi un nouveau mot de passe
		And le user confirme avec un mot de passe erroné
		And le user clique sur Save Changes
		Then un message d’erreur "New passwords do not match" s’affiche
		
