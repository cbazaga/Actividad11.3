<%-- 
    Document   : simulador
    Created on : 3 jun. 2021, 18:55:13
    Author     : ciclost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simulador de alquiler</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <style>
            input,select{
                margin-bottom: 1em;
            }
        </style>        
    </head>
    <body>
        <nav class="navbar navbar-light bg-light justify-content-end">
            <ul class="nav justify-content-end ">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="index.html">Alta de barcos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listaBarcos.jsp">Lista de barcos</a>
                </li>
            </ul>
        </nav>
        <h1 class="text-center">Simulación de alquiler del barco 12345 </h1>
        <form style="width:50%; min-width: 450px; margin: 0 auto;" method="post" action="calcularAlquiler">
            <label for="nombre" class="form-label">Nombre </label>
            <input class="form-control" type="text" name="nombre" id="nombre" required="required" placeholder="Lozenzo Cuevas"/>
            <label for="dni" class="form-label">DNI: </label>
            <input class="form-control" type="text" name="dni" id="dni" required="required" pattern="[0-9]{8}[a-zA-Z]" placeholder="78954224X"/>
            <label for="diasOcupacion" class="form-label">Dias de ocupación: </label>
            <input class="form-control" type="text" name="diasOcupacion" id="diasOcupacion" required="required" pattern="[0-9]{1,3}" placeholder="15"/>
            <label for="posicion" class="form-label">Posición amarre: </label>
            <input class="form-control" type="text" name="posicion" id="posicion" required="required" pattern="[0-9]{1,3}" placeholder="4"/>
            <input type="hidden" name="matricula" id="matricula" value="12345" />

            <input class="btn btn-primary" type="submit" value="Simular" />

        </form>
    </body>
</html>
