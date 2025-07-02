/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.dao;

import com.projeto.senac.med.exception.ErroAoBuscarPacienteException;
import com.projeto.senac.med.exception.ErroAoSalvarPacienteException;
import com.projeto.senac.med.model.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mizael
 */
public class PacienteDAO {

    private final Connection connection;

    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Paciente paciente) {
        String sql = """
                    INSERT INTO 
                    paciente(nome, cpf, data_nascimento)
                    VALUES(?, ?, ?)
                    """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setDate(3, Date.valueOf(paciente.getDataNascimento()));

            stmt.executeUpdate();

            Long pacienteId = buscarId(paciente);
            paciente.setId(pacienteId);

        } catch (Exception e) {
            throw new ErroAoSalvarPacienteException("Erro ao salvar o paciente: ", e);
        }
    }

    public Long buscarId(Paciente paciente) {
        String sql = """
                    SELECT id FROM paciente 
                    WHERE nome = ? AND cpf = ? AND data_nascimento = ?
                    """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setDate(3, Date.valueOf(paciente.getDataNascimento()));

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                paciente.setId(resultSet.getLong("id"));
            }

        } catch (Exception e) {
            throw new ErroAoBuscarPacienteException("Erro ao buscar o paciente: ", e);
        }

        return paciente.getId();

    }

    public List<Paciente> listar(String nome) throws Exception {

        List<Paciente> list = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE nome LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);


            stmt.setString(1, "%" + nome + "%");
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(resultado.getLong("id"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setCpf(resultado.getString("cpf"));
                list.add(paciente);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar pacientes", e);

        }

        return list;
    }
}
