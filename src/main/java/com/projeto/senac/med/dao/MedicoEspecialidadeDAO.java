/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.dao;

import com.projeto.senac.med.exception.ErroAoSalvarMedicoException;
import com.projeto.senac.med.model.MedicoEspecialidade;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mizael
 */
public class MedicoEspecialidadeDAO {

    private final Connection connection;

    public MedicoEspecialidadeDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(MedicoEspecialidade medicoEspecialidade) {
        String sql = """
                    INSERT INTO medico_especialidades(id_medico, id_especialidade)
                    VALUES(?, ?)
                    """;
        
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setLong(1, medicoEspecialidade.getIdMedico());
            stmt.setLong(2, medicoEspecialidade.getIdEspecialidade());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new ErroAoSalvarMedicoException("Erro ao salvar medico especialidade: ", e);
        }
    }

}
