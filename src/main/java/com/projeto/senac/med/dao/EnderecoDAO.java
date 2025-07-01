/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.dao;

import com.projeto.senac.med.exception.ErroAoSalvarEnderecoException;
import com.projeto.senac.med.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mizael
 */
public class EnderecoDAO {

    private final Connection connection;

    public EnderecoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Endereco endereco) {
        String sql = """
                        INSERT INTO endereco(logradouro, numero, bairro, cidade, estado, cep, id_medico, id_paciente)
                        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                    """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, endereco.getLogradouro());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setString(6, endereco.getCep());

            if (endereco.getIdmedico() != null) {
                stmt.setLong(7, endereco.getIdmedico());
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER);
            }

            if (endereco.getIdpaciente() != null) {
                stmt.setLong(8, endereco.getIdpaciente());
            } else {
                stmt.setNull(8, java.sql.Types.INTEGER);
            }

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new ErroAoSalvarEnderecoException("Erro ao salvar o endereço: ", e);
        }
    }

}
