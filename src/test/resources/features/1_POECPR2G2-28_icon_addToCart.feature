@REQ_POECPR2G2-28
Feature: US 7 : Ajouter des articles au panier depuis la page ‘Shop’

	@POECPR2G2-51 @Jaya
	Scenario: Consultez le panier à l'aide de l'icône en en-tête
		Given I open the shopping page
		When I click on cart icon
		Then cart page opens
		
