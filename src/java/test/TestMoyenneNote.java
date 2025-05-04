package test;

import dao.FeedbackDao;

public class TestMoyenneNote {
    public static void main(String[] args) {
        FeedbackDao dao = new FeedbackDao();
        Double moyenne = dao.getAverageNoteByProduit(1); // Exemple produit 1

        System.out.println("Moyenne des notes du produit 1 : " + moyenne);
    }
}
