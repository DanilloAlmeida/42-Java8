package java8V2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		System.out.println("\n==> ordenando com Collections.sort");
		Collections.sort(palavras);
		System.out.println(palavras);

		System.out.println("\n==> ordenando com Collections.sort");
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
	}
}

class ImprimeNaLinha implements Consumer<String> {
	@Override
	public void accept(String t) {
		System.out.println(t);
	}
}