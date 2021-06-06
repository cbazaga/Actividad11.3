/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import barcos.Alquiler;
import barcos.Barco;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ciclost
 */
public class calcularAlquiler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion2 = request.getSession();
            int matricula = Integer.parseInt(request.getParameter("matricula")); //bien
            ArrayList<Barco> lista = (ArrayList<Barco>) sesion2.getAttribute("arraybarcos");
            String nombre=null;
            String dni=null;
            int diasocupacion=0;
            int posicionamarre=0;
            try{
            if(lista == null || Barco.buscar(lista, matricula)!=null) {
                throw new Exception();
            }
            nombre = String.valueOf(request.getParameter("nombre"));//bien
            dni = String.valueOf(request.getParameter("dni"));//bien
            diasocupacion = Integer.parseInt(request.getParameter("diasOcupacion"));//bien
            posicionamarre = Integer.parseInt(request.getParameter("posicion"));//bien  
            }
            catch(Exception e){
                request.setAttribute("mensaje", "error");
                request.getRequestDispatcher("mostrarAlquiler.jsp").forward(request, response);
            }
            request.setAttribute("alquiler", new Alquiler(nombre, dni, diasocupacion, posicionamarre, Barco.buscar(lista, matricula)));
            request.setAttribute("mensaje", "Simulacion completada");
            request.getRequestDispatcher("mostrarAlquiler.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
