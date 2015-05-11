/**
 * 
 */
package br.com.keepitsimple.commons.repositories.mongo;

import java.util.List;

import org.mongojack.DBQuery.Query;
import org.mongojack.JacksonDBCollection;

import br.com.keepitsimple.commons.repositories.AbstractPaginatedRepository;
import br.com.keepitsimple.commons.representation.Identifiable;

/**
 * @author gatto
 *
 */
public class MongoRepository<T extends Identifiable> extends AbstractPaginatedRepository<T> {
    private JacksonDBCollection<T, Long> all;
    /**
     * 
     */
    public MongoRepository(JacksonDBCollection<T, Long> all) {
        super();
        this.all = all;
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.Repository#identifiedBy(long)
     */
    @Override
    public T identifiedBy(long uid) {
        return this.getAll().findOneById(uid);
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.Repository#theOneThat(java.util.function.Predicate)
     */
    @Override
    public T theOneThat(Query query) throws IllegalStateException {
        return this.executeSingleResultQuery(query);
    }


    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.PaginatedRepository#that(java.util.function.Function, int, int)
     */
    @Override
    public List<T> that(Query query, int pageSize, int page) {
        return this.executeMultipleResultsQuery(query, pageSize, page);
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.Repository#remove(br.com.keepitsimple.commons.representation.Identifiable)
     */
    @Override
    public boolean remove(T identifiable) {
        this.getAll().removeById(identifiable.getUid());
        return true;
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.AbstractRepository#save(br.com.keepitsimple.commons.representation.Identifiable)
     */
    @Override
    protected T save(T identifiable) {
        this.getAll().insert(identifiable);
        return identifiable;
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.AbstractRepository#update(br.com.keepitsimple.commons.representation.Identifiable)
     */
    @Override
    protected T update(T identifiable) {
        this.getAll().updateById(identifiable.getUid(), identifiable);
        return identifiable;
    }
    
    /**
     * 
     * @param query
     * @return
     */
    protected T executeSingleResultQuery(Query query) {
        return this.getAll().findOne(query);
    }
    
    /**
     * 
     * @param query
     * @param pageSize
     * @param page
     * @return
     */
    protected List<T> executeMultipleResultsQuery(Query query, int pageSize, int page) {
        return this.getAll().find(query).skip(page*pageSize).limit(pageSize).toArray();
    }
    
    /**
     * Returns the collection of all (loaded) Identifiables
     * @return the collection with the loaded identifiables
     */
    protected JacksonDBCollection<T, Long> getAll() {
        return this.all;
    }
}