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
public abstract class AbstractPaginatedRepository<T extends Identifiable> extends AbstractRepository<T> implements PaginatedRepository<T> {

    /**
     * 
     */
    public AbstractPaginatedRepository() {
        super();
    }


    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.Repository#that(java.util.function.Function)
     */
    @Override
    public List<T> that(Query query) {
        return this.that(query, Integer.MAX_VALUE, 1);
    }
}
