package nedra_test.dao;

import nedra_test.entity.Click;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;


@Repository
public class ClickDAOImpl implements ClickDAO {

    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Click.class).buildSessionFactory();
    private Click click;

    @Override
    public Click getClick() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        click = session.get(Click.class, 0);
        session.getTransaction().commit();

        return click;
    }

    @Override
    public Click getClickPlusOne() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        click = session.get(Click.class, 0);
        click.setSum_of_clicks(click.getSum_of_clicks() + 1);
        session.getTransaction().commit();

        return click;
    }
}
