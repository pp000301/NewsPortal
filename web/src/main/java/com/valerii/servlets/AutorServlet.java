package com.valerii.servlets;

import com.valerii.AutorServise;
import com.valerii.entity.Autor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/autors")
public class AutorServlet extends HttpServlet {
    private final AutorServise autorServise=AutorServise.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Autor> allAutors = autorServise.getAllAutors();
        req.setAttribute("autors",allAutors);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/Autors.jsp").forward(req,resp);
    }
}
