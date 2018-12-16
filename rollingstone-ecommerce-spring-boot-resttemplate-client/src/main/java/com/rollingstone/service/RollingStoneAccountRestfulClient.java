package com.rollingstone.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rollingstone.model.Account;
import com.rollingstone.model.AccountDTO;
import com.rollingstone.model.AccountUserResponseDTO;
import com.rollingstone.model.User;
import com.rollingstone.verbose.RequestInsight;
import com.rollingstone.verbose.RequestInsightCollector;

@Service
public class RollingStoneAccountRestfulClient {

	Logger logger = LoggerFactory.getLogger(RollingStoneAccountRestfulClient.class);
	RestTemplate restTemplate;

	public RollingStoneAccountRestfulClient() {
		restTemplate = new RestTemplate();
	}

	/**
	 * post entity
	 */
	/*
	 * public void postEntity(){ System.out.println("Begin /POST request!"); String
	 * postUrl = "http://localhost:8080/post"; Customer customer = new Customer(123,
	 * "Jack", 23); ResponseEntity<String> postResponse =
	 * restTemplate.postForEntity(postUrl, customer, String.class);
	 * System.out.println("Response for Post Request: " + postResponse.getBody()); }
	 */

	/**
	 * get entity
	 */
	public Account getAccount(Long id) {
		logger.info("Begin /GET request!");
		String getUrl = "http://localhost:9094/rscommerce/pdp-service/account/" + id;
		Account account = restTemplate.getForObject(getUrl, Account.class);
		logger.info(account.toString());

		return account;
	}

	public AccountDTO getAccountxVervose(Long id) {
		String requestID = UUID.randomUUID().toString();
		RequestInsightCollector.startRequest(requestID);
		logger.info("Begin /GET request!");
		String getUrl = "http://localhost:9094/rscommerce/pdp-service/account/" + id;
		ResponseEntity<AccountDTO> getResponse = restTemplate.getForEntity(getUrl, AccountDTO.class);
		ResponseEntity<String> responseStr = restTemplate.getForEntity(getUrl, String.class);
		if (getResponse.getBody() != null) {
			logger.info("Response for Get Request: " + getResponse.getBody().toString());
		} else {
			logger.info("Response for Get Request: NULL");
		}
		if (responseStr.getBody() != null) {
			logger.info("Response for Get Request: " + responseStr.getBody().toString());
		} else {
			logger.info("Response for Get Request: NULL");
		}
		RequestInsight requestInsight = RequestInsightCollector.getRequestInsight(requestID);
		if (requestInsight != null && requestInsight.isVerbose()) {
			requestInsight.setRequestID(requestID);
			requestInsight.setRequestResponse(responseStr.getBody().toString());
			requestInsight.setRequestStatus(String.valueOf(responseStr.getStatusCodeValue()));
			requestInsight.setRequestURI(getUrl);
			requestInsight.setElaspsedTime(RequestInsightCollector.getElapsedTime(requestID));
			RequestInsightCollector.addRequestInsight(requestInsight);
		}
		return (AccountDTO) getResponse.getBody();
	}

	public User getUserVervose(Long id) {
		String requestID = UUID.randomUUID().toString();
		RequestInsightCollector.startRequest(requestID);

		logger.info("Begin /GET request!");
		String getUrl = "http://localhost:9090/rscommerce/pdp-service/account/user/" + id;
		ResponseEntity<User> getResponse = restTemplate.getForEntity(getUrl, User.class);
		ResponseEntity<String> responseStr = restTemplate.getForEntity(getUrl, String.class);
		if (getResponse.getBody() != null) {
			logger.info("Response for Get Request: " + getResponse.getBody().toString());
		} else {
			logger.info("Response for Get Request: NULL");
		}
		if (responseStr.getBody() != null) {
			logger.info("Response for Get Request: " + responseStr.getBody().toString());
		} else {
			logger.info("Response for Get Request: NULL");
		}
		RequestInsight requestInsight = RequestInsightCollector.getRequestInsight(requestID);
		if (requestInsight != null && requestInsight.isVerbose()) {
			requestInsight.setRequestID(requestID);
			requestInsight.setRequestResponse(responseStr.getBody().toString());
			requestInsight.setRequestStatus(String.valueOf(responseStr.getStatusCodeValue()));
			requestInsight.setRequestURI(getUrl);
			requestInsight.setElaspsedTime(RequestInsightCollector.getElapsedTime(requestID));
			
			RequestInsightCollector.addRequestInsight(requestInsight);
		}
		return (User) getResponse.getBody();
	}

	public AccountUserResponseDTO getAccountAndUser(long accountId) {
		AccountDTO account = getAccountxVervose(accountId);
		User user = getUserVervose(account.getUserId());

		AccountUserResponseDTO accountUserResponseDTO = new AccountUserResponseDTO(account, user);
		if (RequestInsightCollector.getRequestInsights() != null
				&& RequestInsightCollector.isVerbose()) {
			accountUserResponseDTO.setRequestInsignts(RequestInsightCollector.getRequestInsights());
		}
		return accountUserResponseDTO;
	}
	/**
	 * put entity
	 */
	/*
	 * public void putEntity(){ System.out.println("Begin /PUT request!"); String
	 * putUrl = "http://localhost:8080/put/2"; Customer puttCustomer = new
	 * Customer("Bush", 23); restTemplate.put(putUrl, puttCustomer); }
	 */

	/**
	 * delete entity
	 */
	/*
	 * public void deleteEntity(){ System.out.println("Begin /DELETE request!");
	 * String deleteUl = "http://localhost:8080/delete/1";
	 * restTemplate.delete(deleteUl); }
	 */
}
