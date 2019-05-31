package br.com.alexis.chamado.repository;

import java.util.Optional;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.alexis.chamado.model.Cliente;

@Repository
public interface ClienteRepository extends EntityRepository<Cliente, Long> {

	Optional<Cliente> findById(Long id);

}
