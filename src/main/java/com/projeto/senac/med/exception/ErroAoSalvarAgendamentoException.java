/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.exception;

/**
 *
 * @author Murialdo
 */
public class ErroAoSalvarAgendamentoException extends NegocioException{
    
     public ErroAoSalvarAgendamentoException(String message) {
        super(message);
    }

    public ErroAoSalvarAgendamentoException(String message, Throwable cause) {
        super(message, cause);
    }

}
