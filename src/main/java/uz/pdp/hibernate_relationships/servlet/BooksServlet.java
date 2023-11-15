package uz.pdp.hibernate_relationships.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.hibernate_relationships.entity.Author;
import uz.pdp.hibernate_relationships.entity.Book;

import java.io.IOException;
@WebServlet(name = "BooksServlet", value = "/books")
public class BooksServlet extends HttpServlet {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-orm");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            final Author author = Author.builder()
                    .fullName("qodirali")
                    .build();
            final Book book = Book.builder()
                    .author(author)
                    .title("gish va tosh")
                    .summary("bomagur kitob")
                    .linkImg("https://qalesanqodirali.uz")
                    .isAvailable(true)
                    .build();
            entityManager.persist(book);
            entityManager.getTransaction().commit();

            resp.setContentType("application/json");
            resp.getWriter().write("{" + book.toString() + "}");
        }
    }
}
