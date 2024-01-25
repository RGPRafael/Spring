/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import java.util.Date;

/**
 *
 * @author rafae
 */
@Entity(name = "SenhaTemporaria")
@Table(name = "SenhaTemporaria")
public class SenhaTemporaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String email;
    //@Temporal(TemporalType.TIMESTAMP)
    private String    expires;
    private String senhatemporaria; 

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String    getExpires() {
        return expires;
    }

    public void setExpires(String    expires) {
        this.expires = expires;
    }

    public String getSenhatemporaria() {
        return senhatemporaria;
    }

    public void setSenhatemporaria(String senhatemporaria) {
        this.senhatemporaria = senhatemporaria;
    }
    
    
    public SenhaTemporaria(){
        
    }
    
    public SenhaTemporaria(String email, String senhatemporaria, String    expires ) {
        this.email = email;
        this.senhatemporaria= senhatemporaria;
        this.expires = expires;
        
    }
   
}
