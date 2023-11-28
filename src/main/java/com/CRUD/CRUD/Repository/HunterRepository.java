/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.Repository;

import com.CRUD.CRUD.models.Hunters;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * 
 * 
 * Now we can use JpaRepository’s 
 * methods: save(), findOne(), findById(), 
 * findAll(), count(), delete(), deleteById()… without 
 * implementing these methods.
 * @author rafael
 */
public interface HunterRepository extends JpaRepository<Hunters, Long> {
    
    Page<Hunters> findAllByAtivoTrue(Pageable paginacao);
        
    

  
}
