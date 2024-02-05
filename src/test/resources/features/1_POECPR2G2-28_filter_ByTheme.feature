@REQ_POECPR2G2-28
Feature: US 7 : Ajouter des articles au panier depuis la page ‘Shop’

	@POECPR2G2-54 @Jaya
	Scenario: Afficher les articles filtrés par thème
		Given user opens SHOP page
		When user chooses a PRODUCTS CATEGORIE
		Then Filtered list of articles appears
		
