package com.p1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.System.out;

/**
 * Created by mallickp on 7/24/2017.
 */
@WebServlet(name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text,html");
        PrintWriter pw=response.getWriter();

        String uname=request.getParameter("uname");
        String pas=request.getParameter("pass");
       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","CDKcdk11");
           PreparedStatement p=conn.prepareStatement("select * from admin WHERE aname=? AND apas=?;");
           p.setString(1,uname);
           p.setString(2,pas);
           ResultSet rs=p.executeQuery();
           if(rs.next()){
               RequestDispatcher r=request.getRequestDispatcher("http://localhost:8080/AdminWelcome.java ");
               r.forward(request,response);
           }
           else
           { pw.println("You are not authorised");
               RequestDispatcher r=request.getRequestDispatcher("adminpage.html");
               r.include(request,response);
           }


       }
       catch (Exception e) {
           e.printStackTrace();
       }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
