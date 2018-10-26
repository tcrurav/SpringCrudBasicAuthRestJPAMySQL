package com.tiburcio.people.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.tiburcio.people.entity.models.AppUser;

public interface IAppUserDao extends CrudRepository<AppUser, Long>{
	public AppUser findUserByUsername(String username);
}
