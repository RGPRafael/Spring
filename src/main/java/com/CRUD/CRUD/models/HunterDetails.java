/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.models;

import java.time.LocalDate;

/**
 *
 * @author rafael
 */
public class HunterDetails {
    
   
    private Long Id;
    private String nome;
    private String descrição;
    private LocalDate cadastro;
    private Integer estrelas;
    private Integer provasfeitas;
    private Boolean temlicenca;
    private Nen nem;
    private String pais;
    private String continente;
    private Boolean localizaçãoconhecida ;
    //@Embedded
    //private Missoes misssoes;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public LocalDate getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }

    public Integer getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(Integer estrelas) {
        this.estrelas = estrelas;
    }

    public Integer getProvasfeitas() {
        return provasfeitas;
    }

    public void setProvasfeitas(Integer provasfeitas) {
        this.provasfeitas = provasfeitas;
    }

    public Boolean getTemlicenca() {
        return temlicenca;
    }

    public void setTemlicenca(Boolean temlicenca) {
        this.temlicenca = temlicenca;
    }

    public Nen getNem() {
        return nem;
    }

    public void setNem(Nen nem) {
        this.nem = nem;
    }
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

    public Boolean getLocalizaçãoconhecida() {
        return localizaçãoconhecida;
    }

    public void setLocalizaçãoconhecida(Boolean localizaçãoconhecida) {
        this.localizaçãoconhecida = localizaçãoconhecida;
    }
   
    
    
}
