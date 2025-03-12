package fr.dawan.cucumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.dawan.entities.Commande;
import fr.dawan.entities.Produit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CommandesSteps {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate(); // Utilisation de RestTemplate pour effectuer les requêtes HTTP

    private ResponseEntity<Object> response;
    private String produitId;
    private String commandeId;
    private String alertMessage;


    @Given("un client a une commande en cours contenant un produit")
    public void un_client_a_une_commande_en_cours_contenant_un_produit() throws JsonProcessingException {
        String url = "http://localhost:8080/api/commandes/create";
        Produit produit = new Produit(1L, "test cucumber", 12.0);
        Commande commande = new Commande(null, 1, List.of(produit));

        // Conversion JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCommande = objectMapper.writeValueAsString(commande);

        // requête POST
        response = restTemplate.postForEntity(url, jsonCommande, Object.class);

        // vérif si requete OK
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            commandeId = (String) response.getBody();  // Récupérer l'ID de la commande
        } else {
            throw new RuntimeException("Erreur lors de la création de la commande");
        }
    }

    @Given("un produit n'est plus en stock")
    public void un_produit_n_est_plus_en_stock() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("un autre client passe une commande et achète la dernière unité disponible")
    public void un_autre_client_passe_une_commande_et_achète_la_dernière_unité_disponible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("le produit est supprimé de toutes les commandes {string}")
    public void le_produit_est_supprimé_de_toutes_les_commandes(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("une alerte est envoyée à l’utilisateur : {string}")
    public void une_alerte_est_envoyée_à_l_utilisateur(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
    }

}
