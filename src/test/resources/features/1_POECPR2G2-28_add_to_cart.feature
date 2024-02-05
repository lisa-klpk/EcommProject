@REQ_POECPR2G2-28
Feature: US 7 : Ajouter des articles au panier depuis la page ‘Shop’

	@POECPR2G2-34 @Jaya
	Scenario: Ajouter un article au panier
		Given J’ouvre le page ‘Shop’
				When je clique ‘ADD TO BASKET’ de l'article Selenium Ruby
				And Je clique sur l'icône panier
				Then l'article est ajouté au panier
		
