/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.FeedbackDao;
import entities.Feedback;
import java.util.List;

/**
 *
 * @author GIGA STORE
 */
public class FeedbackService implements IService<Feedback> {

    private final FeedbackDao feedbackDao;

    public FeedbackService() {
        this.feedbackDao = new FeedbackDao();
    }

    @Override
    public boolean create(Feedback o) {
        return feedbackDao.create(o);
    }

    @Override
    public boolean delete(Feedback o) {
        return feedbackDao.delete(o);
    }

    @Override
    public boolean update(Feedback o) {
        return feedbackDao.update(o);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackDao.findAll();
    }

    @Override
    public Feedback findById(int id) {
        return feedbackDao.findById(id);
    }

    public List<Feedback> findFeedbacksNoteLessThan5() {
        return feedbackDao.findFeedbacksNoteLessThan5();
    }

    public List<Feedback> findFeedbacksByProduit(int produitId) {
        return feedbackDao.findFeedbacksByProduit(produitId);
    }

    public List<Feedback> findFeedbacksByClient(int clientId) {
        return feedbackDao.findFeedbacksByClient(clientId);
    }

    public Double getAverageNoteByProduit(int produitId) {
        return feedbackDao.getAverageNoteByProduit(produitId);
    }

    public int getTotalFeedbacks() {
        return feedbackDao.getTotalFeedbacks();
    }

    public double getGlobalAverageNote() {
        return feedbackDao.getGlobalAverageNote();
    }

}
