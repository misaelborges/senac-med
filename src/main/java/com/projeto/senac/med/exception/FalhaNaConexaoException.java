/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.exception;

/**
 *
 * @author mizael
 */
public class FalhaNaConexaoException extends NegocioException{
    
    public FalhaNaConexaoException(String message) {
        super(message);
    }

    public FalhaNaConexaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
