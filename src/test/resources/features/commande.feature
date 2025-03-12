Feature: Gestion des commandes
  Scenario: Un produit en rupture totale est supprimé des commandes en cours
    Given un client a une commande en cours contenant un produit
    And un produit n'est plus en stock
    When un autre client passe une commande et achète la dernière unité disponible
    Then le produit est supprimé de toutes les commandes 'en_cours'
    And une alerte est envoyée à l’utilisateur : "le produit de votre commande n’est plus en stock"
