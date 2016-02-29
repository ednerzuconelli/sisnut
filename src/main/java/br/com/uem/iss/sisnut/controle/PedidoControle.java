package br.com.uem.iss.sisnut.controle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import testes.testePedido;
import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.modelo.Pedido;
import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.servico.PacienteServico;
import br.com.uem.iss.sisnut.servico.PedidoServico;
import br.com.uem.iss.sisnut.servico.ProdutoServico;
import br.com.uem.iss.sisnut.view.PedidoBean;

@Component("pedidoControle")
public class PedidoControle {

	@Autowired
	private PedidoServico pedidoservico;
	
	@Autowired
	private ProdutoServico produtoservico;
	
	@Autowired
	private PacienteServico pacienteservico;
	
	private Pedido pedidoSelecionado;
	
	public Pedido getPedidoSelecionado() {
		return pedidoSelecionado;
	}

	public void setPedidoSelecionado(Pedido pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}

	public PedidoBean newPedidoBean(){
    	Pedido pedido = new Pedido();
    	return new PedidoBean(pedido, new EventFactorySupport().success(this));
    }
	
	public List<Produto> completeProduto(String query) {
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
	
	public List<Paciente> completePaciente(String query) {
        List<Paciente> pacientes = pacienteservico.findAll();
        List<Paciente> filteredPacientes = new ArrayList<Paciente>();
        
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente skin = pacientes.get(i);
            if(skin.getNome().toLowerCase().startsWith(query)) {
                filteredPacientes.add(skin);
            }
        }
         
        return filteredPacientes;
    }
	
	public Event salvePedido(PedidoBean pedidobean, MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			Pedido pedido = pedidobean.getPedido();
			pedido.setEnviou(0);
			System.out.println("Teste do controlador pedido");
			pedido.setPaciente(pacienteservico.findPacienteById(1));
			pedido.setProduto(produtoservico.findAll());
			DateTime data = new DateTime();
			pedido.setDataPedido(data);
			System.out.println("data "+ pedido.getDataPedido());
			System.out.println("Teste do controlador pedido localizou" + pedido.getPaciente().getNome());
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
	
	public List<Pedido> findAll(){
		List<Pedido> newp = null;
		System.out.println("teste de fin pedido");
		newp = pedidoservico.findAll();
		System.out.println("imprimir pedidos " +newp.toString());
		return newp;
	}
	
}
