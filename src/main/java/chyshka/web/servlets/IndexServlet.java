package chyshka.web.servlets;

import chyshka.service.ProductService;
import chyshka.service.ProductServiceImpl;
import chyshka.util.HtmlReader;
import chyshka.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private static final String INDEX_VIEW_FILE_PATH = "/home/luoni/IdeaProjects/chyshki/src/main/resources/views/index.html";

    private final ProductService productService;
    private final HtmlReader htmlReader;

    @Inject
    public IndexServlet(ProductService productService,HtmlReader htmlReader) {
        this.productService =productService;
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlFileContent = this.htmlReader.readHtmlFile(INDEX_VIEW_FILE_PATH);

        resp.getWriter().println(htmlFileContent);
    }
}
