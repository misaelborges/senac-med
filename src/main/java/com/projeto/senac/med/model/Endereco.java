/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.model;

import java.util.Objects;

/**
 *
 * @author domjo
 */
public class Endereco {
    private Long id;
    private String Logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private Long idmedico;
    private Long idpaciente;

    public Endereco(String Logradouro, int numero, String bairro, String cidade, String estado, String cep, Long idmedico, Long idpaciente) {
        this.Logradouro = Logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.idmedico = idmedico;
        this.idpaciente = idpaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Long idmedico) {
        this.idmedico = idmedico;
    }

    public Long getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Long idpaciente) {
        this.idpaciente = idpaciente;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", Logradouro=" + Logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", idmedico=" + idmedico + ", idpaciente=" + idpaciente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Endereco other = (Endereco) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
