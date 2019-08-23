package area;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class AreaDAO {

    public static void save(Session session, Area area) {
        session.save(area);
    }

    public static void delete(Session session, Area area) {
        session.delete(area);
    }

    public static Area loadById(Session session, Integer id) {
        return (Area) session.createQuery("FROM Area WHERE id=" + id).uniqueResult();
    }

    public static Area loadByNome(Session session, String nome) {
        return (Area) session.createQuery("FROM Area WHERE nome='" + nome + "'").uniqueResult();
    }

    public static List<Area> loadList(Session session) {
        List<Area> list = session.createQuery("FROM Area").list();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

    public static List<String> loadNomeList(Session session) {
        List<String> list = session.createQuery("SELECT nome FROM Area ORDER By nome").list();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

}
