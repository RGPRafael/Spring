/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.Service;

import com.CRUD.CRUD.Repository.SenhaTemporariaRepository;
import com.CRUD.CRUD.models.SenhaTemporaria;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafae
 */
@Service
public class SenhaTemporariaService {
    
    @Autowired
    private SenhaTemporariaRepository senhaTemporariaRepository ;
    
    
    private final Long expiryInterval = 5L * 60 * 1000; // 5 minutes;
    
    
    
    
    public SenhaTemporaria returnOneTimePassword(String email) {
        
        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(33, 45).build();
        String senhatemp =  pwdGenerator.generate(32);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String currentTimePlusExpires ;
        long totaltimepassword = dt.getTime() + expiryInterval; 
        
        java.util.Date new_date = new java.util.Date(totaltimepassword);
        currentTimePlusExpires = sdf.format(new_date);
        
        SenhaTemporaria senhatemporaria = new SenhaTemporaria(email, senhatemp, currentTimePlusExpires );
       

        SenhaTemporaria save = senhaTemporariaRepository.save(senhatemporaria);

        return senhatemporaria;
    }
    
    
    public String checarSenhaProvisoria(String email, String senha) throws ParseException{
        
        SenhaTemporaria findByEmailAndSenha = senhaTemporariaRepository.findByEmailAndSenhatemporaria(email, senha);
        String expires = findByEmailAndSenha.getExpires();
        
        //Date expires = findByEmailAndSenha.getExpires();
        
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");      
        
        //Date parse = dateFormat.parse(expires);
        long time = dateFormat.parse(expires).getTime();
        
        
        Date actualdate = new java.util.Date(); // time is in different zone ?  
        if( Math.abs(time  - actualdate.getTime()) <  expiryInterval  &&
                 findByEmailAndSenha.getSenhatemporaria().equals(senha) ){
            return "OK";
            
        }
        else if( !findByEmailAndSenha.getSenhatemporaria().equals(senha) ) {
            return "Senha errada";
        }
        return "Senha expirou";
                
                
        
    }
    
    
    
    
}


/**************************************************************************
 * https://stackoverflow.com/questions/17305048/convert-date-string-with-time-to-long-date
 */
