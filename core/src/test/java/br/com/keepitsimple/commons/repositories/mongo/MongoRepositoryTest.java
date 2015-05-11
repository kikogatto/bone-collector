/**
 * 
 */
package br.com.keepitsimple.commons.repositories.mongo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mongojack.JacksonDBCollection;

import br.com.keepitsimple.commons.repositories.mock.MockIdentifiable;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

/**
 * @author gatto
 */
public abstract class MongoRepositoryTest {
    JacksonDBCollection<MockIdentifiable, Long> identifiables;

    /**
     * Test method for
     * {@link br.com.keepitsimple.commons.repositories.mongo.MongoRepository#save(br.com.keepitsimple.commons.representation.Identifiable)}.
     */
    @Test
    public void testSave() {
        MongoRepository<MockIdentifiable> repository = new MongoRepository<MockIdentifiable>(this.identifiables);
        MockIdentifiable id = new MockIdentifiable();
        assertNull(id.getUid());
        repository.save(id);
        assertNotNull(id.getUid());
    }

    /**
     * Test method for
     * {@link br.com.keepitsimple.commons.repositories.mongo.MongoRepository#update(br.com.keepitsimple.commons.representation.Identifiable)}
     * .
     */
    @Test
    public void testUpdate() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link br.com.keepitsimple.commons.repositories.mongo.MongoRepository#MongoRepository(org.mongojack.JacksonDBCollection)}.
     */
    @Test
    public void testMongoRepository() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link br.com.keepitsimple.commons.repositories.mongo.MongoRepository#identifiedBy(long)}.
     */
    @Test
    public void testIdentifiedBy() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link br.com.keepitsimple.commons.repositories.mongo.MongoRepository#theOneThat(java.util.function.Predicate)}.
     */
    @Test
    public void testTheOneThat() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link br.com.keepitsimple.commons.repositories.mongo.MongoRepository#that(java.util.function.Predicate)}.
     */
    @Test
    public void testThat() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link br.com.keepitsimple.commons.repositories.mongo.MongoRepository#remove(br.com.keepitsimple.commons.representation.Identifiable)}
     * .
     */
    @Test
    public void testRemove() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link br.com.keepitsimple.commons.repositories.mongo.MongoRepository#getAll()}.
     */
    @Test
    public void testGetAll() {
        fail("Not yet implemented");
    }

    @Before
    public void setup() {
        MongoClient mongoClient = Mockito.mock(MongoClient.class);
        DB mockDb = Mockito.mock(DB.class);
        DBCollection mockDbCollection = Mockito.mock(DBCollection.class);
        Mockito.when(mockDb.getCollection("identifiables")).thenReturn(mockDbCollection);
        Mockito.when(mongoClient.getDB("mock-db")).thenReturn(mockDb);
        Mockito.when(mockDbCollection.insert(any(DBObject.class))).then(new Answer<WriteResult>() {
            public WriteResult answer(InvocationOnMock invocation) throws Throwable {
                DBObject identifiable =invocation.getArgumentAt(0, DBObject.class); 
                identifiable.put("_id", new Date().getTime());
                return Mockito.mock(WriteResult.class);
            }
        });
        DB db = mongoClient.getDB("mock-db");

        identifiables = JacksonDBCollection.wrap(db.getCollection("identifiables"), MockIdentifiable.class, Long.class);
    }
}
