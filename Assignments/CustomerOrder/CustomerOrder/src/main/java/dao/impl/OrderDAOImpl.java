package dao.impl;

import dao.OrderDAO;
import entity.Order;
import util.JPAUtil;
import jakarta.persistence.EntityManager;

public class OrderDAOImpl implements OrderDAO {

    public void updateOrder(Order order) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.merge(order);

        em.getTransaction().commit();
        em.close();
    }

    public Order getOrderById(int id) {

        EntityManager em = JPAUtil.getEntityManager();
        Order order = em.find(Order.class, id);
        em.close();

        return order;
    }
}