package fr.dawan.services;

import fr.dawan.entities.Produit;
import fr.dawan.repositories.IProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    IProduitRepository repository;

    // Pour les tests unitaires
//    public ProduitService(IProduitRepository repository) {
//        this.repository = repository;
//    }

    public List<Produit> getAll() {
        return repository.findAll();
    }

    public Produit getById(Long id) {
        Optional<Produit> produit = repository.findById(id);

        return produit.orElse(null);
    }

    public Produit insert(Produit p){
        return repository.save(p);
    }

    public void delete(Long id) {repository.deleteById(id);}

    private Produit update(Produit p) {return repository.save(p);}
}
