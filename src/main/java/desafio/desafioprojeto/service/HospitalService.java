package desafio.desafioprojeto.service;

import desafio.desafioprojeto.model.Hospital;

/**
 * 
 * @author jardeljbastos
 *
 */

public abstract class HospitalService {

	public abstract Iterable<Hospital> buscarTodos() ;

	public Hospital buscarPorId(Long id) {
		return null;
	}

	public void inserir(Hospital hospital) {
	}

	public void atualizar(Long id, Hospital hospital) {

	}

	public void deletar(Long id) {

	}

}

