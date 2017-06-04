import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

// textos retirados de http://sitenotadez.net/digitacao-concursos/


public class App {

	 public static void main(String[]  args) {
		
		 
		 //String[] files = new String[]{ "texto01.txt","texto02.txt", "texto03.txt", "texto04.txt", 
		 //      "texto05.txt","texto06.txt", "texto07.txt", "texto08.txt"
		 //      "texto09.txt","texto10.txt" };
		 //for (String fname : files) {
		 
		 for (String fname : args) {
			 System.out.format("%nFile: %s%n", fname);
		 
			 try {
				carregaDados(fname);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
	 
	public static void carregaDados(String fileName) throws IOException {
			Path path1 = Paths.get(fileName);
			  try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(path1, Charset.forName("utf8")))) {
				String line;	
		    	while ((line = reader.readLine()) != null) {
					line = line.toLowerCase().replaceAll("[^a-zA-Z·ÈÌÛ˙Á„ı‡-]"," ");
					String[] palavras = line.split(" ");
					for (String pal : palavras) {
						if (pal != null && !pal.equals(""))
							System.out.format("<%s>", pal);	
					}
					System.out.format("\n");	
					
				}
			}
		}

	
}
