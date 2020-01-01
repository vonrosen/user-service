package org.hunter.userservice.repository;

import java.util.UUID;

import org.hunter.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UUID> { }
