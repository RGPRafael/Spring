/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author rafael
 */

@Embeddable
public class LocalizacaoAtual {
    
    private String pais;
    private String continente;
    @Column(name = "localizaçãoconhecida")
    private Boolean localizacaoconhecida ;
   

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public Boolean getLocalizacaoconhecida() {
        return localizacaoconhecida;
    }

    public void setLocalizacaoconhecida(Boolean localizaçãoconhecida) {
        this.localizacaoconhecida = localizaçãoconhecida;
    }
    
   
    
    
    
    
}
