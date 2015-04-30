/**
 * 
 */
package br.com.keepitsimple.bonecollector.mongo;

import io.dropwizard.lifecycle.Managed;

import com.mongodb.MongoClient;

/**
 * @author gatto
 *
 */
public class MongoServer implements Managed {

	private MongoClient mongoClient;

	/**
	 * 
	 * @param mongo
	 */
	public MongoServer(MongoClient mongo) {
        this.mongoClient = mongo;
	}

	/* (non-Javadoc)
	 * @see io.dropwizard.lifecycle.Managed#start()
	 */
	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see io.dropwizard.lifecycle.Managed#stop()
	 */
	@Override
	public void stop() throws Exception {
        mongoClient.close();
	}

}
