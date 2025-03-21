package com.quentin.evalspring.controller;

import com.quentin.evalspring.model.Produit;
import com.quentin.evalspring.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur REST -> gère les produits
@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Récupérer un produit par ID + sa catégorie
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Integer id) {
        Produit produit = produitService.getProduitById(id);
        return ResponseEntity.ok(produit); // 200 (c'est le code qui confirme que la requête est bien passée)
    }

    // Récupérer tous les produits + leurs catégories
    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        return ResponseEntity.ok(produitService.getAllProduits()); // 200
    }

    // Ajouter un produit avec JSON en entrée
    @PostMapping
    public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit produit) {
        Produit nouveau = produitService.ajouterProduit(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveau); // 201 Created (ce code confirme la creation du pdt)
    }
}
