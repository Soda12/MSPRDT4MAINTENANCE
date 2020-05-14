<%-- 
    Document   : import
    Created on : 4 mai 2020, 13:49:05
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
     <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


     <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    
    
    <body>
         <c:if test="${ !empty fichier }"><p ><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
    <form method="post" action="ImportServlet" enctype="multipart/form-data">
        <div class="form-group">
            <label for="description">Description du fichier : </label>
            <input type="text" class="form-control" name="description" id="description" />
        </div>
         <div class="form-group">
            <label for="fichier">Fichier à envoyer : </label>
            <input type="file"  name="fichier" id="fichier"  />
       
        
        <input type="submit" style="background-color: #8f0404 ; color: white; border-radius: 1em ; border: black; margin-left:28%; width: 200px; height:40px"/>
          </div>
    </form>
    
    </body>
</html>
<style>
    
   form {
  /* Uniquement centrer le formulaire sur la page */
  margin: 0 auto;
  width: 500px;
  /* Encadré pour voir les limites du formulaire */
  padding: 2em;
  border: 1px solid #b0416c;
 border-radius: 1em;
   margin: 200px auto 0px auto; 
}


</style> 