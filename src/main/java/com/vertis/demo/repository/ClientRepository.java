/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.repository;

import com.vertis.demo.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author telfealr
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
