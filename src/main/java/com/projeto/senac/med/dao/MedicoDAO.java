/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.dao;

import com.projeto.senac.med.exception.ErroAoBuscarMedicoException;
import com.projeto.senac.med.exception.ErroAoSalvarMedicoException;
import java.sql.Connection;
import com.projeto.senac.med.model.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mizael
 */
public class MedicoDAO {

    private final Connection connection;

    public MedicoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Medico medico) {

        String sql = """
                    INSERT INTO 
                    medico(nome, cpf, crm)
                    VALUES(?, ?, ?)
                    """;
        
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCpf());
            stmt.setString(3, medico.getCrm());
            
            stmt.executeUpdate();
            
            Long medicoId = buscarId(medico);
            medico.setId(medicoId);
            
        } catch (Exception e) {
            throw new ErroAoSalvarMedicoException("Erro ao salvar o medico: ", e);
        }
    }
    
        public Long buscarId(Medico medico) {
        String sql = """
                    SELECT id FROM medico 
                    WHERE nome = ? AND cpf = ? AND crm = ?
                    """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

             stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCpf());
            stmt.setString(3, medico.getCrm());

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) medico.setId(resultSet.getLong("id"));
            
        } catch (Exception e) {
            throw new ErroAoBuscarMedicoException("Erro ao buscar o medico : ", e);
        }
        
        return medico.getId();

    }

    public List<Medico> listar(String nome) throws Exception {

        List<Medico> list = new ArrayList<>();
        String sql = "SELECT * FROM medico WHERE nome LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Medico medico = new Medico();
                medico.setId(resultado.getLong("id"));
                medico.setNome(resultado.getString("nome"));
                medico.setCpf(resultado.getString("cpf"));
                medico.setCrm(resultado.getString("crm"));
                list.add(medico);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar pacientes", e);
        }
        return list;
    }        
}
