package br.ufpb.minicurso.testeAPI.servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ufpb.minicurso.testeAPI.entidades.Disciplina;

@Service
public class DisciplinaServicos {
	private ArrayList<Disciplina> listaDasDisciplinas = new ArrayList<Disciplina>();

	public Disciplina adicionaNovaDisciplina(Disciplina disciplina) {
		disciplina.setId(listaDasDisciplinas.size());
		listaDasDisciplinas.add(disciplina);
		return listaDasDisciplinas.get(listaDasDisciplinas.size() - 1);
	}

	public Disciplina getDisciplinaById(int id) {
		if (listaDasDisciplinas.isEmpty() || id < 0 || id >= listaDasDisciplinas.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return listaDasDisciplinas.get(id);

	}

	public List<Disciplina> getTodasAsDisciplina() {
		return listaDasDisciplinas;
	}

	public Disciplina SetNomeDaDisciplina(int id, Disciplina disciplina) {
		listaDasDisciplinas.get(id).setNome(disciplina.getNome());

		return listaDasDisciplinas.get(id);
	}

	public Disciplina SetNotaDaDisciplina(int id, Disciplina disciplina) {
		listaDasDisciplinas.get(id).setNota(disciplina.getNota());
		return listaDasDisciplinas.get(id);

	}

	public Disciplina deletaDisciplinaPorId(int id) {
		Disciplina disciplinaDel = listaDasDisciplinas.get(id);
		listaDasDisciplinas.remove(id);
		return disciplinaDel;
	}

	public ArrayList<Disciplina> RankDiciplinas() {
		Collections.sort(listaDasDisciplinas);
		return listaDasDisciplinas;
	}


}
