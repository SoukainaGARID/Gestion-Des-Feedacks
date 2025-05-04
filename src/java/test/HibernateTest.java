/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author GIGA STORE
 */
public class HibernateTest {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("✅ Hibernate is working");
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}