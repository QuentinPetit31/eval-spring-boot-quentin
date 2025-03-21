package com.quentin.evalspring.repository;

import com.quentin.evalspring.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface qui gère les requêtes en bdd pour les Produits
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
