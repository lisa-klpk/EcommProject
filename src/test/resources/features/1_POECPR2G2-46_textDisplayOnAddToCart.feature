@REQ_POECPR2G2-46
Feature: US 8 : Accéder aux détails des articles

	@POECPR2G2-91 @Jaya
	Scenario: A chaque ajout, un message “'libellé' has been added to your basket." apparaissent au-dessus l'article
		Given I open application shop page
		When I select an item
		And i add the item to basket
		Then a text display appears indicating addition to the cart
		
