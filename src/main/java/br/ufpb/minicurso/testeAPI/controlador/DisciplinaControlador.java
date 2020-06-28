package br.ufpb.minicurso.testeAPI.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.minicurso.testeAPI.entidades.Disciplina;
import br.ufpb.minicurso.testeAPI.servicos.DisciplinaServicos;

@RestController
public class DisciplinaControlador {
	
	@Autowired
	private DisciplinaServicos disciplinaServicos;
	
	
	
	
	
	@PostMapping ("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> adicionaDiscuplina( @RequestBody Disciplina disciplina){
		return new  ResponseEntity<Disciplina>(disciplinaServicos.adicionaNovaDisciplina(disciplina) , HttpStatus.CREATED);
		
	}
	

	
	
	@GetMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> getDisciplinaporID(@PathVariable Integer id){            
		try {
			return new ResponseEntity<Disciplina>(disciplinaServicos.getDisciplinaById(id),HttpStatus.OK);
		}catch (ArrayIndexOutOfBoundsException e) {
			// se nao achar a disciplina , retorne uma disiciplina com id, nota -1 e  nome null e erro 404
			return new ResponseEntity<Disciplina>(new Disciplina(-1, "null",-1),HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	@GetMapping("/v1/api/disciplinas")
	public List<Disciplina> getTodasDisciplinas(){
		return disciplinaServicos.getTodasAsDisciplina();
	}
	
	
	
	
	
	
	@PutMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> mudarNomeDaDisciplina(@PathVariable Integer id ,@RequestBody Disciplina novaDisciplina){
		try {
			return new ResponseEntity<Disciplina>(disciplinaServicos.SetNomeDaDisciplina(id, novaDisciplina),HttpStatus.OK);
			
		}catch (Exception e) {
			// caso o id da disciplina nao for encontrado , retorne o erro 404 , e objeto nulo e o nome nao sera alterado
			return new ResponseEntity<Disciplina>(new Disciplina(-1, "null",-1),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	@PutMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> mudaNotaDaDisciplina(@PathVariable int id , @RequestBody Disciplina novaNota){
		try {
			return new ResponseEntity<Disciplina>(disciplinaServicos.SetNotaDaDisciplina(id, novaNota),HttpStatus.OK);
			
		}catch (Exception e) {
			// caso o id da disciplina nao for encontrado , retorne o erro 404 , e objeto nulo e o nota nao sera alterado
			return new ResponseEntity<Disciplina>(new Disciplina(-1, "null",-1),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> deletaDisciplina(@PathVariable int id ){
		try {
			return new ResponseEntity<Disciplina>(disciplinaServicos.deletaDisciplinaPorId(id),HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<Disciplina>(new Disciplina(-1, "null",-1),HttpStatus.NOT_FOUND);		}
	}
	
	
	@GetMapping("/v1/api/disciplinas/ranking")
	public List<Disciplina> rankDasDisciplinas(){
			return disciplinaServicos.RankDiciplinas();
				
	}
	

}
