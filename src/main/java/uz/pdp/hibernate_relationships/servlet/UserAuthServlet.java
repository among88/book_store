package uz.pdp.hibernate_relationships.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.hibernate_relationships.entity.User;
import uz.pdp.hibernate_relationships.entity.UserAuth;

import java.io.IOException;

@WebServlet(name = "UserAuthServlet", value = "/user/auth")
public class UserAuthServlet extends HttpServlet {

        private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-orm");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            final UserAuth userAuth = UserAuth.builder()
                    .email("example@gmail.com")
                    .Username("eeslambec")
                    .password("1427")
                    .build();
            final User user = User.builder()
                    .userAuth(userAuth)
                    .first_name("qodirali")
                    .last_name("mahmudv")
                    .imgLink("www.img.com").build();

            userAuth.setUser(user);

            //.persist(userAuth);

            entityManager.persist(user);
            entityManager.getTransaction().commit();

            resp.setContentType("application/json");
            resp.getWriter().write("{" + user.toString() + "}");
        }
    }
}
