/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.dao;

import com.projeto.senac.med.util.Conexao;
import com.projeto.senac.med.model.Especialidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Murialdo
 */
public class EspecialidadeDAO {

    private Connection conexaoDBMysql;

    public EspecialidadeDAO() {
        conexaoDBMysql = Conexao.conectar();
    }

    public void salvar(Especialidade especialidade) {
        try {
            String sql = "INSERT INTO especialidade (nome) VALUES (?)";
            PreparedStatement insert = conexaoDBMysql.prepareStatement(sql);
            insert.setString(1, especialidade.getNome());
            insert.execute();
            //conexaoDBMysql.commit();

        } catch (Exception e) {
            try {
                conexaoDBMysql.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public List<Especialidade> listar() throws Exception {

        List<Especialidade> lista = new ArrayList<Especialidade>();
        String sql = "Select * from especialidade";
        PreparedStatement statement = conexaoDBMysql.prepareStatement(sql);

        ResultSet resultado = statement.executeQuery();
        while (resultado.next()) {
            Especialidade especialidade = new Especialidade();
            especialidade.setId(resultado.getLong("id"));
            especialidade.setNome(resultado.getString("nome"));
            lista.add(especialidade);
        }
        return lista;
    }

    public Especialidade buscar(Long id) throws Exception {
        Especialidade especialidadeRetorno = new Especialidade();

        String sql = "Select * from especialidade where ID = " + id;
        PreparedStatement statement = conexaoDBMysql.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();

        while (resultado.next()) {
            especialidadeRetorno.setId(resultado.getLong("id"));
            especialidadeRetorno.setNome(resultado.getString("nome"));

        }

        return especialidadeRetorno;
    }

    public void atualizar(Especialidade especialidade) {
        try {
            String sql = "Update especialidade set nome = ? where ID = " + especialidade.getId();
            PreparedStatement statement = conexaoDBMysql.prepareStatement(sql);
            statement.setString(1, especialidade.getNome());
            statement.execute();
        } catch (Exception e) {
            try {
                conexaoDBMysql.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public void deletar(Long id) throws Exception {
        try {
            Especialidade especialidadeRetorno = new Especialidade();

            String sql = "Delete from especialidade where ID = " + id;
            PreparedStatement statement = conexaoDBMysql.prepareStatement(sql);
            statement.execute();

        } catch (Exception e) {
            try {
                conexaoDBMysql.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
