package fr.dawan.controllers;

import fr.dawan.entities.Produit;
import fr.dawan.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // update

    // Pour récupérer le body d'un requete, le faire avec @RequestBody
    // public ResponseEntity<Produit> updateProduit(@RequestBody Produit p){}


    @GetMapping(value = "")
    public List<Produit> getAll() {return service.getAll();}

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        Produit produit = service.getById((long) id);
        if(produit == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit avec id " + id + " introuvable");
        }
        return ResponseEntity.ok(produit);
//        return ResponseEntity.status(HttpStatus.OK).body(produit);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Produit p){
        Produit prod = service.insert(p);
        return ResponseEntity.ok(p);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Produit p){
        Produit prod = service.update(p);
        if(prod == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit introuvable");
        }
        return ResponseEntity.ok(p);
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("suppression OK");
    }

}
