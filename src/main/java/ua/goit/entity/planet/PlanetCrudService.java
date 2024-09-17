package ua.goit.entity.planet;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.entity.DAO;
import ua.goit.storage.hibernate.HibernateUtil;

import java.util.List;

@Data
class PlanetCrudService implements DAO<Planet, Long> {

    @Override
    public void save(Planet planet) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.persist(planet);
            session.getTransaction().commit();

        }
    }

    @Override
    public Planet findById(Long id) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            return session.get(Planet.class, id);
        }
    }


    @Override
    public List<Planet> readAll() {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

    @Override
    public void update(Planet planet) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(planet);
            transaction.commit();
        }
    }

    @Override
    public void delete(Planet planet) {
        try(Session session = HibernateUtil.getInstance().startSession()) {
            session.beginTransaction();
            session.remove(planet);
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
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.remove(planet);
                session.getTransaction().commit();
            } else {
                System.out.println("Planet with id " + id + " not found.");
                session.getTransaction().rollback();
            }
        }
    }

}
