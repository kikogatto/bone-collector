/**
 * 
 */
package br.com.keepitsimple.commons.repositories;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mongojack.DBQuery.Query;

import br.com.keepitsimple.commons.repositories.mock.MockIdentifiable;

/**
 * @author gatto
 *
 */
public class AbstractRepositoryTest {

    /**
     * Test method for {@link br.com.keepitsimple.commons.repositories.AbstractRepository#saveOrUpdate(br.com.keepitsimple.commons.representation.Identifiable)}.
     */
    @Test
    public void testSaveOrUpdateSAVE() {
        MockRepository repository = new MockRepository();
        MockIdentifiable id = new MockIdentifiable();
        assertFalse(repository.isPersisted(id));
        repository.saveOrUpdate(id);
        assertTrue(repository.saved);
        assertFalse(repository.updated);
        assertTrue(repository.isPersisted(id));
    }
    @Test
    public void testSaveOrUpdateUPDATE() {
        MockRepository repository = new MockRepository();
        MockIdentifiable id = new MockIdentifiable();
        id.setUid(22l);
        assertTrue(repository.isPersisted(id));
        repository.saveOrUpdate(id);
        assertTrue(repository.updated);
        assertFalse(repository.saved);
    }

    /**
     * Test method for {@link br.com.keepitsimple.commons.repositories.AbstractRepository#isPersisted(br.com.keepitsimple.commons.representation.Identifiable)}.
     */
    @Test
    public void testIsPersisted() {
        MockRepository repository = new MockRepository();
        assertFalse(repository.isPersisted(new MockIdentifiable()));
        MockIdentifiable id = new MockIdentifiable();
        id.setUid(22l);
        assertTrue(repository.isPersisted(id));
    }
}

class MockRepository extends AbstractRepository<MockIdentifiable> {
    public boolean saved = false;
    public boolean updated = false;
    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.Repository#identifiedBy(long)
     */
    @Override
    public MockIdentifiable identifiedBy(long uid) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.Repository#theOneThat(java.util.function.Predicate)
     */
    @Override
    public MockIdentifiable theOneThat(Query query) throws IllegalStateException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.Repository#that(java.util.function.Predicate)
     */
    @Override
    public List<MockIdentifiable> that(Query query) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.Repository#remove(br.com.keepitsimple.commons.representation.Identifiable)
     */
    @Override
    public boolean remove(MockIdentifiable identifiable) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.AbstractRepository#save(br.com.keepitsimple.commons.representation.Identifiable)
     */
    @Override
    protected MockIdentifiable save(MockIdentifiable identifiable) {
        identifiable.setUid(new Date().getTime());
        this.saved = true;
        return identifiable;
    }

    /* (non-Javadoc)
     * @see br.com.keepitsimple.commons.repositories.AbstractRepository#update(br.com.keepitsimple.commons.representation.Identifiable)
     */
    @Override
    protected MockIdentifiable update(MockIdentifiable identifiable) {
        this.updated = true;
        return identifiable;
    }
    
    
}