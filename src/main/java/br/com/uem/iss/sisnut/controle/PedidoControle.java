package br.com.uem.iss.sisnut.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Pedido;
import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.servico.PedidoServico;
import br.com.uem.iss.sisnut.servico.ProdutoServico;
import br.com.uem.iss.sisnut.view.PedidoBean;

@Component("pedidoControle")
public class PedidoControle {

	@Autowired
	private PedidoServico pedidoservico;
	
	@Autowired
	private ProdutoServico produtoservico;
	
	public PedidoBean newPedidoBean(){
    	Pedido pedido = new Pedido();
    	return new PedidoBean(pedido, new EventFactorySupport().success(this));
    }
	
	public List<Produto> completeTheme(String query) {
        List<Produto> produtos = produtoservico.findAll();
        List<Produto> filteredProdutos = new ArrayList<Produto>();
         
        for (int i = 0; i < produtos.size(); i++) {
            Produto skin = produtos.get(i);
            if(skin.getProduto().toLowerCase().startsWith(query)) {
                filteredProdutos.add(skin);
            }
        }
         
        return filteredProdutos;
    }
	
	
	public Event salvePedido(PedidoBean pedidobean, MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			System.out.println("Teste de inserçao pedido " );
			Pedido pedido = pedidobean.getPedido();
			
			pedidoservico.save(pedido);
			
		}catch (Throwable ex3){
			  messageBuilder = new MessageBuilder().error();
			  messageBuilder.code("erro.pedido.salve");
			  messageBuilder.arg(ex3);
			  messageContext.addMessage(messageBuilder.build());
			  return new EventFactorySupport().error(this);	
		}
			
		return new EventFactorySupport().success(this);
		
	}
	
	
}
