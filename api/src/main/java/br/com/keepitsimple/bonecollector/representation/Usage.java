/**
 * 
 */
package br.com.keepitsimple.bonecollector.representation;

import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

import br.com.keepitsimple.commons.representation.Identifiable;

/**
 * @author gatto
 *
 */
public class Usage implements Identifiable {
	@Id
	private Long uid;
	private DateTime creationTime = new DateTime();
	private String applicationKey;
	private String userId;
	private DateTime useTime;
	private Long duration;
	private String use;
	
	
	/**
	 * 
	 */
	public Usage() {
		super();
	}


	/**
	 * @return the uid
	 */
	public Long getUid() {
		return uid;
	}


	/**
	 * @param uid the uid to set
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}


	/**
	 * @return the creationTime
	 */
	public DateTime getCreationTime() {
		return creationTime;
	}


	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}


	/**
	 * @return the applicationKey
	 */
	public String getApplicationKey() {
		return applicationKey;
	}


	/**
	 * @param applicationKey the applicationKey to set
	 */
	public void setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
	}


	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * @return the useTime
	 */
	public DateTime getUseTime() {
		return useTime;
	}


	/**
	 * @param useTime the useTime to set
	 */
	public void setUseTime(DateTime useTime) {
		this.useTime = useTime;
	}


	/**
	 * @return the duration
	 */
	public Long getDuration() {
		return duration;
	}


	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Long duration) {
		this.duration = duration;
	}


	/**
	 * @return the use
	 */
	public String getUse() {
		return use;
	}


	/**
	 * @param use the use to set
	 */
	public void setUse(String use) {
		this.use = use;
	}




    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return new HashCodeBuilder(prime, result).append(this.uid).toHashCode();
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Usage other = (Usage) obj;
        return new EqualsBuilder().append(this.uid, other.getUid()).isEquals();
    }


    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usage [uid=" + uid + ", creationTime=" + creationTime
				+ ", applicationKey=" + applicationKey + ", userId=" + userId
				+ ", useTime=" + useTime + ", duration=" + duration + ", use="
				+ use + "]";
	}

}