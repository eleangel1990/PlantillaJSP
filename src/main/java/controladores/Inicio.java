/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Conexion;
import modelos.Obtener_Datos;

/**
 *
 * @author rivas
 */
public class Inicio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuario", "Ele Angel");
        
        
        try {
            Obtener_Datos datos = new Obtener_Datos();
            ResultSet resultSet = datos.obtener_empleados();
            while(resultSet.next()){
                System.out.println("Nombre: "+resultSet.getString("first_name"));
            }
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //resp.sendRedirect("index.jsp");
        
    }
    
    
    
}
