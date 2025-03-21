package com.quentin.evalspring.exception;

// Exception qui gére le cas où catégorie non trouvée avec l'id donné
public class CategorieNotFoundException extends RuntimeException {
    public CategorieNotFoundException(Integer id) {
        super("La catégorie avec l'ID " + id + " n'existe pas.");
    }
}
