/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CRUD.CRUD.Repossitory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author rafael
 */

/*
usa por padrao o banco de dados embutido em memoria
isso pode falhar se vc nao colocar nas dependencias
a vantagem éque eh mais rapido
desvantagem eh um banco de dados distinto

usar o proprio banco de dados >
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)


usar outro database
fazer ouro databe usando um arquivo propriets ..falar para ele usar esse
@ActiveProfiles("test o ue eta depois do traço")
*/
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class HunterRepossitoryTest {
    
    @Test
    void teste1(){
        
    }
    
}
