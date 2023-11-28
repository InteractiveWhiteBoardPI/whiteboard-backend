package com.example.whiteboardbackend.exception;

public class UtilisateurNotFoundException extends RuntimeException {
    
        public UtilisateurNotFoundException(Long id) {
            super("The user id '" + id + "' does not exist in our records");
        }
        

        public UtilisateurNotFoundException(String username) {
            super("The username '" + username + "' does not exist in our records");
        }
    
}
