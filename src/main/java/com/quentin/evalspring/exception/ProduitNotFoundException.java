package com.quentin.evalspring.exception;

// Exception qui gére le cas où un produit n'existe pas avec l'id donné
public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException(Integer id) {
        super("Le produit avec l'ID " + id + " n'existe pas.");
    }
}
