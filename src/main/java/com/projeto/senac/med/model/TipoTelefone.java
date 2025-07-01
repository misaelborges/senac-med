/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.model;

/**
 *
 * @author mizael
 */
public enum TipoTelefone {
    
    CELULAR("Celular"),
    FIXO("Fixo"),
    WHATSAPP("WhatsApp");
    
    private final String tipo;

    private TipoTelefone(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
