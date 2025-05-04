package dao;

import entities.ProduitService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ProduitServiceDao extends AbstractDao<ProduitService> {

    public ProduitServiceDao() {
        super(ProduitService.class);
    }

    public List<ProduitService> findByCategorieId(int idCategorie) {
        Session session = null;
        Transaction tx = null;
        List<ProduitService> produits = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            produits = session.getNamedQuery("findProduitsByCategorie")
                    .setParameter("idCategorie", idCategorie)
                    .list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return produits;
    }

    public List<ProduitService> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProduitService> produits = session.createQuery("FROM ProduitService").list();
        session.close();
        return produits;
    }

}
