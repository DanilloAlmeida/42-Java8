package java8V2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class OrdenaStrings2Tamanho {

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
		Comparator<String> comparador = new ComparadorPorTamanho2();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);

		System.out.println("\n####################################");
		System.out.println("==> ordenando por tamanho com palavras.sort mas ainda com comparador");
		palavras.sort(comparador);
		System.out.println(palavras);

		System.out.println("\n####################################");
		System.out.println("==> ordenando por tamanho com palavras.sort eliminando comparador2 com lambda");
//		Comparator<String> comparador2 = new ComparadorPorTamanho2();
		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;	
			if (s1.length() > s2.length())
				return 1;	
			return 0;
		});
		System.out.println(palavras);

		System.out.println("\n####################################");
		System.out.println("==> ordenando por tamanho com palavras.sort e lambda em uma linha");
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(palavras);

		System.out.println("\n####################################");
		System.out.println("==> imprimindo com classe anonima emcapsulando ImprimeNaLinha3 resta apenas uma linha");
		palavras.forEach(t -> System.out.println(t));
	}
}

class ComparadorPorTamanho2 implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;

		if (s1.length() > s2.length())
			return 1;

		return 0;
	}
}

//class ComparadorPorTamanho2 implements Comparator<String> {
//
//	@Override
//	public int compare(String s1, String s2) {
//		if (s1.length() < s2.length())
//			return -1;
//
//		if (s1.length() > s2.length())
//			return 1;
//
//		return 0;
//	}
//}
