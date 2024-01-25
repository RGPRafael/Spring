/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author rafae
 */
public class MudarSenha {
    
    
    private String email;
    private String senha;
    private String senhanova;

    
    @JsonProperty("novasenhadenovo")
    public String getSenha() {
        return senha;
    }

    @JsonProperty("novasenhadenovo")
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }
    
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

      @JsonProperty("novasenha")
    public String getSenhanova() {
        return senhanova;
    }

    @JsonProperty("novasenha")
    public void setSenhanova(String senhanova) {
        this.senhanova = senhanova;
    }
    
    
    
}
