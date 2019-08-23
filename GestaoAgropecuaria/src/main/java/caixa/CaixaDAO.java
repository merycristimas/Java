package caixa;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author cta
 */
public class CaixaDAO {

    /**
     * Salva o objeto caixa no BD
     *
     * @param session
     * @param caixa
     */
    public static void save(Session session, Caixa caixa) {
        session.beginTransaction();
        if (caixa.getId() == null) {
            session.save(caixa);
        } else {
            session.update(caixa);
        }
        session.getTransaction().commit();
    }

    /**
     * Deleta informações do objeto caixa no BD
     *
     * @param session
     * @param caixa
     */
    public static void delete(Session session, Caixa caixa) {
        session.beginTransaction();
        session.delete(caixa);
        session.getTransaction().commit();
    }

    /**
     *
     * @param session
     * @param id
     * @return
     */
    public static Caixa loadById(Session session, Integer id) {
        session.beginTransaction();
        Caixa c = (Caixa) session.createQuery("FROM Caixa WHERE id=" + id).uniqueResult();
        session.getTransaction().commit();
        return c;

    }

    /**
     * lista as informações do objeto caixa no BD
     *
     * @param session
     * @return
     */
    public static List<Caixa> loadList(Session session) {
        List<Caixa> list;
        try {
            session.beginTransaction();
           list = session.createQuery("FROM Caixa").list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            list = new ArrayList<>();
        }
        return list;

    }
}
