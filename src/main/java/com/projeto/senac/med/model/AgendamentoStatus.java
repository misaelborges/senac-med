/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.projeto.senac.med.model;

/**
 *
 * @author MURI
 */
public enum AgendamentoStatus {
    AGENDADO("Agendado"),
    REALIZADO("Realizado"),
    CANCELADO("Cancelado");
    
    private final String status;
    
    private AgendamentoStatus (String status){
        this.status = status;
    }
   
    public String getStatus(){
        return status;
    }
    
}
