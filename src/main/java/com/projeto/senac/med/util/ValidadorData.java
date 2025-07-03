/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senac.med.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Murialdo
 */
public class ValidadorData {
    
    public static boolean dataValida(String dataStr) {
        if (dataStr == null || dataStr.trim().isEmpty()) {
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(dataStr.trim(), formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
