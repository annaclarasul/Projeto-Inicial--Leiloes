/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projeto_leiloes;

/**
 *
 * @author ferna
 */
public class Projeto_leiloes {

    public static void main(String[] args) {
        ProdutosDTO produto = new ProdutosDTO();
        produto.setNome("Nome do Produto");
        produto.setValor(100);

        ProdutosDAO produtoDAO = new ProdutosDAO();
        produtoDAO.save(produto);

        System.out.println("Produto salvo com sucesso!");
    }
}
