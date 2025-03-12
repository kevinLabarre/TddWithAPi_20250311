package fr.dawan.controllers;

import fr.dawan.entities.Commande;
import fr.dawan.entities.Produit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @PostMapping("/create")
    public ResponseEntity<Commande> createCommande() {
        Produit p = new Produit(1L, "test concumber", 12.0);
        ArrayList<Produit> produits = new ArrayList<Produit>();
        produits.add(p);

        Commande c = new Commande(1L, 1, produits);

        return ResponseEntity.ok(c);
    }

}
