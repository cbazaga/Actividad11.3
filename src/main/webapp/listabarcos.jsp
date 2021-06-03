<%-- 
    Document   : listabarcos
    Created on : 2 jun. 2021, 15:32:31
    Author     : ciclost
--%>

<%@page import="barcos.Barco"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listabarcos.jsp</title>
        <style>
            h1{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <% 
            boolean okey = (boolean)request.getAttribute("okey");
            String mensaje = (String)request.getAttribute("mensaje");
            if(okey == false) out.print("<p>Ese barco ya ha sido añadido.</p> <a href=\"index.html\">Volver al menú principal </a>");
            else if(mensaje == "error") out.print("<p>Ha habido un error.</p> <a href=\"index.html\">Volver al menú principal </a>");
        else{
        %>
        <% ArrayList<Barco> barcos = (ArrayList<Barco>)request.getSession().getAttribute("arraybarcos"); %>
        <h1>Lista de barcos!</h1>
        <table>
            <tr>
                <th>Tipo</th> <th>Matricula</th> <th>Eslora</th> <th>Año Fab.</th> <th>Potencia</th> <th>Camarotes</th> <th>Mástiles</th> <th>Opciones</th>
            </tr>
            <tr>
                <% 
                for(int i=0; i<barcos.size();i++){
    out.print(" <td>"+barcos.get(i).getClass().getSimpleName()+"</td> <td>"+barcos.get(i).getMatricula()+"</td> <td>"+barcos.get(i).getEslora()+"</td> <td>"+ barcos.get(i).getAnyoFabricacion()+"</td> <td>"+ barcos.get(i).getPotencia()+" </td> <td> "+barcos.get(i).getNumeroDeCamarotes()+" </td> <td> "+barcos.get(i).getNumeroDeMastiles()+" </td> <td> <a href=\"simulador.jsp?matricula="+barcos.get(i).getMatricula()+"\">Simular alquiler</a></td>");
                }%>
            </tr>
        </table>
        <% 
        } %>
    </body>
</html>
