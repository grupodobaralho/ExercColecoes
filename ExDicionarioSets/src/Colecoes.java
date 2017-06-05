import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Colecoes {

	// palavra / arquivo
	private HashMap<String, HashSet<String>> palavra_arquivo;

	// arquivo / palavra
	private HashMap<String, HashMap<String, Integer>> arquivo_palavra;

	public Colecoes() {
		palavra_arquivo = new HashMap<>();
		arquivo_palavra = new HashMap<>();
	}

	public void add(String nomeArq, ArrayList<String[]> texto) {
		HashMap<String, Integer> hm = new HashMap<>();
		for (String[] frases : texto) {
			for (String s : frases) {
				if (!palavra_arquivo.containsKey(s)) {
					HashSet<String> hs = new HashSet<>();
					hs.add(nomeArq);
					palavra_arquivo.put(s, hs);
				} else {
					palavra_arquivo.get(s).add(nomeArq);
				}

				if (!(hm.containsKey(s))) {
					hm.put(s, 1);

				} else {
					hm.put(s, hm.get(s) + 1);
				}
			}
		}
		arquivo_palavra.put(nomeArq, hm);
	}

	public ArrayList<String> consultaUm(String palavra) {
		ArrayList<String> array = new ArrayList<>();
		if (!palavra_arquivo.containsKey(palavra)) {
			return null;
		}
		HashSet<String> hs = palavra_arquivo.get(palavra);
		Iterator<String> iterator = hs.iterator();
		while (iterator.hasNext()) {
			array.add(iterator.next());
		}
		return array;
	}

	public ArrayList<String> consultaDois(ArrayList<String> arrayPalavras) {
		ArrayList<String> array = new ArrayList<>();
		HashSet<String> aux = new HashSet<>();
		if (!palavra_arquivo.containsKey(arrayPalavras.get(0))) {
			return null;
		}
		aux = palavra_arquivo.get(arrayPalavras.get(0));
		for (String s : arrayPalavras) {
			if (s == null)
				aux.retainAll(palavra_arquivo.get(s));
		}
		Iterator<String> iterator = aux.iterator();
		while (iterator.hasNext()) {
			array.add(iterator.next());
		}
		return array;
	}

	public ArrayList<String> consultaTres(String arquivo) {
		ArrayList<String> array = new ArrayList<>();
		HashMap<String, Integer> aux = arquivo_palavra.get(arquivo);
		if (aux == null) {
			return null;
		}
		for (HashMap.Entry<String, Integer> e : aux.entrySet()) {
			String stringao = "<" + e.getKey() + "->" + e.getValue();
			if (e.getValue() > 1) {
				stringao = stringao + " vezes";
			} else {
				stringao = stringao + " vez";
			}
			array.add(stringao);
		}
		return array;
	}

}
