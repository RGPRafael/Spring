/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.Repository;

import com.CRUD.CRUD.models.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rafael
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    
    Usuario  findByEmailAndSenha(String email, String senha) ;
    
    Usuario findByEmail(String email);
    
    
    
    
    
}
