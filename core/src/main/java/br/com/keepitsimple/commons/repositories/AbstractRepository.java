/**
 * 
 */
package br.com.keepitsimple.commons.repositories;

import br.com.keepitsimple.commons.representation.Identifiable;

/**
 * @author gatto
 *
 */
public abstract class AbstractRepository<T extends Identifiable> implements Repository<T> {


    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.Repository#saveOrUpdate(br.com.keepitsimple.commons.representation.Identifiable)
     */
    @Override
    public T saveOrUpdate(T identifiable) {
        return this.isPersisted(identifiable) ? this.update(identifiable) : this.save(identifiable);
    }

    /**
     * Returns true if the given Identifiable has already been persisted
     * @param identifiable the Identifiable tocheck
     * @return true if the given identifiable has been persisted (ie.: has an uid) or false otherwise
     */
    protected boolean isPersisted(T identifiable){
        return identifiable.getUid() != null;
    }

    /**
     * Saves a new identifiable 
     * @param identifiable the new Identifiable to save
     * @return the newly savedIdentifiable
     */
    protected abstract T save(T identifiable);
    
    /**
     * Updates an already saved Identifiable
     * @param identifiable the Identifiable to Update
     * @return the updated Identifiable
     */
    protected abstract T update(T identifiable);

}
