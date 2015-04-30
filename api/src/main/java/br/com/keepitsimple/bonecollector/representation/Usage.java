/**
 * 
 */
package br.com.keepitsimple.bonecollector.representation;

import java.util.UUID;

import javax.persistence.Id;

import org.joda.time.DateTime;

/**
 * @author gatto
 *
 */
public class Usage {
	@Id
	private String uid = UUID.randomUUID().toString();
	private String userId;
	private DateTime creationTime = new DateTime();
	private DateTime useTime;
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
	public String getUid() {
		return uid;
	}


	/**
	 * @param uid the uid to set
	 */
	
	public void setUid(String uid) {
		this.uid = uid;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((use == null) ? 0 : use.hashCode());
		result = prime * result + ((useTime == null) ? 0 : useTime.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
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
		if (creationTime == null) {
			if (other.creationTime != null) {
				return false;
			}
		} else if (!creationTime.equals(other.creationTime)) {
			return false;
		}
		if (uid == null) {
			if (other.uid != null) {
				return false;
			}
		} else if (!uid.equals(other.uid)) {
			return false;
		}
		if (use == null) {
			if (other.use != null) {
				return false;
			}
		} else if (!use.equals(other.use)) {
			return false;
		}
		if (useTime == null) {
			if (other.useTime != null) {
				return false;
			}
		} else if (!useTime.equals(other.useTime)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usage [uid=" + uid + ", userId=" + userId + ", creationTime="
				+ creationTime + ", useTime=" + useTime + ", use=" + use + "]";
	}

	
}
