<%-- 
    Document   : inscription
    Created on : 3 mai 2020, 22:16:34
    Author     : soda dia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
       
         <form method = "post">
      <div class="form-group">
    <label for="nom"> Nom</label>
    <input type="nom" class="form-control"  name="nom" id="exampleInputNom" placeholder="Entrer votre nom">
  </div>
  <div class="form-group">
    <label for="prenom">Prenom </label>
    <input type="prenom" class="form-control" name="prenom" id="exampleInputPrenom" placeholder="Entrer votre prenom">
  </div>
  <div class="form-group">
    <label for="solInf">Solution Informatique </label>
    <input type="solution" class="form-control" name="solution" id="exampleInputSolInf" placeholder="Entrer le nom de votre solution">
  </div>
  <div class="form-group">
    <label for="email"> Email</label>
    <input type="email" class="form-control" name="email" id="exampleInputEmail1" placeholder="Entrer votre email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password </label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Entrer votre mot de passe">
  </div>
  <div class="inputSubmit">
   <input type="submit" value="s'inscrire"  style=" background-color: #8f0404 ; color: white; border-radius: 1em ; border: black; margin-left:28%; width: 200px; height:40px" />
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
   margin: 150px auto 0px auto; 
}


</style>  
