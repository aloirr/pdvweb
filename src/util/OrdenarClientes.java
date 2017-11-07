package util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Cliente;

public class OrdenarClientes {

	public static List<Cliente> ordenarClientesPorAtributo(List<Cliente> listaClientes,
			String atributo) {
		// id, razaoSocial, nomeFantasia, endereco, telefone, email, nomeContato, prazo,
		// cpf, cnpj, inscEstadual,
		// inscMunic, inscSuframa;
		Comparator<Cliente> ordenador;
		switch (atributo) {
		case "razaoSocial":
			ordenador = Comparator.comparing(Cliente::getRazaoSocial);
			listaClientes.sort(ordenador);
			return listaClientes;
		case "nomeFantasia":
			ordenador = Comparator.comparing(Cliente::getNomeFantasia);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "id":
			ordenador = Comparator.comparing(Cliente::getId);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "endereco":
			ordenador = Comparator.comparing(Cliente::getEndereco);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "telefone":
			ordenador = Comparator.comparing(Cliente::getTelefone);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "email":
			ordenador = Comparator.comparing(Cliente::getEmail);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "nomeContato":
			ordenador = Comparator.comparing(Cliente::getNomeContato);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "prazo":
			ordenador = Comparator.comparing(Cliente::getPrazo);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "cpf":
			ordenador = Comparator.comparing(Cliente::getCpf);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "cnpj":
			ordenador = Comparator.comparing(Cliente::getCnpj);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "inscEstadual":
			ordenador = Comparator.comparing(Cliente::getInscEstadual);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "inscMunic":
			ordenador = Comparator.comparing(Cliente::getInscMunic);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;
		case "inscSuframa":
			ordenador = Comparator.comparing(Cliente::getInscSuframa);
			Collections.sort(listaClientes, ordenador);
			return listaClientes;

		}
		return null;
	}
}
