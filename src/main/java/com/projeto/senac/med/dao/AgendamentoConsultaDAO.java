/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.dao;

import com.projeto.senac.med.exception.ErroAoSalvarAgendamentoException;
import java.sql.Connection;
import com.projeto.senac.med.model.AgendamentoConsulta;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Murialdo
 */
public class AgendamentoConsultaDAO {

    private final Connection connection;

    public AgendamentoConsultaDAO(Connection connection) {
        this.connection = connection;
    }

    public void Salva(AgendamentoConsulta agendamentoConsulta) {
        String sql = """
                    INSERT INTO 
                    consulta (data_ag, hora, status_ag, id_medico, id_paciente)
                    VALUES(?, ?, ?, ?, ?)
                    """;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(agendamentoConsulta.getData()));
            stmt.setTime(2, Time.valueOf(agendamentoConsulta.getHora()));
            stmt.setString(3, agendamentoConsulta.getStatus());

            if (agendamentoConsulta.getIdMedico() != null) {
                stmt.setLong(4, agendamentoConsulta.getIdMedico());
            } else {
                stmt.setNull(4, java.sql.Types.BIGINT);
            }

            if (agendamentoConsulta.getIdPaciente() != null) {
                stmt.setLong(5, agendamentoConsulta.getIdPaciente());
            } else {
                stmt.setNull(5, java.sql.Types.BIGINT);
            }
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            throw new ErroAoSalvarAgendamentoException("Erro ao salvar o Agendamento: ", e);
        }
    }
    
    
      public List<AgendamentoConsulta> listar() throws Exception {

        List<AgendamentoConsulta> list = new ArrayList<>();
        String sql = "SELECT * FROM consulta";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsulta consulta = new AgendamentoConsulta();
                consulta.setId(resultado.getLong("id"));
             
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar agendamento", e);
        }
        return list;
    }          
    
}
