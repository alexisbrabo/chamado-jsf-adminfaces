package br.com.alexis.chamado.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alexis.chamado.model.Cliente;
import br.com.alexis.chamado.repository.ClienteRepository;

@Stateless
public class ClienteService {

	@Inject
	ClienteRepository clienteRepository;

	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
