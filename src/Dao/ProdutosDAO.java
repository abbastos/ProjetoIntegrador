/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Produto;
import java.sql.*;
import java.util.*;

/**
 *
 * @author AdrianoBenelliBastos
 */
public class ProdutosDAO {

    public Boolean Cadastrar(Produto obj) throws ClassNotFoundException {
        Boolean retorno = false;

        String sql = "INSERT INTO  produtos (descricao, categoria, marca, "
                + "modelo, origem, prc_compra, prc_venda,lmt_estoque,estoque) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = ConectaBancoDados.getPreparedStatement(sql);
        
        try {
            pst.setString(1, obj.getDescricao());
            pst.setString(2, obj.getCategoria());
            pst.setString(3, obj.getMarca());
            pst.setString(4, obj.getModelo());
            pst.setString(5, obj.getOrigem());
            pst.setDouble(6, obj.getPrcCompra());
            pst.setDouble(7, obj.getPrcVenda());
            pst.setInt(8, obj.getLmtestoque());
            pst.setInt(9, obj.getEstoque());
            
            Integer resultado = pst.executeUpdate();
            if (resultado > 0){
                retorno = true;
            } else {
                retorno = false;
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Erro ao acessar banco: " + ex.getMessage().toLowerCase());
            return false;
        }
        
        return retorno;
    }
}
