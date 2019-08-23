package insumosAgri;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author cta
 */
public class InsumoDAO {
    public static void save(Session session, Insumo insumo) {
        session.save(insumo);
    }
    public static void delete(Session session, Insumo insumo) {
        session.delete(insumo);
    }
    public static Insumo loadById(Session session, Integer id) {
        return (Insumo)session.createQuery
                         ("FROM Insumo WHERE id="+id).uniqueResult();
    }
    public static Insumo loadByNome(Session session, String nome) {
        return (Insumo)session.createQuery
                ("FROM Insumo WHERE nome='"+nome+"'").uniqueResult();
    }
    public static List<Insumo> loadList(Session session) {
        List<Insumo> list = session.createQuery("FROM Insumo").list();
        if(list==null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }
    public static List<String> loadNomeList(Session session) {
        List<String> list = session.createQuery("SELECT nome FROM Insumo ORDER By nome").list();
        if(list==null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }
    
}
