@REQ_POECPR2G2-28
Feature: US 7 : Ajouter des articles au panier depuis la page ‘Shop’

	@POECPR2G2-47 @Jaya
	Scenario: Lorsqu'un article est ajouté au panier, vérifiez le lien "VIEW BASKET "  apparaît au-dessous l'article
		Given I open shop page
		When I click ADD To BASKET button below an article
		Then VIEW BASKET link appears below the article
		
