package com.phonebook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonebook.entity.ContactDetails;

public interface PhoneBookRepository  extends JpaRepository<ContactDetails,Integer>{

}
