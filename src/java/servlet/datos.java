package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entidades.Pizza;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import jpa.PizzaJpaController;

/**
 *
 * @author Jonathan
 */
public class datos extends HttpServlet {
    @Resource private UserTransaction utx;
    @PersistenceUnit (unitName = "pizzaPU")EntityManagerFactory emf;
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
        try {
            response.setContentType("text/plain");
            processRequest(request, response);
            emf = Persistence.createEntityManagerFactory("pizzaPU");
            
            PizzaJpaController pj=new PizzaJpaController(utx, emf);
            
            String vendedor = request.getParameter("vendedor");
            String tipo = request.getParameter("tipo");
            int precio = Integer.parseInt(request.getParameter("precio"));
            String comprador = request.getParameter("comprador");
            String fecha = request.getParameter("fecha");
            
            Pizza n=new Pizza();
            n.setVendedor(vendedor);
            n.setTipo(tipo);
            n.setValor(precio);
            n.setComprador(comprador);
            n.setFecha(fecha);
            
            pj.create(n);
            
//            Parqueadero p = new Parqueadero();
//            p.setPlaca(placa);
//            p.setTipo(tipo);
//            p.setTiempo(tiempo);
//            
//            pj.create(p);
            
        } catch (Exception e) {
        }
        
        
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
