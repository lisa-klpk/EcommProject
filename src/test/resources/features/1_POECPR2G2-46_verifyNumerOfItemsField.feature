@REQ_POECPR2G2-46
Feature: US 8 : Accéder aux détails des articles

	@POECPR2G2-81 @Jaya
	Scenario: Lorsqu'un article est ajouté au panier, un champ est présent pour préciser le nombre d'exemplaires souhaités
		Given i open shop page
		When i select a product
		And i do add to basket
		Then the page contains a field to specify number of items needed
		
