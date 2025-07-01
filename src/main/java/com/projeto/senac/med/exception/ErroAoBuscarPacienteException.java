/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.exception;

/**
 *
 * @author mizael
 */
public class ErroAoBuscarPacienteException extends NegocioException{

    public ErroAoBuscarPacienteException(String message) {
        super(message);
    }

    public ErroAoBuscarPacienteException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
