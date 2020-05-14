/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author hp
 */
public class User {
//    private int id;
    private String nom;
    private String prenom;
    private String solution;
    private String email;
    private String password;
/*
    public User(String nom, String prenom, String solution, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.solution = solution;
        this.email = email;
        this.password = password;
    }
*/
    public User() {
         }

    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSolution() {
        return solution;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
