/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.model;

/**
 *
 * @author mizael
 */

public class MedicoEspecialidade {
    private Long idMedico;
    private Long idEspecialidade;

    public MedicoEspecialidade() {
    }

    public MedicoEspecialidade(Long idMedico, Long idEspecialidade) {
        this.idMedico = idMedico;
        this.idEspecialidade = idEspecialidade;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
}

