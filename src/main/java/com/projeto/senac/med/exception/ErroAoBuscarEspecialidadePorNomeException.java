/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.exception;

/**
 *
 * @author mizael
 */
public class ErroAoBuscarEspecialidadePorNomeException extends NegocioException{

    public ErroAoBuscarEspecialidadePorNomeException(String message) {
        super(message);
    }

    public ErroAoBuscarEspecialidadePorNomeException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
