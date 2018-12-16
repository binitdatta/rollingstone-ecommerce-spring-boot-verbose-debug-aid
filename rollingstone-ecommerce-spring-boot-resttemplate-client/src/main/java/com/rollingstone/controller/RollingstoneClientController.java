package com.rollingstone.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.model.Account;
import com.rollingstone.model.AccountDTO;
import com.rollingstone.model.AccountUserResponseDTO;
import com.rollingstone.model.User;
import com.rollingstone.service.RollingStoneAccountRestfulClient;
import com.rollingstone.verbose.RequestInsightCollector;

@RestController
public class RollingstoneClientController {

	Logger logger  = LoggerFactory.getLogger(RollingstoneClientController.class);
	
	RollingStoneAccountRestfulClient restClient;
	
	public RollingstoneClientController(RollingStoneAccountRestfulClient restClient) {
		this.restClient = restClient;
	}
	
	@GetMapping("/account/{id}")
	@ResponseBody
	public Account getAccount(@PathVariable("id") Long id) {
		return restClient.getAccount(id);
	}
	
	@GetMapping("/account/verbose/{id}")
	@ResponseBody
	public AccountDTO getAccountVerbose(@PathVariable("id") Long id) {
		return restClient.getAccountxVervose(id);
	}
	
	@GetMapping("/user/verbose/{id}")
	@ResponseBody
	public User getUserVerbose(@PathVariable("id") Long id) {
		return restClient.getUserVervose(id);
	}
	
	@GetMapping("/account-and-user/verbose/{id}")
	@ResponseBody
	public AccountUserResponseDTO getAccountUserVerbose(@PathVariable("id") Long id, HttpServletRequest request) {
		boolean verbose = Boolean.valueOf(request.getParameter("verbose"));
		logger.info("Verbose :"+verbose);
		RequestInsightCollector.setVerbose(verbose);
		AccountUserResponseDTO dto =  restClient.getAccountAndUser(id);
		RequestInsightCollector.releaseRequest();
		return dto;
	}
}
