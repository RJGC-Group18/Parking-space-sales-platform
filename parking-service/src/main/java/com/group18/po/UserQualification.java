package com.group18.po;
// Generated 2021-11-27 1:43:04 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserQualification generated by hbm2java
 */
@Entity
@Table(name = "user_qualification", catalog = "parkingsafesdb")
public class UserQualification implements java.io.Serializable {

	private int qid;
	private User user;
	private byte[] image;
	private Boolean qualification;

	public UserQualification() {
	}

	public UserQualification(int qid, User user) {
		this.qid = qid;
		this.user = user;
	}

	public UserQualification(int qid, User user, byte[] image, Boolean qualification) {
		this.qid = qid;
		this.user = user;
		this.image = image;
		this.qualification = qualification;
	}

	@Id

	@Column(name = "qid", unique = true, nullable = false)
	public int getQid() {
		return this.qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "image")
	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "qualification")
	public Boolean getQualification() {
		return this.qualification;
	}

	public void setQualification(Boolean qualification) {
		this.qualification = qualification;
	}

}