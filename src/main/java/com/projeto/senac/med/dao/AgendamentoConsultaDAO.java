/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.dao;

import com.projeto.senac.med.exception.ErroAoListarConsultasException;
import com.projeto.senac.med.exception.ErroAoSalvarAgendamentoException;
import java.sql.Connection;
import com.projeto.senac.med.model.AgendamentoConsulta;
import com.projeto.senac.med.model.AgendamentoConsultaDTO;
import com.projeto.senac.med.model.Paciente;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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
            connection.commit();
            stmt.close();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new ErroAoSalvarAgendamentoException("Erro ao salvar o Agendamento: ", e);
        }
    }

    public void Atualizar(AgendamentoConsulta agendamentoConsulta) {
        String sql = """
                     UPDATE consulta set data_ag = ?, hora = ?, status_ag = ? where id = ? ;
                     """;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(agendamentoConsulta.getData()));
            stmt.setTime(2, Time.valueOf(agendamentoConsulta.getHora()));
            stmt.setString(3, agendamentoConsulta.getStatus());
            stmt.setLong(4, agendamentoConsulta.getId());
            stmt.executeUpdate();
            connection.commit();
            stmt.close();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new ErroAoSalvarAgendamentoException("Erro ao salvar o Agendamento: ", e);
        }
    }

    public List<AgendamentoConsultaDTO> listar() throws Exception {

        List<AgendamentoConsultaDTO> list = new ArrayList<>();
        String sql = """
                    Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id,paciente.nome as paciente 
                    from consulta 
                    LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                    LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id;
                    """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultado.getLong("id"));

                Date dataSql = resultado.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultado.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultado.getString("status_ag"));
                consulta.setIdMedico(resultado.getLong("medico_id"));
                consulta.setNomeMedico(resultado.getString("medico"));
                consulta.setIdPaciente(resultado.getLong("paciente_id"));
                consulta.setNomePaciente(resultado.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new ErroAoListarConsultasException("Erro ao listar agendamento", e);
        }
        return list;
    }

    public List<AgendamentoConsultaDTO> listar(long idConsulta) throws Exception {

        List<AgendamentoConsultaDTO> list = new ArrayList<>();
        String sql = """
                    Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id,paciente.nome as paciente 
                    from consulta 
                    LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                    LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id
                    WHERE consulta.id = idConsulta;
                    """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultado.getLong("id"));

                Date dataSql = resultado.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultado.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultado.getString("status_ag"));
                consulta.setIdMedico(resultado.getLong("medico_id"));
                consulta.setNomeMedico(resultado.getString("medico"));
                consulta.setIdPaciente(resultado.getLong("paciente_id"));
                consulta.setNomePaciente(resultado.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new ErroAoListarConsultasException("Erro ao listar agendamento", e);
        }
        return list;
    }

    public List<AgendamentoConsultaDTO> listar(LocalDate date) throws Exception {

        List<AgendamentoConsultaDTO> list = new ArrayList<>();
        String sql = """
                    Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id,paciente.nome as paciente 
                    from consulta 
                    LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                    LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id
                    WHERE data_ag = ?;
                    """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(date));

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultado.getLong("id"));

                Date dataSql = resultado.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultado.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultado.getString("status_ag"));
                consulta.setIdMedico(resultado.getLong("medico_id"));
                consulta.setNomeMedico(resultado.getString("medico"));
                consulta.setIdPaciente(resultado.getLong("paciente_id"));
                consulta.setNomePaciente(resultado.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new ErroAoListarConsultasException("Erro ao listar agendamento", e);
        }
        return list;
    }

    public List<AgendamentoConsultaDTO> buscarPorNome(String nome) {
        String sql = """
                        Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id,paciente.nome as paciente 
                        from consulta 
                        LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                        LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id
                        WHERE paciente.nome LIKE ?;
                     """;

        List<AgendamentoConsultaDTO> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultSet.getLong("id"));

                Date dataSql = resultSet.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultSet.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultSet.getString("status_ag"));
                consulta.setIdMedico(resultSet.getLong("medico_id"));
                consulta.setNomeMedico(resultSet.getString("medico"));
                consulta.setIdPaciente(resultSet.getLong("paciente_id"));
                consulta.setNomePaciente(resultSet.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new ErroAoListarConsultasException("Erro ao listar agendamento", e);
        }
        return list;
    }

    public List<AgendamentoConsultaDTO> listarPorPaciente(Long idPaciente) throws Exception {

        List<AgendamentoConsultaDTO> list = new ArrayList<>();
        String sql = """
                    Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id, paciente.nome as paciente 
                    from consulta 
                    LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                    LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id
                    Where paciente.id = ? ;
                    """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idPaciente);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultado.getLong("id"));

                Date dataSql = resultado.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultado.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultado.getString("status_ag"));
                consulta.setIdMedico(resultado.getLong("medico_id"));
                consulta.setNomeMedico(resultado.getString("medico"));
                consulta.setIdPaciente(resultado.getLong("paciente_id"));
                consulta.setNomePaciente(resultado.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar agendamento", e);
        }
        return list;
    }

    public List<AgendamentoConsultaDTO> listarPorMedico(Long idMedico) throws Exception {

        List<AgendamentoConsultaDTO> list = new ArrayList<>();
        String sql = """
                    Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id, paciente.nome as paciente 
                    from consulta 
                    LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                    LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id
                    Where medico.id = ? ;
                    """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idMedico);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultado.getLong("id"));

                Date dataSql = resultado.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultado.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultado.getString("status_ag"));
                consulta.setIdMedico(resultado.getLong("medico_id"));
                consulta.setNomeMedico(resultado.getString("medico"));
                consulta.setIdPaciente(resultado.getLong("paciente_id"));
                consulta.setNomePaciente(resultado.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar agendamento", e);
        }
        return list;
    }

    public List<AgendamentoConsultaDTO> listarPorPaciente_Medico(Long idPaciente, Long idMedico) throws Exception {

        List<AgendamentoConsultaDTO> list = new ArrayList<>();
        String sql = """
                    Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id, paciente.nome as paciente 
                    from consulta 
                    LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                    LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id
                    Where paciente.id = ? and medico.id = ?;
                    """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idPaciente);
            stmt.setLong(2, idMedico);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultado.getLong("id"));

                Date dataSql = resultado.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultado.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultado.getString("status_ag"));
                consulta.setIdMedico(resultado.getLong("medico_id"));
                consulta.setNomeMedico(resultado.getString("medico"));
                consulta.setIdPaciente(resultado.getLong("paciente_id"));
                consulta.setNomePaciente(resultado.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar agendamento", e);
        }
        return list;
    }

    public List<AgendamentoConsultaDTO> listarPorPaciente_Medico_Data(Long idPaciente, Long idMedico, LocalDate data) throws Exception {

        List<AgendamentoConsultaDTO> list = new ArrayList<>();
        String sql = """
                    Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id, paciente.nome as paciente 
                    from consulta 
                    LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                    LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id
                    Where paciente.id = ? and medico.id = ? and consulta.data_ag = ?;
                    """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idPaciente);
            stmt.setLong(2, idMedico);
            stmt.setDate(3, java.sql.Date.valueOf(data));
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultado.getLong("id"));

                Date dataSql = resultado.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultado.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultado.getString("status_ag"));
                consulta.setIdMedico(resultado.getLong("medico_id"));
                consulta.setNomeMedico(resultado.getString("medico"));
                consulta.setIdPaciente(resultado.getLong("paciente_id"));
                consulta.setNomePaciente(resultado.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar agendamento", e);
        }
        return list;
    }

    public List<AgendamentoConsultaDTO> listarPorPaciente_Data(Long idPaciente, LocalDate data) throws Exception {

        List<AgendamentoConsultaDTO> list = new ArrayList<>();
        String sql = """
                    Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id, paciente.nome as paciente 
                    from consulta 
                    LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                    LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id
                    Where paciente.id = ? and consulta.data_ag = ?;
                    """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idPaciente);
            stmt.setDate(2, java.sql.Date.valueOf(data));
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultado.getLong("id"));

                Date dataSql = resultado.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultado.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultado.getString("status_ag"));
                consulta.setIdMedico(resultado.getLong("medico_id"));
                consulta.setNomeMedico(resultado.getString("medico"));
                consulta.setIdPaciente(resultado.getLong("paciente_id"));
                consulta.setNomePaciente(resultado.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar agendamento", e);
        }
        return list;
    }

    public List<AgendamentoConsultaDTO> listarPorMedico_Data(Long idMedico, LocalDate data) throws Exception {

        List<AgendamentoConsultaDTO> list = new ArrayList<>();
        String sql = """
                    Select consulta.id, consulta.data_ag, consulta.hora, consulta.status_ag, medico.id as medico_id, medico.nome as medico, paciente.id as  paciente_id, paciente.nome as paciente 
                    from consulta 
                    LEFT OUTER JOIN  medico on consulta.id_medico = medico.id
                    LEFT OUTER JOIN  paciente on consulta.id_paciente = paciente.id
                    Where medico.id = ? and consulta.data_ag = ?;
                    """;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idMedico);
            stmt.setDate(2, java.sql.Date.valueOf(data));
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                AgendamentoConsultaDTO consulta = new AgendamentoConsultaDTO();
                consulta.setId(resultado.getLong("id"));

                Date dataSql = resultado.getDate("data_ag");
                if (dataSql != null) {
                    consulta.setData(dataSql.toLocalDate());
                } else {
                    consulta.setData(LocalDate.MAX);
                }

                Time horaSql = resultado.getTime("hora");
                if (horaSql != null) {
                    consulta.setHora(horaSql.toLocalTime());
                } else {
                    consulta.setHora(LocalTime.NOON);
                }
                consulta.setStatus(resultado.getString("status_ag"));
                consulta.setIdMedico(resultado.getLong("medico_id"));
                consulta.setNomeMedico(resultado.getString("medico"));
                consulta.setIdPaciente(resultado.getLong("paciente_id"));
                consulta.setNomePaciente(resultado.getString("paciente"));
                list.add(consulta);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar agendamento", e);
        }
        return list;
    }

}
