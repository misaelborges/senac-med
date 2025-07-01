/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.dao;

import com.projeto.senac.med.exception.ErroAoSalvarTelefoeException;
import com.projeto.senac.med.model.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mizael
 */
public class TelefoneDAO {

    private final Connection connection;

    public TelefoneDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Telefone telefone) {
        String sql = """
                    INSERT INTO 
                    telefone(numero, tipo, id_medico, id_paciente)
                    VALUES(?, ?, ?, ?)
                    """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, telefone.getNumero());
            stmt.setString(2, telefone.getTipoTelefone());

            if (telefone.getIdMedico() != null) {
                stmt.setLong(3, telefone.getIdMedico());
            } else {
                stmt.setNull(3, java.sql.Types.BIGINT);

            }

            if (telefone.getIdPaciente() != null) {
                stmt.setLong(4, telefone.getIdPaciente());
            } else {
                stmt.setNull(4, java.sql.Types.BIGINT);
            }

            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            throw new ErroAoSalvarTelefoeException("Erro ao savat o relefone", e);
        }

    }

}
