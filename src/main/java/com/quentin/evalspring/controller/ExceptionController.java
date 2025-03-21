package com.quentin.evalspring.controller;

import com.quentin.evalspring.exception.CategorieNotFoundException;
import com.quentin.evalspring.exception.ProduitNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Contrôleur pour gérer les erreurs
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ProduitNotFoundException.class)
    public ResponseEntity<String> handleProduitNotFound(ProduitNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
    }

    @ExceptionHandler(CategorieNotFoundException.class)
    public ResponseEntity<String> handleCategorieNotFound(CategorieNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Erreur interne du serveur : " + e.getMessage() + "\"}");
    }
}
