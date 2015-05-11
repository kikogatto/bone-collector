/**
 * 
 */
package br.com.keepitsimple.commons.repositories.mock;

import javax.persistence.Id;

import br.com.keepitsimple.commons.representation.Identifiable;

/**
 * @author gatto
 *
 */
public class MockIdentifiable implements Identifiable {
    @Id
    private Long uid;
    /**
     * 
     */
    public MockIdentifiable() {
        super();
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.representation.Identifiable#getUid()
     */
    @Override
    public Long getUid() {
        return this.uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }
}
