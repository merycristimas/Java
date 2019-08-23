package maquina;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author cta
 */
public class MaquinaDAO {

    public static void save(Session session, Maquina maquina) {
        session.save(maquina);
    }

    public static void delete(Session session, Maquina maquina) {
        session.delete(maquina);
    }

    public static Maquina loadById(Session session, Integer id) {
        return (Maquina) session.createQuery("FROM Maquina WHERE id=" + id).uniqueResult();
    }

    public static Maquina loadByMaquina(Session session, String maquina) {
        return (Maquina) session.createQuery("FROM Maquina WHERE maquina='" + maquina + "'").uniqueResult();
    }

    public static List<Maquina> loadList(Session session) {
        List<Maquina> list = session.createQuery("FROM Maquina").list();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

    public static List<String> loadMaquinaList(Session session) {
        List<String> list = session.createQuery("Select maquina FROM Maquina ORDER By maquina").list();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

}
