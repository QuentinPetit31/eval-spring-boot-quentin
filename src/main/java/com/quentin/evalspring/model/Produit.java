package com.quentin.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Produit {

    /*---------------------------------------
                  Attributs
    ---------------------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nom non vide et taille supérieure à 2
    @NotBlank(message = "Le nom du produit ne peut pas être vide et doit contenir au moins 2 caractères.")
    private String nom;

    // Prix non vide et montant positif (supérieur à zéro)
    @NotNull(message = "Le prix ne peut pas être nul.")
    @Min(value = 1, message = "Le prix doit être supérieur à zéro.")
    private Double prix;

    @ManyToOne
    // Clé étrangère relie -> un produit à une catégorie
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    /*---------------------------------------
                  Constructeurs
    ---------------------------------------*/
    public Produit() {
    }

    public Produit(String nom, Double prix, Categorie categorie) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
