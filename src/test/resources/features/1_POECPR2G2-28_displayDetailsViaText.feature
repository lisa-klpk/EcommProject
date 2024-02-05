@REQ_POECPR2G2-28
Feature: US 7 : Ajouter des articles au panier depuis la page ‘Shop’

	@POECPR2G2-78 @Jaya
	Scenario: Un lien dans la libellé de l'article pour afficher les détails de l'article
		Given user opens page  shopping 
		And user clicks on text link of an article
		Then details are displayed
		
