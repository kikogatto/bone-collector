/**
 * 
 */
package br.com.keepitsimple.bonecollector.repositories;

import java.util.List;

import org.mongojack.JacksonDBCollection;

import br.com.keepitsimple.bonecollector.representation.Usage;

/**
 * @author gatto
 *
 */
public class UsageRepository {

	private JacksonDBCollection<Usage, String> allUsage;
	
	/**
	 * 
	 * @param usage
	 */
	public UsageRepository(JacksonDBCollection<Usage, String> usage) {
		this.allUsage = usage;
	}

	/**
	 * 
	 * @param usage
	 * @return
	 */
	public Usage logUse(Usage usage) {
		this.allUsage.insert(usage);
		return usage;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Usage> findAll() {
		return this.allUsage.find().toArray();
	}
}
