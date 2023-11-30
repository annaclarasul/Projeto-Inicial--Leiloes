/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_leiloes;

import java.sql.Connection;

/**
 *
 * @author ferna
 */
public class conexao {

    public static Connection getConexao() {
        ProdutosDTO ProdutosDTO = new ProdutosDTO();

        try {
            if (ProdutosDTO.getNome().equals("") || ProdutosDTO.getValor().equals("")) {
                throw new Exception("Não deixar o campo vazio!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}