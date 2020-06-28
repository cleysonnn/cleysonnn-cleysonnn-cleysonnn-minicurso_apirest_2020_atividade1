package br.ufpb.minicurso.testeAPI.entidades;


public class Disciplina implements Comparable<Disciplina> {
	

	private int id;
	private String nome;
	private double nota;
	
	

	
	public Disciplina(int id, String nome, double nota) {
		super();
		this.id = id;
		this.nome = nome;
		this.nota = nota;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	//compra as notas e ordena os objetos de acordo com as comparaçoes 
	@Override
	public int compareTo(Disciplina disciplina) {
		if(this.nota>disciplina.nota) {
			return -1;
		}
		else if (this.nota<disciplina.nota){
			return 1;
		}
		
		return 0;
	}
	
	

}
