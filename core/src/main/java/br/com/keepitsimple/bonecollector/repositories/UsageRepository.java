/**
 * 
 */
package br.com.keepitsimple.bonecollector.repositories;

import java.util.List;

import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;

import br.com.keepitsimple.bonecollector.representation.Usage;
import br.com.keepitsimple.commons.repositories.mongo.MongoRepository;


/**
 * @author gatto
 *
 */
public class UsageRepository extends MongoRepository<Usage>{

	
	/**
	 * 
	 * @param usage
	 */
	public UsageRepository(JacksonDBCollection<Usage, Long> all) {
		super(all);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Usage> findAll() {
		return this.getAll().find().toArray();
	}
	
	public List<Usage> byUsers(List<Integer>userIds) {
	    return this.that(DBQuery.in("userId", userIds));
	}
}
