/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.projeto.senac.med.exception.FalhaNaConexaoException;

/**
 *
 * @author mizael
 */
public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/senacmed_db";
    private static final String USUARIO = "root";
    private static final String SENHA = "admin";
    
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new FalhaNaConexaoException("Erro ao conectar ao banco de dados", e);
        }
    }
}
