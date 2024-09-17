package ua.goit.entity.ticket;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.entity.DAO;
import ua.goit.entity.planet.Planet;
import ua.goit.storage.hibernate.HibernateUtil;

import java.util.List;

@Data
class TicketCrudService implements DAO<Ticket, Long> {
    /**
     * @param ticket
     */
    @Override
    public void save(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanetId() == null ) {
            throw new IllegalArgumentException("Client, fromPlanet and toPlanet must not be null.");
        }

        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.persist(ticket);
            session.getTransaction().commit();
        }
    }
    /**
     * @param id
     * @return
     */
    @Override
    public Ticket findById(Long id) {
        try (Session session = HibernateUtil.getInstance().startSession()) {
            return session.get(Ticket.class, id);
        }
    }

    /**
     * @return
     */
    @Override
    public List<Ticket> readAll() {
        try (Session session = HibernateUtil.getInstance().startSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    /**
     * @param ticket
     */
    @Override
    public void update(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanetId() == null) {
            throw new IllegalArgumentException("Client, fromPlanet and toPlanet must not be null.");
        }

        try (Session session = HibernateUtil.getInstance().startSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }

    /**
     * @param ticket
     */
    @Override
    public void delete(Ticket ticket) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.remove(ticket);
            session.getTransaction().commit();
        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getInstance().startSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.delete(ticket);
            }
            transaction.commit();
        }
    }
}
