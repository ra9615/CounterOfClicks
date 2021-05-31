package nedra_test.controller;

import nedra_test.entity.Click;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {


    @RequestMapping("/")
    public String showFirstPage(Model model) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Click.class).buildSessionFactory();
        try {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Click click = session.get(Click.class, 0);
            session.getTransaction().commit();
            model.addAttribute("click", click);
        } finally {
            sessionFactory.close();
        }
        return "sum_of_clicks";
    }

    @RequestMapping("/count")
    public String showSumOfClicks(Model model) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Click.class).buildSessionFactory();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Click click = session.get(Click.class, 0);
            click.setSum_of_clicks(click.getSum_of_clicks() + 1);
            model.addAttribute("click", click);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
        return "sum_of_clicks";
    }
}
