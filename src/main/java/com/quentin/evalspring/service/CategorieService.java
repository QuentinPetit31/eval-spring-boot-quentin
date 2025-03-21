package com.quentin.evalspring.service;

import com.quentin.evalspring.exception.CategorieNotFoundException;
import com.quentin.evalspring.model.Categorie;
import com.quentin.evalspring.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    // Ajouter une catégorie
    public Categorie ajouterCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // Récupérer toutes les catégories
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    // Récupérer une catégorie par ID
    public Categorie getCategorieById(Integer id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieNotFoundException(id));
    }
}
