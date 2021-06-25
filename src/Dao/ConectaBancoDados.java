/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author AdrianoBenelliBastos
 */
public class ConectaBancoDados {
    public static Connection ConectaBancoDados() throws ClassNotFoundException {
            try{
            Class.forName("org.postgresql.Driver");
            Connection conecta = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetoIntegrador","postgres","postgres");
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso");
            return conecta;
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Não conectou" + error);
            return null;
        }
    }
    public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException{
        try{
            return ConectaBancoDados().prepareStatement(sql);           
        } catch (SQLException e) {
            System.out.println("Erro de sql: " + e.getMessage());
        }
        return null;
    }
    
    
}
