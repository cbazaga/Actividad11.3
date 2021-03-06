/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import barcos.Barco;
import barcos.EmbarcacionDeportiva;
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
            ArrayList<Barco> barcos= new ArrayList<>();
            Barco barco=null;
            if(miSesion.isNew()) miSesion.setAttribute("arraybarcos", barcos);
            else barcos=(ArrayList<Barco>) miSesion.getAttribute("arraybarcos");
            int potencia =0;
            int mastil=0;
            int camarotes=0;
            int matricula = Integer.parseInt(request.getParameter("matricula"));
            double eslora = Double.parseDouble(request.getParameter("eslora"));
            int anyofabricacion = Integer.parseInt(request.getParameter("anyoFabricacion"));
            boolean okey=true;
            String stringTipo = null;
            String tipo = request.getParameter("tipo");
            try{
                if(matricula<10000 || matricula>99999 || eslora<=0 || eslora >1000 || anyofabricacion<=0 || anyofabricacion>2021) throw new Exception();
                
                switch(tipo) {
                    case "velero":
                        
                        mastil = Integer.parseInt(request.getParameter("mastiles"));
                        if(mastil<=0 || mastil>50) throw new Exception();
                        
                        barco = new Velero(mastil, matricula, eslora, anyofabricacion);
                        request.setAttribute("tipobarco", "velero");
                        break;
                    
                    case "yate":
                        potencia = Integer.parseInt(request.getParameter("potencia"));
                        camarotes = Integer.parseInt("camarotes");
                        if(potencia<=0 || camarotes<0) throw new Exception();
                        barco = new Yate(potencia, camarotes, matricula, eslora, anyofabricacion);
                        request.setAttribute("tipobarco", "yate");
                        break;
                        
                    case "deportiva":
                        potencia = Integer.parseInt(request.getParameter("potencia"));
                        if(potencia<=0) throw new Exception();
                        barco = new EmbarcacionDeportiva(potencia, matricula, eslora, anyofabricacion);
                        request.setAttribute("tipobarco", "deportiva");
                        break;
                        
                    default: throw new Exception();
                }
                if(barco==null) throw new Exception(); //caso en el cual no se habr??a instanciado el barco.
            }
            catch(Exception e){
                out.println("<p>Error de validaci??n de datos</p>");
                out.println("<a href=\"index.html\">Volver al men?? principal</a>");
            }
            
                if (Barco.buscar(barcos, matricula)!=null)  okey=false; //comprobar si el barco ha sido insertado en el arraylist.
                else{
                    barcos.add(barco);
                }
                request.setAttribute("okey", okey);
                request.getRequestDispatcher("listabarcos.jsp").forward(request, response);
            
            
            
            
            
            
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
