@REQ_POECPR2G2-28
Feature: US 7 : Ajouter des articles au panier depuis la page ‘Shop’

	@POECPR2G2-90 @Jaya
	Scenario: La page "Shop" contient les article
		Given I open the shop page
		Then page display contains articles
		
