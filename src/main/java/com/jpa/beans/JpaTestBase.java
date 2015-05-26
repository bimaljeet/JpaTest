package com.jpa.beans;

/**
 * Created with IntelliJ IDEA.
 * User: bnayar
 * Date: 2/10/14
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class JpaTestBase {

    @PersistenceContext(name = "Messages")
    private EntityManager em;

    public EntityManager getEntityManager() {
        if (em == null) {
//            Map<String, String> properties = new HashMap<String, String>();
//            properties.put("javax.persistence.jtaDataSource", "java:/messagesDS");
            EntityManagerFactory result = Persistence.createEntityManagerFactory("Messages");
            em = result.createEntityManager();
        }
        return em;
    }


//    public void setEm(EntityManager em) {
//        this.em = em;
//    }

    public List<Contact> getContactsByUserId(String userId) throws Exception{
        try
        {
            Query query =  getEntityManager().createNamedQuery("getContactsByUserId", Contact.class);
            query.setParameter("userId", userId);

            List<Contact> returnObjects = query.getResultList();

            return returnObjects;
        } catch (Exception e) {
            throw new Exception("ContactDao - Failed: getContactsByUserId", e);
        } finally {

        }
    }

    private void printEmployee(Employee employee) {
        System.out.print("First Nathis: " + employee.getFirstName());
        System.out.print("  Last Nathis: " + employee.getLastName());
        System.out.println("  Salary: " + employee.getSalary());
    }
}
