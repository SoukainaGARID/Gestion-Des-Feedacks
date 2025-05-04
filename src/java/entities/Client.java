/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.io.Serializable;
import javax.persistence.Entity;


/**
 *
 * @author GIGA STORE
 */
@Entity
public class Client extends User  {

    public Client() {
    }

    public Client(String nom, String email, String password) {
        super(nom, email, password);
    }

    
  
}
