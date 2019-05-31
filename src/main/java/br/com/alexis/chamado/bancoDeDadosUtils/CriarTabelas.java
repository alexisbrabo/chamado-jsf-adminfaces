package br.com.alexis.chamado.bancoDeDadosUtils;

import javax.persistence.Persistence;

public class CriarTabelas {

	public static void main(String[] args) {

		Persistence.createEntityManagerFactory("ChamadoPU");
	}
}
