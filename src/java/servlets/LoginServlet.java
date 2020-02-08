/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

import utility.AccountServices;

/**
 *
 * @author Phillip Obiora
 */
public class LoginServlet extends HttpServlet {
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
        String logout = request.getParameter("logout");
        // get session
        HttpSession session = request.getSession();
        String isLoggedIn = (String) session.getAttribute("username");
        
        if(logout != null){
            session.invalidate();
            
            request.setAttribute("message", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
        else if(isLoggedIn != null){
            // On get redirect to home page
            response.sendRedirect("/MyLogin/home");
        }
        else{
            // On get redirect to login in page
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        }
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        
        if(username == null || username.equals("") || password == null ||
                password.equals("")){
            request.setAttribute("message", "Invalid Login");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);        
        }
        else{
            AccountServices as = new AccountServices();
            User user  = as.login(username, password);
            
            if(user != null){
                session.setAttribute("username", user.getUsername());
                response.sendRedirect("/MyLogin/home");
            }
            else{
                request.setAttribute("message", "Invalid Login");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);   
            }
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
