/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.yosra.Repository;

import com.example.yosra.Model.User;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TPC
 */
public interface UserRepository extends CrudRepository<User, Long> {
    
	@Query("SELECT u FROM User u WHERE u.email = ?1 and u.mdp= ?2  ")
	List<User> findUser(String email ,String pass ); 	
	
}
