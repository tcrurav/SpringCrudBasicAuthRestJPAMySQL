package com.tiburcio.people.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.tiburcio.people.entity.models.PeopleUser;

public interface IPeopleUserDao extends CrudRepository<PeopleUser, Long>{
	public PeopleUser findUserByUsername(String username);
}
