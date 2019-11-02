package br.edu.infnet.carrinho.ejb;

import javax.ejb.Stateful;

import br.edu.infnet.carrinho.modelo.Produto;


@Stateful
public class CarrinhoEjb {

	private Integer count = 1;

	public Produto adicionar(Produto produto) {
		//TODO adiciono na base
		produto.setId(count++);
		
		return produto;
		
	}
	
}
