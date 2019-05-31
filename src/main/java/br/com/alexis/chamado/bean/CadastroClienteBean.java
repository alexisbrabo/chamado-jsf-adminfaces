package br.com.alexis.chamado.bean;

import static com.github.adminfaces.template.util.Assert.has;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import br.com.alexis.chamado.model.Cliente;
import br.com.alexis.chamado.service.ClienteService;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	@Inject
	ClienteService clienteService;

	private static final long serialVersionUID = 820727619227469947L;
	private Long id;
	private Cliente cliente;

	public void init() {
		if (Faces.isAjaxRequest()) {
			return;
		}
		if (has(id)) {
			cliente = clienteService.findById(id);
		} else {
			cliente = new Cliente();
		}
	}
	
	public void salvarCliente() {
		cliente = clienteService.salvarCliente(cliente);
	}
	
	public boolean isNew() {
		return cliente == null || cliente.getId() == null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
