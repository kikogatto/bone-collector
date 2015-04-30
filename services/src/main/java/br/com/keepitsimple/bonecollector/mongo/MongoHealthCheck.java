/**
 * 
 */
package br.com.keepitsimple.bonecollector.mongo;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.MongoClient;

/**
 * @author gatto
 *
 */
public class MongoHealthCheck extends HealthCheck {

    private MongoClient mongoClient;
    
    /**
     * 
     * @param mongoClient
     */
    public MongoHealthCheck(MongoClient mongoClient) {
        super();
        this.mongoClient = mongoClient;
    }
    
    /*
     * (non-Javadoc)
     * @see com.codahale.metrics.health.HealthCheck#check()
     */
    @Override
    protected Result check() throws Exception {
    	mongoClient.getDatabaseNames();
        return Result.healthy();
    }
}
