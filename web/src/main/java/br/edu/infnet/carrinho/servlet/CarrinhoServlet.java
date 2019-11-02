package br.edu.infnet.carrinho.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.carrinho.ejb.CarrinhoEjb;
import br.edu.infnet.carrinho.modelo.Produto;


@WebServlet(name = "Carrinho", urlPatterns =  {"/Carrinho","/cart"})
public class CarrinhoServlet extends HttpServlet {

	@Inject
	private CarrinhoEjb carrinho;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		String nome = req.getParameter("nome");
		String preco = req.getParameter("preco");
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(Double.valueOf(preco));
		
		produto = carrinho.adicionar(produto);
		
         PrintWriter out = resp.getWriter();
         out.println("hello ejb " +  produto );
         out.close();
		
	}

}
