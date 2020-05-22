package com.example.omreon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ScUserlog {
	
	@Id
	@Column(name="db_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "session_id")
	private String sessionId;
	

	@Column(name = "log_time")
	private Date logTime;
	
	@Column(name = "log")
	private String log;
	
	@Column(name= "instance_name")
	private String instanceName;
	
	public ScUserlog() {
		
	}

	public ScUserlog(long dbId, String sessionID, Date logTime, String log, String instanceName) {
		this.id = dbId;
		this.sessionId = sessionID;
		this.logTime = logTime;
		this.log = log;
		this.instanceName = instanceName;
	}

	public long getDbId() {
		return id;
	}

	public void setDbId(long dbId) {
		this.id = dbId;
	}

	public String getSessionID() {
		return sessionId;
	}

	public void setSessionID(String sessionID) {
		this.sessionId = sessionID;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	@Override
	public String toString() {
		return "ScUserlog [id=" + id + ", sessionId=" + sessionId + ", logTime=" + logTime + ", log=" + log
				+ ", instanceName=" + instanceName + "]";
	}
	

}
