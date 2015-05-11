/**
 * 
 */
package br.com.keepitsimple.bonecollector.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.keepitsimple.bonecollector.repositories.UsageRepository;
import br.com.keepitsimple.bonecollector.representation.Usage;

import com.codahale.metrics.annotation.Timed;

/**
 * This class represents a REST resource for Usage
 * 
 * @author gatto
 *
 * @since 0.0.1 
 */
@Path("/usage")
@Produces(MediaType.APPLICATION_JSON)
public class UsageResource {
	private final UsageRepository usageRepository;
	
	/**
	 * Creates e new UsageResouce with the given repository
	 * @param usageRepository
	 */
	public UsageResource(UsageRepository usageRepository) {
		super();
		this.usageRepository = usageRepository;
	}

	/**
	 * Persists the given usage
	 * @param usage
	 * @return the now persisted Usage
	 */
	@Timed
    @POST
    public Usage log(Usage usage){
    	return this.usageRepository.saveOrUpdate(usage);
    }
    
    /**
     * Lists all persisted usages
     * @return a List Object with all the Usages
     */
	@Timed
    @GET
    public List<Usage> listAll() {
    	return this.usageRepository.findAll();
    }
}
