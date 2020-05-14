/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import Beans.Fcsv;
import Beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class Inscription {
    private Connection connexion;
    
   public boolean conex(String email, String password){
        List<User> sac = new ArrayList<User>();
        connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        
        loadDatabase();
        
        try{
            statement = connexion.createStatement();
            
            resultat = statement.executeQuery("SELECT email,password FROM user;");
            
            while(resultat.next()){
           String emailU = resultat.getString("email");
           String passwordU = resultat.getString("password");
            
            User user = new User();
            user.setEmail(emailU);
            user.setPassword(passwordU);
            sac.add(user);
            
            }
        }catch (SQLException e){
        }finally{
            try{
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            }catch (SQLException ignore){
                
            }
        }
        
       for (int i = 0; i < sac.size(); i++) {
             if(sac.get(i).getEmail().equals(email) && sac.get(i).getPassword().equals(password) ){
                 return true;
             }
        }
        return false;
    
   }
    
    
    
    
    
    
    
    
    
    
    
     public void addcsv(Fcsv fcsv){
        loadDatabase();
        try{
             PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO fiche(nom,valeur)"
                + "VALUES (?, ?);");
             preparedStatement.setString(1, fcsv.getNom());
             preparedStatement.setString(2, fcsv.getValeur());
             
             
             preparedStatement.executeUpdate();
             
        }catch(SQLException e){
            e.printStackTrace();
        }
        
       
    }
    
    
    
    
    
    public void addUser(User user){
        loadDatabase();
        try{
             PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO user(nom,prenom,solution,email,password)"
                + "VALUES (?, ?, ?, ?, ?);");
             preparedStatement.setString(1, user.getNom());
             preparedStatement.setString(2, user.getPrenom());
             preparedStatement.setString(3, user.getSolution());
             preparedStatement.setString(4, user.getEmail());
             preparedStatement.setString(5, user.getPassword());
             
             preparedStatement.executeUpdate();
             
        }catch(SQLException e){
            e.printStackTrace();
        }
        
       
    }
    
    
    
    private void loadDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            
        }
        
        try{
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/opendata","root","");
            }catch(SQLException e){
                e.printStackTrace();
            }
    }

    

  
}
