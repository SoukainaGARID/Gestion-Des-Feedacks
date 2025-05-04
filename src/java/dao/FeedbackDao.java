package dao;

import entities.Feedback;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class FeedbackDao extends AbstractDao<Feedback> {

    public FeedbackDao() {
        super(Feedback.class);
    }

    // Find feedbacks with note < 5
    public List<Feedback> findFeedbacksNoteLessThan5() {
        Session session = null;
        Transaction tx = null;
        List<Feedback> feedbacks = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            feedbacks = session.getNamedQuery("findFeedbacksNoteLessThan5").list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace(); // pour voir l'erreur si besoin
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return feedbacks;
    }

    // Find feedbacks by produit
    public List<Feedback> findFeedbacksByProduit(int produitId) {
        Session session = null;
        Transaction tx = null;
        List<Feedback> feedbacks = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            feedbacks = session.getNamedQuery("findFeedbacksByProduit").setInteger("idProduit", produitId).list();

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

        return feedbacks;
    }

    // Find feedbacks by client
    public List<Feedback> findFeedbacksByClient(int clientId) {
        Session session = null;
        Transaction tx = null;
        List<Feedback> feedbacks = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            feedbacks = session.getNamedQuery("findFeedbacksByClient").setInteger("idClient", clientId).list();

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

        return feedbacks;
    }

    // Get average note by produit
    public Double getAverageNoteByProduit(int produitId) {
        Session session = null;
        Transaction tx = null;
        Double avgNote = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            avgNote = (Double) session
                    .createQuery("SELECT AVG(f.note) FROM Feedback f WHERE f.produit.idProduit = :produitId")
                    .setParameter("produitId", produitId)
                    .uniqueResult();

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

        return avgNote;
    }
    // Total de feedbacks (pour le dashboard)

    public int getTotalFeedbacks() {
        Session session = null;
        Transaction tx = null;
        Long total = 0L;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            total = (Long) session.createQuery("SELECT COUNT(f) FROM Feedback f").uniqueResult();

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

        return total.intValue();
    }

// Moyenne globale de toutes les notes (pour le dashboard)
    public double getGlobalAverageNote() {
        Session session = null;
        Transaction tx = null;
        Double avg = 0.0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            avg = (Double) session.createQuery("SELECT AVG(f.note) FROM Feedback f").uniqueResult();

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

        return avg != null ? avg : 0.0;
    }

}
