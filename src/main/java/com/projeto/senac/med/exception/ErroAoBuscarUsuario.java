/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.exception;

/**
 *
 * @author mizael
 */
public class ErroAoBuscarUsuario extends NegocioException{

    public ErroAoBuscarUsuario(String message) {
        super(message);
    }

    public ErroAoBuscarUsuario(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
