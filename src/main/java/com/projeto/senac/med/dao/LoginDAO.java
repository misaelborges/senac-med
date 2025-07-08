/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.dao;

import com.projeto.senac.med.exception.ErroAoBuscarUsuario;
import com.projeto.senac.med.exception.ErroAobuscarLoginException;
import com.projeto.senac.med.util.Conexao;
import com.projeto.senac.med.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murialdo
 */
public class LoginDAO {

    private final Connection connection;

    public LoginDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean buscar(Login login) throws Exception {
        Login retornoLogin = new Login();
        String sql = "Select * from usuario where login = ? and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login.getLogin());
        statement.setString(2, login.getSenha());

        ResultSet resultado = statement.executeQuery();

        if (resultado.next()) {
            return true;
        } else {
            return false;
        }
    }

    public String buscarSenhaCriptografada(String login) {
        String sql = "SELECT senha FROM usuario WHERE login = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("senha");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario não encontra");
                throw new ErroAoBuscarUsuario("Usuário não encontrado: " + login);
            }
        } catch (SQLException e) {
            throw new ErroAobuscarLoginException("Erro ao buscar login no banco", e);
        }
    }

}
