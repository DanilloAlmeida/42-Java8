import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaString {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		Collections.sort(palavras);
		System.out.println("\ncomparando com o Collections.sort");
		System.out.println(palavras);

		System.out.println("\ncomparando com o comparator");
		Comparator <String> comparador = new comparandoPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);

		System.out.println("\nimprimindo com o forEach");
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
//		System.out.println(palavras);
	}
}

class ImprimeNaLinha implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println(t);
		
	}
	
}

class comparandoPorTamanho implements Comparator<String> {
	
	@Override
	public int compare(String o1, String o2) {
		if (o1.length() < o2.length())
			return -1;
		if (o1.length() > o2.length())
			return 1;			
		return 0;
	}
}