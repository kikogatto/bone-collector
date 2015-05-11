/**
 * 
 */
package br.com.keepitsimple.bonecollector;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.mongojack.JacksonDBCollection;

import br.com.keepitsimple.bonecollector.mongo.MongoHealthCheck;
import br.com.keepitsimple.bonecollector.mongo.MongoServer;
import br.com.keepitsimple.bonecollector.repositories.UsageRepository;
import br.com.keepitsimple.bonecollector.representation.Usage;
import br.com.keepitsimple.bonecollector.resources.UsageResource;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * @author gatto
 *
 */
public class BoneCollectorApplication extends Application<BoneCollectorConfiguration> {

    public static void main(String[] args) throws Exception {
        new BoneCollectorApplication().run(args);
    }

	/**
	 * 
	 */
	public BoneCollectorApplication() {
		super();
	}

	@Override
	public void initialize(Bootstrap<BoneCollectorConfiguration> bootstrap) {
		
//		GuiceBundle<BoneCollectorConfiguration> guiceBundle = GuiceBundle.<BoneCollectorConfiguration>newBuilder()
//			      //.addModule(new BoneCollectorModule())
//			      .enableAutoConfig(getClass().getPackage().getName())
//			      .setConfigClass(BoneCollectorConfiguration.class)
//			      .build();
//
//			    bootstrap.addBundle(guiceBundle);
     }

	/**
	 * 
	 * @param configuration
	 * @param environment
	 * @throws Exception
	 */
	@Override
	public void run(BoneCollectorConfiguration configuration, Environment environment) throws Exception {
		MongoClient mongoClient =  new MongoClient(configuration.getMongoHost(), configuration.getMongoPort());
        MongoServer mongoServer = new MongoServer(mongoClient);
        environment.lifecycle().manage(mongoServer);
        environment.healthChecks().register(MongoHealthCheck.class.getName(), new MongoHealthCheck(mongoClient));
        DB db = mongoClient.getDB("bone-collector");
        JacksonDBCollection<Usage, Long> usage = JacksonDBCollection.wrap(db.getCollection("usage"), Usage.class, Long.class);
 
        environment.jersey().register(new UsageResource(new UsageRepository((usage))));		
	}
}
