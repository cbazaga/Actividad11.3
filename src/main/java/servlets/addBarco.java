/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import barcos.Barco;
import barcos.Velero;
import barcos.Yate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author ciclost
 */
public class addBarco extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("utf-8");
            HttpSession miSesion = request.getSession();
            if(miSesion.isNew()){
                ArrayList<Barco> barcos = new ArrayList();
            }
            int potencia =0;
            int mastil=0;
            int camarotes=0;
            int matricula = Integer.parseInt(request.getParameter("matricula"));
            double eslora = Double.parseDouble(request.getParameter("eslora"));
            int anyofabricacion = Integer.parseInt(request.getParameter("anyoFabricacion"));
            String tipo = request.getParameter("tipo");
            try{
                if(matricula<10000 || matricula>99999 || eslora<=0 || eslora >1000 || anyofabricacion<=0 || anyofabricacion>2021) throw new Exception();
                Barco barco;
                
                switch(tipo) {
                    case "velero":
                        
                        mastil = Integer.parseInt(request.getParameter("mastiles"));
                        if(mastil<=0 || mastil>50) throw new Exception();
                        
                        barco = new Velero(mastil, matricula, eslora, anyofabricacion);
                        break;
                    
                    case "yate":
                        potencia = Integer.parseInt(request.getParameter("potencia"));
                        camarotes = Integer.parseInt("camarotes");
                        if(potencia<=0) throw new Exception();
                        barco = new Yate(potencia, camarotes, matricula, eslora, anyofabricacion);
                        break;
                        
                    case "deportiva":
                        potencia = Integer.parseInt(request.getParameter("potencia"));
                        out.println(potencia);
                        
                       
                    default:out.println("Error de switch");
                }
            }
            catch(Exception e){
                out.println("<p>Error de validación de datos</p>");
                out.println("<a href=\"index.html\">Volver al menú principal</a>");
            }
            out.println("Llega al final");
            
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
