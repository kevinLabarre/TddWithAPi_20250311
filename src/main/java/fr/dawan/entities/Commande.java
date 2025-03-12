package fr.dawan.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Commande extends BaseEntity {
    @OneToMany
    private List<Produit> produits;

    // Getters and setters
    public List<Produit> getProduits() {
        return produits;
    }
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    // Constructeurs


    public Commande(Long id, Integer version, List<Produit> produits) {
        super(id, version);
        this.produits = produits;
    }

    public Commande(Long id, List<Produit> produits) {
        super(id);
        this.produits = produits;
    }

    public Commande() {
    }

}
