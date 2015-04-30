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
 * @author gatto
 *
 */
@Path("/usage")
@Produces(MediaType.APPLICATION_JSON)
public class UsageResource {
	private final UsageRepository usageRepository;
	
	/**
	 * 
	 * @param usageRepository
	 */
	public UsageResource(UsageRepository usageRepository) {
		super();
		this.usageRepository = usageRepository;
	}

	/**
	 * 
	 * @param usage
	 * @return
	 */
	@Timed
    @POST
    public Usage log(Usage usage){
    	return this.usageRepository.logUse(usage);
    }
    
    /**
     * 
     * @return
     */
	@Timed
    @GET
    public List<Usage> listAll() {
    	return this.usageRepository.findAll();
    }
}
