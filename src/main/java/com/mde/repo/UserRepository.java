package com.mde.repo;

import org.springframework.data.repository.CrudRepository;

import com.mde.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}