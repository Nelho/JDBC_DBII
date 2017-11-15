package br.com.junit;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.com.dao.AgenciaDAO;
import br.com.dao.ClienteDAO;
import br.com.dao.ContaDAO;
import br.com.models.Agencia;
import br.com.models.Cliente;
import br.com.models.Conta;

@FixMethodOrder(MethodSorters.JVM)
public class TesteJUnit_Cliente_Conta {
	
	private static AgenciaDAO agenciaDAO;
	private static ClienteDAO clienteDAO;
	private static ContaDAO contaDAO;
	
	@BeforeClass
	public static void inicialização(){
		try{
			agenciaDAO = new AgenciaDAO();
			clienteDAO = new ClienteDAO();
			contaDAO = new ContaDAO();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//######################  Cliente  ########################

	
	@Test
	public void createCliente() {
		Cliente cliente1 = new Cliente(1, "Sérgio", "sergio@gmail.com", "111.111", new java.sql.Date(System.currentTimeMillis()), "Rua da Vitoria");
		Cliente cliente2 = new Cliente(2, "Uélio", "uelio@gmail.com", "222.222", new java.sql.Date(System.currentTimeMillis()), "Conjunto");
		Cliente cliente3 = new Cliente(3, "Breba", "breba@gmail.com", "333.333", new java.sql.Date(System.currentTimeMillis()), "Rua da Aurora");
		try {
			clienteDAO.connect();
			clienteDAO.createCliente(cliente1);
			clienteDAO.createCliente(cliente2);
			clienteDAO.createCliente(cliente3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateCliente(){
		Cliente cliente2 = new Cliente(2, "Uélio Donelas", "uelio@gmail.com", "222.222.222", new java.sql.Date(System.currentTimeMillis()), "Conjunto");
		Cliente cliente3 = new Cliente(3, "Breba", "breba@gmail.com", "555.555.555", new java.sql.Date(System.currentTimeMillis()), "Rua da Aurora");
		try {
			clienteDAO.connect();
			clienteDAO.updateCliente(cliente2);
			clienteDAO.updateCliente(cliente3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void selectCliente(){
		try{
			Cliente cliente = clienteDAO.retriveCliente(2);
			System.out.println(cliente);
		}catch (Exception e) {
		}
	}
	
//######################  Agência  ########################
	
	@Test
	public void createAgencia(){
		Agencia agencia1 = new Agencia(11111,"Rio Tinto", "João");
		Agencia agencia2 = new Agencia(22222,"Mamanguape", "Rodrigo");
		Agencia agencia3 = new Agencia(33333,"Itapororoca", "Matheus");
		try{
			agenciaDAO.connect();
			agenciaDAO.createAgencia(agencia1);
			agenciaDAO.createAgencia(agencia2);
			agenciaDAO.createAgencia(agencia3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateAgencia(){
		Agencia agencia2 = new Agencia(22222,"Mamanguape-PB", "Rodrigo");
		Agencia agencia3 = new Agencia(33333,"Itapororoca-PB", "Matheus");
		try{
			agenciaDAO.connect();
			agenciaDAO.updateAgencia(agencia2);
			agenciaDAO.updateAgencia(agencia3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectAgencia(){
		Agencia agencia = null;
		try{
			agenciaDAO.connect();
			agencia = agenciaDAO.retriveAgencia(22222);
			System.out.println(agencia);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//######################  Conta  ########################

	@Test
	public void createConta(){
		//(Nº Conta, Agência, saldo, cliente)
		Conta conta1 = new Conta(1010, 11111, 125, 1);
		Conta conta2 = new Conta(2020, 22222, 307, 2);
		Conta conta3 = new Conta(3030, 22222, 125, 1);
		try{
			contaDAO.connect();
			contaDAO.createConta(conta1);
			contaDAO.createConta(conta2);
			contaDAO.createConta(conta3);
		}catch (Exception e) {
		}
	}
	
	@Test
	public void updateConta(){
		Conta conta2 = new Conta(2020, 22222, 2000, 2);
		Conta conta3 = new Conta(3030, 22222, 4000, 1);
		try{
			contaDAO.connect();
			contaDAO.updateConta(conta2);
			contaDAO.updateConta(conta3);
		}catch (Exception e) {
		}
	}
	
	@Test
	public void selectConta(){
		try{
			contaDAO.connect();
			Conta conta = contaDAO.retriveConta(1010);
			System.out.println(conta);
		}catch (Exception e) {
		}
	}
	
//###################### DELETE  / Conta / Agência / Cliente   ########################
	
	@Test
	public void deleteConta(){
		try{
			contaDAO.connect();
			contaDAO.deleteConta(2020);
			contaDAO.deleteConta(3030);
		}catch (Exception e) {
		}
	}
	
	@Test
	public void deleteCliente(){
		try{
			clienteDAO.connect();
			clienteDAO.deleteCliente(2);
			clienteDAO.deleteCliente(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteAgencia(){
		try{
			agenciaDAO.connect();
			agenciaDAO.deleteAgencia(22222);
			agenciaDAO.deleteAgencia(33333);
		}catch (Exception e) {	
			e.printStackTrace();
		}
	}
	

}
