/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import dao.ProduitServiceDao;
import entities.ProduitService;
import java.util.List;

/**
 *
 * @author GIGA STORE
 */

public class ProduitServiceService implements IService<ProduitService> {

    private final ProduitServiceDao psd;

    public ProduitServiceService() {
        this.psd = new ProduitServiceDao();
    }

    @Override
    public boolean create(ProduitService o) {
        return psd.create(o);
    }

    @Override
    public boolean delete(ProduitService o) {
        return psd.delete(o);
    }

    @Override
    public boolean update(ProduitService o) {
        return psd.update(o);
    }

    @Override
    public List<ProduitService> findAll() {
        return psd.findAll();
    }

    @Override
    public ProduitService findById(int id) {
        return psd.findById(id);
    }

    public List<ProduitService> findByCategorie(int idCategorie) {
        return psd.findByCategorieId(idCategorie);
    }
    
   
    
  public List<ProduitService> findAll(ProduitService o) {
        return psd.findAll();
    }
}