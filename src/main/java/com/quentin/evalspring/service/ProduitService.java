package com.quentin.evalspring.service;

import com.quentin.evalspring.exception.ProduitNotFoundException;
import com.quentin.evalspring.model.Produit;
import com.quentin.evalspring.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service qui gère la logique métier des produits
@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    // Ajouter un produit
    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    // Récupérer tous les produits
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    // Récupérer un produit par ID avec gestion d'erreur si non trouvé
    public Produit getProduitById(Integer id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException(id));
    }
}
