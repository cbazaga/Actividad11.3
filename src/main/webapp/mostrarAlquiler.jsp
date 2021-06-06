<%-- 
    Document   : mostrarAlquiler
    Created on : 6 jun. 2021, 11:06:22
    Author     : Carlos
--%>

<%@page import="barcos.Alquiler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if(request.getAttribute("mensaje") == "error") out.print("<p>Ha habido un error.</p> <a href=\"index.html\">Volver al menú principal </a>");
        else{%>
        
        <h1>Resultado de la simulación</h1>
        
        <p><strong>Nombre del cliente: </strong> </p>
        <br>
        <p><strong>DNI del cliente: </strong> </p>
        <br>
        <p><strong>Días de ocupación: </strong></p>
        <br>
        <p><strong>Posición de amarre: </strong></p>
        <br>
        <p><strong>Posición de amarre: </strong></p>
        <br>
        <p><strong>Datos del barco: </strong></p>
        <br>
        Barco: <% Alquiler alquiler = (Alquiler) request.getAttribute("alquiler"); out.print("<p><strong>Datos del barco: </strong>"+alquiler.getBarco().toString()+"</p>"); %>
        <br>
        <% } %>
    </body>
</html>
