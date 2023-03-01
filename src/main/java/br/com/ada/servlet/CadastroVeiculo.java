package br.com.ada.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastroVeiculo")
public class CadastroVeiculo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String plate = req.getParameter("plate");

        if (brand.equals("") || model.equals("") || plate.equals("")) {
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>Dados obrigatórios não preenchidos</h3>");
        } else {
        req.setAttribute("brand", brand);
        req.setAttribute("model", model);
        req.setAttribute("plate", plate);

        RequestDispatcher rd = req.getRequestDispatcher("data.jsp");

        rd.forward(req, resp);
        }

    }
}
