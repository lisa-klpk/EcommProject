@REQ_POECPR2G2-28
Feature: US 7 : Ajouter des articles au panier depuis la page ‘Shop’

	@POECPR2G2-57 @Jaya
	Scenario: Un lien dans la photo de l'article pour afficher les détails de l'article
		Given user opens shopping page
		And user clicks on the image of the article
		Then article details displayed
		
