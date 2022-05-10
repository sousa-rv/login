package com.vini.sousa.login.repository;

import com.vini.sousa.login.entity.LoginEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends CrudRepository<LoginEntity, String> {

    public Optional<LoginEntity> findByUsername(String username);
}
