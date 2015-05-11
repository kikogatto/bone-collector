/**
 * 
 */
package br.com.keepitsimple.commons.repositories;

import java.util.List;

import org.mongojack.DBQuery.Query;

import br.com.keepitsimple.commons.representation.Identifiable;

/**
 * @author gatto
 *
 */
public interface PaginatedRepository<T extends Identifiable> extends Repository<T> {

    /**
     * Returns a list with a page of the instances of T that follows the given Predicate
     * @param query has the rules that determine the instance
     * @param pageSize the size of one page
     * @param page the number of the desired page
     * @return a List<T> with the page of instances that follows the given Predicate
     */
    List<T> that(Query query, int pageSize, int page);

}
