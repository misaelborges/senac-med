/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author MURI
 */
public class AgendamentoConsulta {

    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private String status = AgendamentoStatus.AGENDADO.getStatus();
    private Long idMedico;
    private Long idPaciente;

    public AgendamentoConsulta() {
    }

    public AgendamentoConsulta(LocalDate data, LocalTime hora, Long idMedico, Long idPaciente) {
        this.data = data;
        this.hora = hora;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AgendamentoConsulta other = (AgendamentoConsulta) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
    
}
