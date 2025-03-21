package com.quentin.evalspring.controller;

import com.quentin.evalspring.model.Categorie;
import com.quentin.evalspring.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur REST pour gérer les catégories
@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    // Ajouter une catégorie (JSON en entrée)
    @PostMapping
    public ResponseEntity<Categorie> ajouterCategorie(@RequestBody Categorie categorie) {
        Categorie nouvelle = categorieService.ajouterCategorie(categorie);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelle); // 201 Created
    }

    // Récupérer toutes les catégories
    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategories() {
        return ResponseEntity.ok(categorieService.getAllCategories()); // 200 OK
    }

    // Récupérer une catégorie par ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Integer id) {
        Categorie cat = categorieService.getCategorieById(id);
        return ResponseEntity.ok(cat); // 200 OK
    }
}
