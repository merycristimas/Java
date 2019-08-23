package cliente;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author cta
 */
public class ClienteDAO {

    public static void save(Session session, Cliente cliente) {
        session.save(cliente);
    }

    public static void delete(Session session, Cliente cliente) {
        session.delete(cliente);
    }

    public static Cliente loadById(Session session, Integer id) {
        return (Cliente) session.createQuery("FROM Cliente WHERE id=" + id).uniqueResult();
    }

    public static Cliente loadByNome(Session session, String nome) {
        return (Cliente) session.createQuery("FROM Cliente WHERE id=" + nome + "'").uniqueResult();
    }

    public static List<Cliente> loadList(Session session) {
        List<Cliente> list = session.createQuery("FROM Cliente").list();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

    public static List<String> loadNomeList(Session session) {
        List<String> list = session.createQuery("SELECT nome FROM Cliente ORDER By nome").list();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

}
