/**
 * 
 */
package br.com.keepitsimple.commons.repositories;

import java.util.List;

import org.mongojack.DBQuery.Query;

import br.com.keepitsimple.commons.representation.Identifiable;

/**
 * Describes the behavior of a Repository of Identifiables
 * @author Kiko Gatto [06/05/2015]
 *
 * @param <T> The type of Identifiable that is managed by the Repository
 */
public interface Repository<T extends Identifiable> {

    /**
     * Returns the instance of T identified by the given unique Id
     * @param uid the unique identifier
     * @return the instance of T identified by the given uid
     */
    T identifiedBy(long uid);
    
    /**
     * Returns ONE instance of T that follows the given Predicate
     * @param query has the rules that determine the instance
     * @return an instance of T that follows the given Predicate, or null if none if found.
     * @throws IllegalStateException
     */
    T theOneThat(Query query) throws IllegalStateException;
    
    /**
     * Returns a list with all the instances of T that follows the given Predicate
     * @param query has the rules that determine the instance
     * @return a List<T> with the instances that follows the given Predicate
     */
    List<T> that(Query query);
    
    /**
     * Saves or updates the given Identifiable
     * @param identifiable the instance to be saved or updated
     * @return the newly saved (or updated) Identifiable
     */
    T saveOrUpdate(T identifiable);
    
    /**
     * Removes the given Identifiable from the Repository
     * @param identifiable the T to remove
     * @return true if it was removed. false otherwise
     */
    boolean remove(T identifiable);
    
}
