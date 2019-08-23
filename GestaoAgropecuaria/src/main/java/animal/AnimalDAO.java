package animal;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author cta
 */
public class AnimalDAO {

    public static void save(Session session, Animal animal) {
        session.save(animal);
    }

    public static void delete(Session session, Animal animal) {
        session.delete(animal);
    }

    public static Animal loadById(Session session, Integer id) {
        return (Animal) session.createQuery("FROM Animal WHERE id=" + id).uniqueResult();

    }

    public static Animal loadByIdentificacao(Session session, String identificacao) {
        return (Animal) session.createQuery("FROM Animal WHERE identificacao='" + identificacao + "'").uniqueResult();

    }

    public static List<Animal> loadList(Session session) {
        List<Animal> list = session.createQuery("FROM Animal").list();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

    public static List<String> loadIdentificacaoList(Session session) {
        List<String> list = session.createQuery("SELECT identificacao FROM Animal").list();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

}
