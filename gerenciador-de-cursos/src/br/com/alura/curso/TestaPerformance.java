package br.com.alura.curso;

import java.util.ArrayList;
import java.util.Collection;

public class TestaPerformance {

	public static void main(String[] args) {

		Collection<Integer> numeros = new ArrayList<Integer>();
		//Collection<Integer> numeros = new HashSet<>();

		long inicio = System.currentTimeMillis();

		for (int i = 1; i <= 50000; i++) {
			numeros.add(i);
		}

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}

		long fim = System.currentTimeMillis();

		long tempoDeExecucao = fim - inicio;

		System.out.println("Tempo gasto: " + tempoDeExecucao);

	}
	
//	No caso do ArrayList, a inser??o ? bem r?pida e a busca muito lenta!
//	No caso do HashSet, a inser??o ainda ? r?pida, embora um pouco mais lenta do que a das listas. Mas a busca ? muito r?pida!

}