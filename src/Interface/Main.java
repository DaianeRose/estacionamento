package Interface;

import java.util.*;


import Negocio.*;
import Persistencia.*;
import java.sql.*;


public  class Main{
	
	private ValoresDAO valoresDAO;
	private Collection valores = new HashSet();
	public static final int ADICIONAR = 1;
	public static final int CONSULTAR = 2;
	public static final int REMOVER = 3;
	
/**
* Metodo Construtor que gera uma conexao com o Banco de Dados
*/
	public Main() throws Exception{
		 
    valoresDAO = new ValoresDAO();
		
	}
	
/**
* Metodo que monta o menu principal e 
* obtem uma opcao do usuario
*/
	public int criaMenuPrincipal(){
		int opcao;
		System.out.println("Menu de Opcoes:");
		System.out.println("-------------------");
		System.out.println("1. Adicionar Valores");
		System.out.println("2. Consultar Valores");
		System.out.println("3. Remover Valores  ");
		System.out.println("4. Sair do Programa");
		System.out.println("-------------------");
		return opcao = Console.readInt();
	}
/**
* 
*/	
	public void AdicionarValores()throws Exception{
		Valores v;
		String opcao;
		do {
			System.out.println("Adicionar Valores:");
			System.out.println("-------------------");
			System.out.print("Valor do horista:");
			Float horista = new Float(Console.readInt());
			System.out.print("Valor do mensalista:");
			Float mensalista = new Float(Console.readLine());
			
						
			v = new Valores(horista, mensalista);
			
			// Gravando pedido no  Banco de Dados
			valoresDAO.salvar(v);
			
			System.out.print("Deseja Adicionar mais um Pedido? [S|N]: ");
			opcao = Console.readLine();
		} while(opcao.compareTo("S") == 0);

	}
	
	
	
	
	
	public void ConsultarValores() throws Exception{
		
		System.out.println("Consultar Valores:");
		System.out.println("-------------------");
				
		List<Valores> valoresLocal = valoresDAO.ConsultarTodos();
		Iterator it = valoresLocal.iterator();
		Valores valIt;
		while(it.hasNext()) {
			valIt=(Valores)it.next();
			System.out.println("id: "+valIt.getIdvalores()+" valor horista: "+valIt.getHorista()+" valor mensalista: "+valIt.getMensalista());
		}
	}
	
	
	public void RemoverPedido()throws Exception{
		int opcao;
		
		System.out.println("Remover Pedido:");
		System.out.println("-------------------");
		ConsultarValores();
		System.out.print("Digite o id do Pedido:");
		Integer id = new Integer(Console.readInt());
		
		valoresDAO.Remover(id);
	}
	
	public static void main(String args[]){
		
		try {
			Main cp = new Main();
			int opcao;
			
			while((opcao = cp.criaMenuPrincipal()) != 4){
				if(opcao == Main.ADICIONAR)
					cp.AdicionarValores();
				else if(opcao == Main.CONSULTAR)
					cp.ConsultarValores();
				else if(opcao == Main.REMOVER)
					cp.RemoverPedido();
				else System.out.println("Escolha uma opcao correta.");
			}
		}catch(Exception e){
			e.printStackTrace();
			}	
	}
}