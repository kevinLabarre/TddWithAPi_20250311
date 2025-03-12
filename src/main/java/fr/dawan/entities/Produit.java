package fr.dawan.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Produit extends BaseEntity{
    private String nom;
    private Double prix;

    // Constructors

    public Produit(Long id, Integer version, String nom, Double prix) {
        super(id, version);
        this.nom = nom;
        this.prix = prix;
    }

    public Produit(Long id, String nom, Double prix) {
        super(id);
        this.nom = nom;
        this.prix = prix;
    }

    public Produit() {
    }

    public Produit(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }


    // Getters and setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Objects.equals(getId(), produit.getId()) && Objects.equals(nom, produit.nom) && Objects.equals(prix, produit.prix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), nom, prix);
    }
}
