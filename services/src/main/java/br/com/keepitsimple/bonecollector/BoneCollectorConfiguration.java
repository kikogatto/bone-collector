/**
 * 
 */
package br.com.keepitsimple.bonecollector;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

/**
 * @author gatto
 *
 */
public class BoneCollectorConfiguration extends Configuration {
	private String mongoHost = "localhost";
	
	private int mongoPort = 27017;
	
	/**
	 * 
	 */
	public BoneCollectorConfiguration() {
		super();
	}

	/**
	 * @return the mongoHost
	 */
	@JsonProperty
	public String getMongoHost() {
		return mongoHost;
	}

	/**
	 * @param mongoHost the mongoHost to set
	 */
	@JsonProperty
	public void setMongoHost(String mongoHost) {
		this.mongoHost = mongoHost;
	}

	/**
	 * @return the mongoPort
	 */
	@JsonProperty
	public int getMongoPort() {
		return mongoPort;
	}

	/**
	 * @param mongoPort the mongoPort to set
	 */
	@JsonProperty
	public void setMongoPort(int mongoPort) {
		this.mongoPort = mongoPort;
	}

	
}
