/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException; 


public class ProdutosDAO {
    
    Connection conn = new conectaDAO().connectDB();
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produtos){
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES" + "(?,?,?)";
        try{
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produtos.getNome());
            stmt.setInt(2, produtos.getValor());
            stmt.setString(3, produtos.getStatus());
            stmt.execute();
            System.out.println("Produto cadastrado!");
        }catch(SQLException e){
            System.out.println("Erro ao cadastrar produto. Tente novamente!");
            System.out.println("Erro: " + e.getMessage());
        }
        //conn = new conectaDAO().connectDB();
       
        
        
        //conn = new conectaDAO().connectDB();
        return true;
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

