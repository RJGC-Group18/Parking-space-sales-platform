package com.group18.po;
// Generated 2021-11-27 1:43:04 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Client generated by hbm2java
 */
@Entity
@Table(name = "client", catalog = "parkingsafesdb")
public class Client implements java.io.Serializable {

	private int cid;
	private String username;
	private String password;
	private ClientInformation clientInformation;
	private Set<ClientQualification> clientQualifications = new HashSet<ClientQualification>(0);
	private Set<Dealing> dealings = new HashSet<Dealing>(0);
	private Set<Reservation> reservations = new HashSet<Reservation>(0);
	private Set<ClientQualification> clientQualifications_1 = new HashSet<ClientQualification>(0);
	private Set<Payment> payments = new HashSet<Payment>(0);

	public Client() {
	}

	public Client(int cid) {
		this.cid = cid;
	}

	public Client(int cid, String username, String password, ClientInformation clientInformation,
			Set<ClientQualification> clientQualifications, Set<Dealing> dealings, Set<Reservation> reservations,
			Set<ClientQualification> clientQualifications_1, Set<Payment> payments) {
		this.cid = cid;
		this.username = username;
		this.password = password;
		this.clientInformation = clientInformation;
		this.clientQualifications = clientQualifications;
		this.dealings = dealings;
		this.reservations = reservations;
		this.clientQualifications_1 = clientQualifications_1;
		this.payments = payments;
		this.clientInformation = clientInformation;
	}

	@Id

	@Column(name = "cid", unique = true, nullable = false)
	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "client")
	public ClientInformation getClientInformation() {
		return this.clientInformation;
	}

	public void setClientInformation(ClientInformation clientInformation) {
		this.clientInformation = clientInformation;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<ClientQualification> getClientQualifications() {
		return this.clientQualifications;
	}

	public void setClientQualifications(Set<ClientQualification> clientQualifications) {
		this.clientQualifications = clientQualifications;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Dealing> getDealings() {
		return this.dealings;
	}

	public void setDealings(Set<Dealing> dealings) {
		this.dealings = dealings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<ClientQualification> getClientQualifications_1() {
		return this.clientQualifications_1;
	}

	public void setClientQualifications_1(Set<ClientQualification> clientQualifications_1) {
		this.clientQualifications_1 = clientQualifications_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}
