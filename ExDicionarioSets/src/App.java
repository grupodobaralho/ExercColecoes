import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

// textos retirados de http://sitenotadez.net/digitacao-concursos/

public class App {

	static ArrayList<String[]> linhas;
	static Colecoes c = new Colecoes();

	public static void main(String[] args) {

		// String[] files = new String[]{ "texto01.txt","texto02.txt",
		// "texto03.txt", "texto04.txt",
		// "texto05.txt","texto06.txt", "texto07.txt", "texto08.txt"
		// "texto09.txt","texto10.txt" };
		// for (String fname : files) {

		
		
		for (String fname : args) {
			// System.out.format("%nFile: %s%n", fname);

			try {
				carregaDados(fname);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				

		ArrayList<String> hl1 = c.consultaUm("engenheiro");
		if (hl1 != null) {
			System.out.println(hl1);
		} else {
			System.out.println("Nao existem textos com esta palavra!");
		}

		ArrayList<String> arrayPalavras = new ArrayList<>();
		arrayPalavras.add("o");
		arrayPalavras.add("em");
		arrayPalavras.add("do");
		arrayPalavras.add("que");
		arrayPalavras.add("foi");
		arrayPalavras.add("na");

		ArrayList<String> hl2 = c.consultaDois(arrayPalavras);
		if (hl2 != null) {
			System.out.println(hl2);
		} else {
			System.out.println("Nao existem textos com estas palavras!");
		}

		ArrayList<String> hl3 = c.consultaTres("texto01.txt");
		if (hl3 != null) {
			System.out.println(hl3);
		} else {
			System.out.println("Nao existem arquivo com este nome!");
		}


	}

	public static void carregaDados(String fileName) throws IOException {
		Path path1 = Paths.get(fileName);
		try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(path1, Charset.forName("utf8")))) {
			String line;
			linhas = new ArrayList<>();
			String[] palavras;
			while ((line = reader.readLine()) != null) {
				line = line.toLowerCase().replaceAll("[^a-zA-Z·ÈÌÛ˙Á„ı‡-]", " ");
				// System.out.println("LINE: " + line + " //LINE");
				palavras = line.split(" ");
				linhas.add(palavras);
				/*
				 * for (String pal : palavras) { if (pal != null &&
				 * !pal.equals("")); System.out.format("<%s>", pal);
				 * c.add(fileName, palavras); }* //System.out.format("\n");
				 */

				// for(String s : palavras){
				// System.out.println("P1: "+s);
				// }	
			}
			c.add(fileName, linhas);
		}
	}

}
