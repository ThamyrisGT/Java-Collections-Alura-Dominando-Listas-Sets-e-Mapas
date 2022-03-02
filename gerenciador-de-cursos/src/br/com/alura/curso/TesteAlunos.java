package br.com.alura.curso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TesteAlunos {
	public static void main(String[] args) {

		//Set<String> alunos = new HashSet<>();  // não tem garantia de ordem ; são muito mais rápidos para remover ou encontrar itens na lista
		Collection<String> alunos = new HashSet<>();
		alunos.add("Rodrigo Turini");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		alunos.add("Nico Steppat");
		alunos.add("Sergio Lopes");
		alunos.add("Renan Saggio");
		alunos.add("Mauricio Aniche");

		System.out.println(alunos);
		
		for (String aluno : alunos) {
	        System.out.println(aluno);
	    }
		System.out.println(alunos.size());
		
		boolean pauloEstaMatriculado = alunos.contains("Paulo Silveira");
		System.out.println(pauloEstaMatriculado);
		alunos.remove("Sergio Lopes");
		
		
		
		List<String> alunosEmLista = new ArrayList<>(alunos);
		Collections.sort(alunosEmLista);

	}
}
