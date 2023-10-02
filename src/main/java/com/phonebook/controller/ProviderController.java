package com.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.entity.ContactDetails;
import com.phonebook.service.PhoneBookService;

@RestController
public class ProviderController {

	@Autowired
	private PhoneBookService service;

	@PostMapping(value ="/savecontact", consumes = { "application/json" })
	public ResponseEntity<String> createContact(@RequestBody ContactDetails details) {

		String status = service.upsert(details);

		return new ResponseEntity<>(status, HttpStatus.CREATED);

	}

	@GetMapping(value="/getcontact/{id}",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ContactDetails> getContact(@PathVariable Integer id) {

		ContactDetails contact = service.getById(id);
		
	

		return new ResponseEntity<>(contact, HttpStatus.OK);
		}
	

	@GetMapping(value ="/getAllcontacts",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<ContactDetails>> getAllContact() {

		List<ContactDetails> allContacts = service.getAllContacts();
		return new ResponseEntity<>(allContacts, HttpStatus.OK);

	}

	
	@PutMapping("/updatecontact/{id}")
	public ResponseEntity<String> updateContact(@RequestBody ContactDetails details) {

		String status = service.upsert(details);

		return new ResponseEntity<>(status, HttpStatus.CREATED);

	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer id) {

		String status = service.deletById(id);

		return new ResponseEntity<>(status, HttpStatus.OK);

	}

}
