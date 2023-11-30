/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_leiloes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class ProdutosDAO {
    
    private final Connection connection = conexao.getConexao();

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();



    public ArrayList<ProdutosDTO> listarProdutos() {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ProdutosDTO");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));
                ProdutosDTO.add(produto);
            }
            return listagem;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listagem;
    }

     void cadastrarProduto(ProdutosDTO produto) {
           try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO produto (nome) VALUES (?)");
            ps.setString(1, "nome");
            ps.setString(2, "valor");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
