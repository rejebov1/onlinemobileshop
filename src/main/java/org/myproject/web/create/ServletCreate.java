package org.myproject.web.create;

import org.myproject.service.ProductService;
import org.myproject.service.dto.BrandDto;
import org.myproject.service.dto.ProductDto;
import org.myproject.service.validator.ProductValidate;
import org.myproject.web.JspCollector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/request-create")
public class ServletCreate extends HttpServlet {
    private ProductValidate productValidate = new ProductValidate();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspCollector.getPath("request-create"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDto productDto = ProductDto.builder()
                .phoneModel(req.getParameter("phoneModel"))
                .dateOfIssue(LocalDate.parse(req.getParameter("dateOfIssue")))
                .productCharacteristic(req.getParameter("productCharacteristic"))
                .price(Double.valueOf(req.getParameter("price")))
                .brandDto(
                        BrandDto.builder()
                                .name(req.getParameter("name"))
                                .country(req.getParameter("country"))
                                .build())
                .build();
        if (productValidate.isValid(productDto)) {
            ProductService.getInstance().add(productDto);
            resp.sendRedirect("/request-success");
        } else {
            resp.sendRedirect("/request-create");
        }
    }
}
