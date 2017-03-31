package com.cypc.tgdc.cddc.ad.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="dutylog")
public class Dutylog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payablemoney_seq")  
	@SequenceGenerator(name="payablemoney_seq", sequenceName="id_generator")  
	@Column(name="id")
	private long id;
	
	@Column(name="time")
	private Date time;
	
	@Column(name="description")
	private String description;
	
	@Column(name="record_time")
	private Date recorde_time;
	
	@Column(name="recorder")
	private String recorder;
	
	@Column(name="solver")
	private String solver;
	
	@Column(name="systype")
	private String systype;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getRecorde_time() {
		return recorde_time;
	}
	public void setRecorde_time(Date recorde_time) {
		this.recorde_time = recorde_time;
	}
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	public String getSolver() {
		return solver;
	}
	public void setSolver(String solver) {
		this.solver = solver;
	}
	public String getSystype() {
		return systype;
	}
	public void setSystype(String systype) {
		this.systype = systype;
	}
	
	

}
