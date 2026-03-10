package dao.impl;

import dao.CustomerDAO;
import entity.Customer;
import util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public void insertCustomer(Customer customer) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(customer);

        em.getTransaction().commit();
        em.close();
    }

    public void updateCustomer(Customer customer) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.merge(customer);

        em.getTransaction().commit();
        em.close();
    }

    public void deleteCustomer(int id) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Customer customer = em.find(Customer.class, id);
        em.remove(customer);

        em.getTransaction().commit();
        em.close();
    }

    public Customer getCustomerById(int id) {

        EntityManager em = JPAUtil.getEntityManager();
        Customer customer = em.find(Customer.class, id);
        em.close();

        return customer;
    }

    public List<Customer> getAllCustomers() {

        EntityManager em = JPAUtil.getEntityManager();
        List<Customer> list =
                em.createQuery("from Customer", Customer.class).getResultList();
        em.close();

        return list;
    }

    public Customer getCustomerByEmail(String email) {

        EntityManager em = JPAUtil.getEntityManager();

        Customer customer = em.createQuery(
                "SELECT c FROM Customer c WHERE c.email = :email",
                Customer.class)
                .setParameter("email", email)
                .getSingleResult();

        em.close();

        return customer;
    }
}