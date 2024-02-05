@REQ_POECPR2G2-28
Feature: US 7 : Ajouter des articles au panier depuis la page ‘Shop’

	@POECPR2G2-77 @Jaya
	Scenario: Un lien dans la prix de l'article pour afficher les détails de l'article
		Given user open shop page
		And user clicks on price of an article
		Then details of the article is displayed
		
