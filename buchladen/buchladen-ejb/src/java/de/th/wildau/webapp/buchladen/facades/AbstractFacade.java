package de.th.wildau.webapp.buchladen.facades;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 * @param <T> Entitäten Generic
 */
public abstract class AbstractFacade<T> {
    
    /**
     * Die Entitäten-Klasse.
     */
    private Class<T> entityClass;

    /**
     * Setzt die Entität-Klasse.
     * @param entityClass Entitäten Klasse
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Abstrakte Getter-Methode des Entitäten-Managers.
     * @return Entitäten-Manager
     */
    protected abstract EntityManager getEntityManager();

    /**
     * Erstellt eine Entität.
     * @param entity Entität die erstellt werden soll
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * Modifiziert eine Entität.
     * @param entity Entität die modifiziert werden soll
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * Löscht eine Entität.
     * @param entity Entität die gelöscht werden soll
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Liefert eine bestimmte Entität zurück.
     * @param id ID der Entität
     * @return Entität
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Liefert eine Liste aller Entitäten zurück.
     * @return Liste von Entitäten
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Liefert eine Liste von Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Entitäten
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * Liefert die Anzahl an gefundenen Entitäten zurück.
     * @return Anzahl gefundender Entitäten
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
