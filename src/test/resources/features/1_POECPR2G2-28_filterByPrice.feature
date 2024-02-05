@REQ_POECPR2G2-28
Feature: US 7 : Ajouter des articles au panier depuis la page ‘Shop’

	@POECPR2G2-52 @Jaya
	Scenario: Afficher les articles filtrés par prix
		Given I am opening the shop page
		When I choose a value in FILTER BY PRICE
		And I click on the button FILTER
		Then the filtered list appears
		
