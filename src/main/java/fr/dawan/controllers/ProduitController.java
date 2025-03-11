package fr.dawan.controllers;

import fr.dawan.entities.Produit;
import fr.dawan.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    ProduitService service;

    //GET: List<Produit> - /produits   OK
    //GET: Produit - /produits/{id}   OK

    //Post: Produit - /produits - fournit dans le body de la requête
    //PUT: /produits -- fournit dans le body de la requête
    //DELETE /produits/{id}


    // Pour récupérer le body d'un requete, le faire avec @RequestBody
    // public ResponseEntity<Produit> updateProduit(@RequestBody Produit p){}


    @GetMapping(value = "/produits")
    public List<Produit> getAll() {return service.getAll();}

    @GetMapping(value ="/"+"{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        Produit produit = service.getById((long) id);
        if(produit == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit avec id " + id + " introuvable");
        }
        return ResponseEntity.ok(produit);
//        return ResponseEntity.status(HttpStatus.OK).body(produit);
    }
}
