package desafio.desafioprojeto.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.desafioprojeto.model.Endereco;
import desafio.desafioprojeto.model.EnderecoRepository;
import desafio.desafioprojeto.model.Hospital;
import desafio.desafioprojeto.model.HospitalRepository;
import desafio.desafioprojeto.service.HospitalService;
import desafio.desafioprojeto.service.ViaCepService;


/**
 * 
 * @author jardeljbastos
 *
 */


@Service
public class HospitalServiceImpl extends HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	public Iterable<Hospital> buscarTodos() {
		return hospitalRepository.findAll();
	}

	@Override
	public Hospital buscarPorId(Long id) {
		Optional<Hospital> hospital = hospitalRepository.findById(id);
		return hospital.get();
	}

	@Override
	public void inserir(Hospital hospital) {
		salvarHospitalComCep(hospital);
	}

	@Override
	public void atualizar(Long id, Hospital hospital) {
		Optional<Hospital> hospitalBd = hospitalRepository.findById(id);
		if (hospitalBd.isPresent()) {
			salvarHospitalComCep(hospital);
		}
	}

	@Override
	public void deletar(Long id) {
		hospitalRepository.deleteById(id);
	}

	private void salvarHospitalComCep(Hospital hospital) {
		String cep = hospital.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		hospital.setEndereco(endereco);
		hospitalRepository.save(hospital);
	}

}
