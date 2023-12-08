/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author rafael
 */
@Entity(name = "Hunters")
@Table(name = "Hunters")
public class Hunters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String nome;
    @Column(name = "descrição")
    private String descricao;
    private LocalDateTime cadastro;
    private Integer estrelas;
    private Integer provasfeitas;
    private Boolean temlicenca;
    @Enumerated(EnumType.STRING)
    private Nen nem;
    @Embedded
    private LocalizacaoAtual localizacaoatual;
    private Boolean ativo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDateTime cadastro) {
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
    
    public void setlocalizacaoatuao(LocalizacaoAtual localizacaoatual) {
    if (localizacaoatual != null) {
        this.localizacaoatual = localizacaoatual;
    }
}
    public LocalizacaoAtual getlocalizacaoatuao(){
         return localizacaoatual;
    }
    
    public void excluir(){
        this.ativo = false;
    }
    public void ativar(){
        this.ativo = true;
    }
    public Hunters(String nome, String descrição, Integer estrelas, Integer provasfeitas,   Boolean temlicenca, Nen nem , 
            LocalizacaoAtual localizacaoAtual ) {
        this.nome = nome;
        this.descricao= descrição;
        this.cadastro= LocalDateTime.now();
        this.estrelas = estrelas;
        this.provasfeitas = provasfeitas;
        this.temlicenca = temlicenca;
        this.nem = nem;
        this.localizacaoatual = localizacaoAtual;

    }
    public Hunters() {
    // Default constructor
    }
    
    public Hunters(String nome, String descrição, Integer estrelas, Integer provasfeitas,   Boolean temlicenca, Nen nem ) {
        this.nome = nome;
        this.descricao= descrição;
        this.cadastro= LocalDateTime.now();
        this.estrelas = estrelas;
        this.provasfeitas = provasfeitas;
        this.temlicenca = temlicenca;
        this.nem = nem;
       

    }
}
