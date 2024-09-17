package ua.goit.entity.client;

import lombok.Data;
import org.hibernate.Session;
import ua.goit.entity.DAO;
import ua.goit.storage.hibernate.HibernateUtil;

import java.util.List;

@Data
class ClientCrudService implements DAO<Client, Long> {

    @Override
    public void save(Client client) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.persist(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public Client findById(Long clientId) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            return session.get(Client.class, clientId);
        }
    }

    @Override
    public List<Client> readAll() {
        try (Session session = HibernateUtil.getInstance().startSession()) {
            return session.createQuery("from Client", Client.class).getResultList();
        }
    }

    @Override
    public void update(Client client) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.update(client);
        }
    }

    @Override
    public void delete(Client client) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.remove(client);
            session.getTransaction().commit();

        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.remove(client);
                session.getTransaction().commit();
            } else {
                System.out.println("Client with id " + id + " not found.");
                session.getTransaction().rollback();
            }
        }
    }



    public void deleteClientById(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.remove(client);
                session.getTransaction().commit();
            } else {
                System.out.println(STR."Client with id \{id} not found.");
                session.getTransaction().rollback();
            }
        }
    }
}

