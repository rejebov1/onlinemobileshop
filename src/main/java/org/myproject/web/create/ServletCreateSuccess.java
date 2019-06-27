package org.myproject.web.create;

import org.myproject.web.JspCollector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request-success")
public class ServletCreateSuccess extends HttpServlet {


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            getServletContext()
                    .getRequestDispatcher(JspCollector.getPath("request-success"))
                    .forward(req, resp);
        }
}
