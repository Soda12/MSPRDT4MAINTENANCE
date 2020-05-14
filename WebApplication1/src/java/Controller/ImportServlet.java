/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

        
        
        
import Beans.Fcsv;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.annotation.WebServlet;


        
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bdd.Inscription;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ImportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "C:\\test\\"; // A changer
    private final static char SEPARATOR = ';';
  
    
        
    public ImportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/import.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
         // On récupère le champ description comme d'habitude
        String description = request.getParameter("description");
        request.setAttribute("description", description );
        
         // On récupère le champ du fichier
        Part part = request.getPart("fichier");
        
         // On vérifie qu'on a bien reçu un fichier
        String nomFichier = getNomFichier(part);
        
        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty()) {
            String nomChamp = part.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                    .substring(nomFichier.lastIndexOf('\\') + 1);

            try {
                // On écrit définitivement le fichier sur le disque
                ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
                
            } catch (CsvValidationException ex) {
                Logger.getLogger(ImportServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute(nomChamp, nomFichier);
            
            try {
                lire(nomFichier);
            } catch (CsvValidationException ex) {
                Logger.getLogger(ImportServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        processRequest(request, response);
    }
        
    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException, CsvValidationException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
            
            
            
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                
                sortie.close();
              
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
   /////////////////////////////////////////////////////////recuperer donnees fichier
   
    
    //File file = new File();
   // File file = new File(chemin + nomFichier);
   // FileReader fr = new FileReader(file);
    //System.out.print(chemin+nomFichier);
    
    
    
    
    }
  
    
    
    protected void lire(String nomFichier) throws FileNotFoundException, IOException, CsvValidationException{
          File file = new File("C:\\test\\" + nomFichier);
          FileReader fr = new FileReader(file);
          CSVReader csvReader;
        csvReader = new CSVReader(fr);
    
    
    List<String[] > data = new ArrayList<String[] >();
    String[] nextLine = null;
   while ((nextLine = csvReader.readNext()) != null) {
    int size = nextLine.length;

    // ligne vide
    if (size == 0) {
        continue;
    }
    String debut = nextLine[0].trim();
    if (debut.length() == 0 && size == 1) {
        continue;
    }

    // ligne de commentaire
    if (debut.startsWith("#")) {
        continue;
    }
    data.add(nextLine);
    String nom = nextLine[0];
            String valeur = nextLine[1];

                Fcsv fi = new Fcsv();
                fi.setNom(nom);
                fi.setValeur(valeur);
                Inscription tablecsv = new Inscription();
                tablecsv.addcsv(fi);
}
    //for (String[] oneData : data) {
            
//}
  
    }
    
     private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }   
        
        
     //   processRequest(request, response);
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
