package com.rollingstone.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rollingstone.verbose.RequestInsight;

@JsonInclude(Include.NON_NULL)
public class AccountUserResponseDTO {

	private AccountDTO account;
	private User user;

	@JsonInclude(Include.NON_EMPTY)	
	private List<RequestInsight> requestInsignts = new ArrayList<RequestInsight>();
	
	public AccountDTO getAccount() {
		return account;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public List<RequestInsight> getRequestInsignts() {
		return requestInsignts;
	}
	public void setRequestInsignts(List<RequestInsight> requestInsignts) {
		this.requestInsignts = requestInsignts;
	}
	public AccountUserResponseDTO(AccountDTO account, User user) {
		super();
		this.account = account;
		this.user = user;
	}
	@Override
	public String toString() {
		return "AccountUserResponseDTO [account=" + account + ", user=" + user + "]";
	}
	
	
}
