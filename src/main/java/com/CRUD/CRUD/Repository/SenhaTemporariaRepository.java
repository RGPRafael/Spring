/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CRUD.CRUD.Repository;

import com.CRUD.CRUD.models.SenhaTemporaria;
import com.CRUD.CRUD.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rafael
 */
@Repository
public interface SenhaTemporariaRepository extends JpaRepository<SenhaTemporaria, Long>  {
    
    SenhaTemporaria findByEmail(String email);
    
    SenhaTemporaria  findByEmailAndSenhatemporaria(String email, String senhatemporaria) ;

    
    
    
}
