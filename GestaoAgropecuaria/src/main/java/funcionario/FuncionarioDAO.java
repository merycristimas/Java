package funcionario;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author cta
 */
public class FuncionarioDAO {

    /**
     * Salva um objeto funcionario
     * @param session
     * @param funcionario 
     */
    public static void save(Session session, Funcionario funcionario) {
        if(funcionario.getId()==null) {
            session.save(funcionario);
        } else {
            session.update(funcionario);
        }
    }

    /**
     * Deleta um objeto funcionario
     * @param session
     * @param funcionario 
     */
    public static void delete(Session session, Funcionario funcionario) {
        session.delete(funcionario);
    }

    public static Funcionario loadById(Session session, Integer id) {
        return (Funcionario) session.createQuery("FROM Funcionario WHERE id=" + id).uniqueResult();
    }

    public static Funcionario loadByNome(Session session, String nome) {
        return (Funcionario) session.createQuery("FROM Funcionario WHERE nome='" + nome + "'").uniqueResult();
    }

    public static List<Funcionario> loadList(Session session) {
        List<Funcionario> list;
        try {
            list = session.createQuery("FROM Funcionario").list();
        } catch (HibernateException e) {
            list = new ArrayList<>();
        }
        return list;
    }

    public static List<String> loadNomeList(Session session) {
        List<String> list = session.createQuery("SELECT nome FROM Funcionario ORDER By nome").list();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

}
