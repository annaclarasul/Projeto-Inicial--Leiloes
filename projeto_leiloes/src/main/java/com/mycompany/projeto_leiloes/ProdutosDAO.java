/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_leiloes;

import java.sql.Connection;
import java.sql.DriverManager;
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
  
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
   


    public ArrayList<ProdutosDTO> listarProdutos() {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ProdutosDTO");
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
    
    private Connection obterConexao() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "usuario", "senha");
    } catch (Exception e) {
        System.out.println("Erro ao obter conexão: " + e.getMessage());
        return null;
    }
}

private void fecharConexao(Connection connection) {
    try {
        if (connection != null) {
            connection.close();
        }
    } catch (Exception e) {
        System.out.println("Erro ao fechar conexão: " + e.getMessage());
    }
}

    public void cadastrarProduto(ProdutosDTO produto) {
    Connection connection = obterConexao();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)");
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setInt(2, produto.getValor());
        preparedStatement.setString(3, produto.getStatus());

        preparedStatement.executeUpdate();
        System.out.println("Produto cadastrado com sucesso!");
    } catch (Exception e) {
        System.out.println("Erro ao cadastrar produto: " + e.getMessage());
    } finally {
        fecharConexao(connection);
    }
}
   
     public void venderProduto(int id) {
    String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        connection = obterConexao();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    } catch (Exception e) {
        System.out.println("Erro ao vender produto: " + e.getMessage());
    } finally {
        fecharConexao(connection);
    }
     }
    
     public List<ProdutosDTO> listarProdutosVendidos() {
        List<ProdutosDTO> listaProdutos = listarProdutos();
        List<ProdutosDTO> produtosVendidos = new ArrayList<>();

        for (ProdutosDTO produto : listaProdutos) {
            if (produto.getStatus().equals("Vendido")) {
                produtosVendidos.add(produto);
            }
        }
        return produtosVendidos;
    }
  
}

