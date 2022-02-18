package br.com.alura.curso;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Curso {

	private String nome;
	private String instrutor;
	// sempre mais vantajoso usar o List do lado esquerdo, sem especificar o tipo da lista, isso facilita para manutenção do código, 
	//e também para deixar o código mais "escondido" - codar na defensiva
	private List<Aula> aulas = new LinkedList<Aula>(); // LinkedList é melhor quando precisa adicionar ou remover do
														// inicio ou do fim da lista, porque ela altera os ponteiros, as referências de maneira bem rápida
														// mas é muito lenta para buscar elementos, ela "conta" até chegar no index que você deseja
	                                                    // já o ArrayList insere muito rápido os elementos na lista e para buscar também
														// é muito facil
														// - acesso aleatório, (quando trabalha muito com for etc,), porém para adc
														// elemento no inicio , por exemplo
														// ele precisa empurrar todos os elementos para frente, isso é custoso

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

//	public List<Aula> getAulas() {
//		return aulas;
//	}
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
}
