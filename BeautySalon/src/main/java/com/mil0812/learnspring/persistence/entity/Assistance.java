package com.mil0812.learnspring.persistence.entity;

import java.time.LocalDateTime;

public class Assistance extends Entity{
	private Client client;
	private BeautyMaster beautyMaster;
	private LocalDateTime localDateTime;
	private AssistanceType assistanceType;

	public Assistance(Integer id, Client client, BeautyMaster beautyMaster,
	    LocalDateTime localDateTime,
	    AssistanceType assistanceType) {
		super(id);
		this.client = client;
		this.beautyMaster = beautyMaster;
		this.localDateTime = localDateTime;
		this.assistanceType = assistanceType;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BeautyMaster getBeautyMaster() {
		return beautyMaster;
	}

	public void setBeautyMaster(BeautyMaster beautyMaster) {
		this.beautyMaster = beautyMaster;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public AssistanceType getAssistanceType() {
		return assistanceType;
	}

	public void setAssistanceType(AssistanceType assistanceType) {
		this.assistanceType = assistanceType;
	}

	@Override
	public String toString() {
		return "Assistance{" +
		    "client=" + client +
		    ", beautyMaster=" + beautyMaster +
		    ", localDateTime=" + localDateTime +
		    ", assistanceType=" + assistanceType +
		    '}';
	}
}
