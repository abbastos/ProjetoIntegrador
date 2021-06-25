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

        String sql = "INSERT INTO  produtos (cod_produto,descricao, categoria, marca, "
                + "modelo, origem, prc_compra, prc_venda,lmt_estoque,estoque) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = ConectaBancoDados.getPreparedStatement(sql);

        try {
            pst.setString(1, obj.getProduto());
            pst.setString(2, obj.getDescricao());
            pst.setString(3, obj.getCategoria());
            pst.setString(4, obj.getMarca());
            pst.setString(5, obj.getModelo());
            pst.setString(6, obj.getOrigem());
            pst.setDouble(7, obj.getPrcCompra());
            pst.setDouble(8, obj.getPrcVenda());
            pst.setInt(9, obj.getLmtestoque());
            pst.setInt(10, obj.getEstoque());

            Integer resultado = pst.executeUpdate();
            if (resultado > 0) {
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

    public List<Produto> Listar() throws ClassNotFoundException, SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "select cod_produto, descricao, estoque, prc_compra, prc_venda from produtos";
        PreparedStatement psm = ConectaBancoDados.getPreparedStatement(sql);
        try {
            ResultSet resultado = psm.executeQuery();

            while (resultado.next()) {
                Produto obj = new Produto();
                obj.setProduto(resultado.getString("cod_produto"));
                obj.setDescricao(resultado.getString("descricao"));
                obj.setEstoque(resultado.getInt("estoque"));
                obj.setPrcCompra(resultado.getDouble("prc_compra"));
                obj.setPrcVenda(resultado.getDouble("prc_venda"));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao acessar banco: " + ex.getMessage().toLowerCase());
            lista = null;
        }
        return lista;
    }

}
