package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.models.Conta;

public class ContaDAO extends DataBaseDAO{

	public ContaDAO() throws Exception {
		super();
	}

	
	public void createConta(Conta conta) throws SQLException{
		if(conta == null){
			throw new SQLException("Conta não pode ser nulo");
		}
		String INSERT_SQL = "INSERT INTO CONTAS(NUMERO,AGENCIA,SALDO,CLIENTE) VALUES(?,?,?,?) ";
		
		PreparedStatement pstmt = null;
		try{
			pstmt = connection.prepareStatement(INSERT_SQL);
			pstmt.setInt(1, conta.getNumero());
			pstmt.setInt(2, conta.getAgencia());
			pstmt.setFloat(3, conta.getSaldo());
			pstmt.setInt(4, conta.getCliente());
			
			int rows = pstmt.executeUpdate();
			
			if(rows > 0){
				super.commit();
				System.out.println("Conta inserida com sucesso!");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não foi possível criar essa conta!");
			try{
				super.rollback();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}finally {
			try{
				if(pstmt != null){
					pstmt.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Conta retriveConta(int codConta) throws SQLException{
		if(codConta <=0){
			throw new SQLException("Número da conta tem que ser maior que 0");
		}
		String SELECT_SQL = "SELECT * FROM CONTAS WHERE numero = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Conta conta;
		try{
			pstmt = connection.prepareStatement(SELECT_SQL);
			pstmt.setInt(1, codConta);
			rs = pstmt.executeQuery();
			if(rs.next()){
				conta = new Conta(rs.getInt("numero"),rs.getInt("agencia"),rs.getFloat("saldo"),rs.getInt("Cliente"));
			}else{
				throw new SQLException("Nenhuma conta encontrada");
			}
		}finally {
			
		}
			try{
				if(pstmt != null){
					pstmt.close();
				}
				if(rs != null){
					rs.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return conta;
	}
	
	public void updateConta(Conta conta) throws SQLException{
		if(conta == null){
			throw new SQLException("O parametro conta está nulo!");
		}
		String UPDATE_SQL = "UPDATE CONTAS SET agencia=?, saldo=?, cliente=? WHERE numero = ? ";
		PreparedStatement pstmt = null;
		try{
			pstmt = connection.prepareStatement(UPDATE_SQL);
			pstmt.setInt(1, conta.getAgencia());
			pstmt.setFloat(2, conta.getSaldo());
			pstmt.setInt(3, conta.getCliente());
			pstmt.setInt(4, conta.getNumero());
			int rows = pstmt.executeUpdate();
			if(rows > 0){
				super.commit();
				System.out.println("Conta atualizada!");
			}
		}catch (Exception e) {
			try{
				System.out.println("Não atualizado!");
				super.rollback();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}finally {
			//fechar recursos abertos anteriormente
			try{
				if(pstmt != null){
					pstmt.close();
				}
			}catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}
	
	public void deleteConta(int conta) throws Exception{
		if(conta <= 0){
			throw new SQLException("O número da conta não pode ser menor que 0");
		}
		String DELETE_SQL = "DELETE FROM CONTAS WHERE numero = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = connection.prepareStatement(DELETE_SQL);
			pstmt.setInt(1, conta);
			System.out.println("Excluindo Conta!");
			int rows = pstmt.executeUpdate();
			if(rows >0){
				super.commit();
				System.out.println(conta + " Excluída!");
			}
		}catch (SQLException e) {
			try{
				System.out.println("Código não excluido!");
				super.rollback();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
			throw new Exception("Impossível excluir! Causa: " + e);
		}catch (RuntimeException e) {
			try{
				System.out.println(conta+ " Não excluida!");
				connection.rollback();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
			throw new Exception("Impossível excluir! Causa: " + e );
		}finally {
			try{
				if( pstmt != null){
					pstmt.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
