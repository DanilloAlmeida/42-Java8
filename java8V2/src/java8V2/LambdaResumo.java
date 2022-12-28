package java8V2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaResumo {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("aaaaaaaa");
		palavras.add("bbbbbbbb");
		palavras.add("cccccccc");
		
		Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor);
		
		System.out.println("ou simplismente:");
		palavras.forEach(s -> System.out.println(s));

	}

}
