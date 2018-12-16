package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.AccountEvent;
import com.rollingstone.spring.model.AccountDTO;

@Component
public class AccountEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(AccountEvent accountEvent) {
		log.info("Received Account Event : "+accountEvent.getEventType());
		AccountDTO dto = accountEvent.getAccount();
		if (dto == null) {
			log.info("DTO is null");
		}
		else {
			log.info("DTO is not null");
			if (dto.getAccountName() == null) {
				log.info("getAccountName is not null");
			}
			if (dto.getAccountNumber() == null) {
				log.info("getAccountNumber is not null");
			}
			
			if (dto.getFirstName() == null) {
				log.info("getFirstName is not null");
			}
			
			if (dto.getLastName() == null) {
				log.info("getLastName is not null");
			}
			
			if (dto.getMemberType() == null) {
				log.info("getMemberType is not null");
			}
			
			if (dto.getRegistrationDate() == null) {
				log.info("getRegistrationDate is not null");
			}
			
			if (dto.getSex() == null) {
				log.info("sex is not null");
			}
			
			if (new Long(dto.getUserId()) == null) {
				log.info("user id is not null");
			}
			
			if (dto.getUserName() == null) {
				log.info("getUserName is not null");
			}
		}
		log.info("Received Account From Account Event :"+accountEvent.getAccount().toString());
	}
}
