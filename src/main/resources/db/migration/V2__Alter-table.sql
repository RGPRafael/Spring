/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  rafael
 * Created: 24 de nov. de 2023
 */


alter table Hunters add ativo tinyint;
update Hunters set ativo =1;
