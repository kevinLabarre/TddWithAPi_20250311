package fr.dawan.repositories;

import fr.dawan.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduitRepository extends JpaRepository<Produit, Long> {
}
