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
import java.util.ArrayList;


public class ProdutosDAO {
    
    
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produtos){
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES" + "(?,?,?)";
        try{
            Connection conn = new conectaDAO().connectDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produtos.getNome());
            stmt.setInt(2, produtos.getValor());
            stmt.setString(3, produtos.getStatus());
            stmt.execute();
            System.out.println("Produto cadastrado!");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao cadastrar produto. Tente novamente!");
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
        //conn = new conectaDAO().connectDB();
       
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
         String sql = "SELECT * FROM produtos";
        ArrayList<ProdutosDTO> listagemProdutos = new ArrayList<>();
        try{
            Connection conn = new conectaDAO().connectDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutosDTO produtos = new ProdutosDTO();
                
                produtos.setId(rs.getInt("id"));
                produtos.setNome(rs.getString("nome"));
                produtos.setValor(rs.getInt("valor"));
                produtos.setStatus(rs.getString("status"));
                
                listagemProdutos.add(produtos);
                
        }
    }catch(SQLException e){
            System.out.println("Erro ao listar produtos: " + e.getMessage());
            
        }return listagemProdutos;
    }

     public void venderProdutos(int id){
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        
        try{
            
            Connection conn = new conectaDAO().connectDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1,id);
            stmt.executeUpdate();
            
         System.out.println("Status do produto " + id + " alterado para 'Vendido' com sucesso.");   
            
        }catch(SQLException e){
            System.out.println("Erro ao alterar status do produto: " + e.getMessage());
            
        }
    }
    
    

    public ArrayList<ProdutosDTO> listarProdutosVendidos(){
    
       String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
        ArrayList<ProdutosDTO> listagemProdutosVendidos = new ArrayList<>();
        
         try{
            Connection conn = new conectaDAO().connectDB();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
               while(rs.next()){
                ProdutosDTO produtos = new ProdutosDTO();
                
                produtos.setId(rs.getInt("id"));
                produtos.setNome(rs.getString("nome"));
                produtos.setValor(rs.getInt("valor"));
                produtos.setStatus(rs.getString("status"));
                
                listagemProdutosVendidos.add(produtos);
               }
         }catch(SQLException e){
            System.out.println("Erro ao listar produtos vendidos: " + e.getMessage()); 
         }return listagemProdutosVendidos;
        
    }

}
    
    
    
        


