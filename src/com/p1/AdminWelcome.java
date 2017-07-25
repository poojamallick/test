package com.p1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mallickp on 7/24/2017.
 */
@WebServlet(name = "AdminWelcome")
public class AdminWelcome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        String n=request.getParameter("uname");
        pw.println("<h1>Welcome "+n+"</h1>");
        pw.println("<a href='AddOperator'><input type='button' value='add operator'></a>"+
                "<a href='DelOperator'><input type='button' value='delete operator'></a> "+
                "<a href='AddSpareparts'><input type='button' value='add spareparts'></a>"+
                "<a href='DeleteSpareparts'><input type='button' value='remove spareparts'></a>"
                );


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
