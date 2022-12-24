package java8V2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings3Lambda {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		System.out.println("####################################");
		System.out.println("==> ordenando com Collections.sort");
		Collections.sort(palavras);
		System.out.println(palavras);

		System.out.println("\n####################################");
		System.out.println("==> ordenando por tamanho com Collections.sort");
		Comparator<String> comparador = new ComparadorPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);

		System.out.println("\n####################################");
		System.out.println("==> ordenando por tamanho com palavras.sort");
		palavras.sort(comparador);
		System.out.println(palavras);

		System.out.println("\n####################################");
		System.out.println("==> imprimindo com for tradicional");
		for (String s : palavras) {
			System.out.println(s);
		}

		System.out.println("\n####################################");
		System.out.println("==> imprimindo com forEach e consumer");
		Consumer<String> consumidor = new ImprimeNaLinha2();
		palavras.forEach(consumidor);
		
		System.out.println("\n####################################");
		System.out.println("==> imprimindo com classe anonima emcapsulando ImprimeNaLinha3");
//		Consumer<String> consumidor = new ImprimeNaLinha3();
		Consumer<String> consumidor3 = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		palavras.forEach(consumidor3);
		
		System.out.println("\n####################################");
		System.out.println("==> imprimindo com classe anonima emcapsulando ImprimeNaLinha3 omitindo consumidor");
//		Consumer<String> consumidor3 = 
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		System.out.println("\n####################################");
		System.out.println("==> imprimindo com classe anonima emcapsulando ImprimeNaLinha3 resumindo ainda mais com lambda");
		palavras.forEach((String t) -> {
			System.out.println(t);
		});

		System.out.println("\n####################################");
		System.out.println("==> imprimindo com classe anonima emcapsulando ImprimeNaLinha3 resta apenas uma linha");
		palavras.forEach(t -> System.out.println(t));
	}
}

class ImprimeNaLinha2 implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);

	}
}
//class ImprimeNaLinha3 implements Consumer<String> {
//
//	@Override
//	public void accept(String t) {
//		System.out.println(t);
//
//	}

class ComparadorPorTamanho implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;

		if (s1.length() > s2.length())
			return 1;

		return 0;
	}
}
