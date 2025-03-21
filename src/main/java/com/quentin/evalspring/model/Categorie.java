package com.quentin.evalspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

// Déclaration de l'entité Categorie qui sera liée à Produit
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Libellé obligatoire avec minimum 2 caractères
    @NotBlank(message = "Le libellé est obligatoire.")
    @Size(min = 2, message = "Le libellé doit contenir au moins 2 caractères.")
    private String libele;

    // Relation OneToMany : Une catégorie peut avoir plusieurs produits
    @OneToMany(mappedBy = "categorie")
    @JsonIgnore // <-- Ignore la liste des produits pour éviter la boucle

    private List<Produit> produits;

    /*---------------------------------------
                  Constructeurs
    ---------------------------------------*/
    public Categorie() {
    }

    public Categorie(String libele) {
        this.libele = libele;
    }

    /*---------------------------------------
                 Getters et Setters
    ---------------------------------------*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}