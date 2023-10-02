package com.phonebook.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.phonebook.entity.ContactDetails;

@Component
public interface PhoneBookService {
	
	public String upsert (ContactDetails details);
	
	public ContactDetails getById(Integer id);
	
	public List <ContactDetails> getAllContacts();
	
	public String deletById(Integer id);

}
