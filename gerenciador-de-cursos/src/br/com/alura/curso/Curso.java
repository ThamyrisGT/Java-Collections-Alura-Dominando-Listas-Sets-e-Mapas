package br.com.alura.curso;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {

	private Integer tempoTotal;
	private String nome;
	private String instrutor;
	//HashTable : antigo, threadSafe,
	//LinkedHashMap : de acordo com a inser??o de cada put, ele guarda a ordem das linhas, entao se for percorrer, vai ser feito na ordem de inser??o dessas linhas,dos put
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
	private Set<Aluno> alunos = new HashSet<>(); 
	//TreeSet - ?rvora rubro negra - s? funciona com classes que s?o Comparable e  ordena natural dos objetos(ordena os seus elementos na hora da inser??o.o crit?rio da ordena??o depende e pode ser definido atrav?s de um Comparator.) - busca mais r?pido que as Listas mas nao tao r?pido quanto Sets
	// LinkedHashSet- garante a ordem de inser??o,tbm utiliza a estrutura de tabela de espalhamento
	//se estamos trabalhando com uma inst?ncia de uma classe que n?o temos acesso ou n?o 
	//podemos modificar para implementar Comparable,Nesse caso, o construtor do TreeSet
	//recebe como par?metro um objeto que implementa Comparator. Dessa forma, o crit?rio de compara??o pode ser criado em separado da classe na qual opera.
	
	// sempre mais vantajoso usar o List do lado esquerdo, sem especificar o tipo da
	// lista, isso facilita para manuten??o do c?digo,
	// e tamb?m para deixar o c?digo mais "escondido" - codar na defensiva
	private List<Aula> aulas = new LinkedList<Aula>(); // LinkedList ? melhor quando precisa adicionar ou remover do
														// inicio ou do fim da lista, porque ela altera os ponteiros, as
														// refer?ncias de maneira bem r?pida
														// mas ? muito lenta para buscar elementos, ela "conta" at?
														// chegar no index que voc? deseja
														// j? o ArrayList insere muito r?pido os elementos na lista e
														// para buscar tamb?m
														// ? muito facil
														// - acesso aleat?rio, (quando trabalha muito com for etc,),
														// por?m para adc
														// elemento no inicio , por exemplo
														// ele precisa empurrar todos os elementos para frente, isso ?
														// custoso

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

	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

//	public List<Aula> getAulas() {
//		return aulas;
//	}
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
		this.tempoTotal += aula.getTempo();
	}

	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
//		int tempoTotal = 0;
//		for (Aula aula : aulas) {
//			tempoTotal += aula.getTempo();
//		}
//		return tempoTotal;
	}

	@Override
	public String toString() {
		return "[Curso: " + this.getNome() + ", tempo total: " + this.getTempoTotal() + ", aulas: + " + this.aulas
				+ "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
	}

	public boolean estaMatriculado(Aluno aluno) {
	    return this.alunos.contains(aluno);
	}

	
	public Aluno buscaMatriculado(int numero) {
	    return this.matriculaParaAluno.get(numero);
	}
	
//	public Aluno buscaMatriculado(int numero) {
//	    for (Aluno aluno : alunos) {
//	        if (aluno.getNumeroMatricula() == numero) {
//	            return aluno;
//	        }
//	    }
//	    throw new NoSuchElementException("Matricula " + numero
//	            + " n?o encontrada");
//	}

}
