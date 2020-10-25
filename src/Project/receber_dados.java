package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;

public class receber_dados {
	
	private ArrayList<String> listPalavras = new ArrayList<String>(); //Instanciando o ArrayList com a class Palavras
	
	public void pegar_dados_arq(String path) {	
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { //Dessa maneira, já instancia os recursos no bloco try.
			//Primeira linha															//Quando terminar o bloco try ou cair no catch já haverá a desalocação dos recursos.
			String line = br.readLine(); //Ler de linha a linha. ReadLine() le a string até a quebra de linha								
			while (line != null) { //Ler até o final do arquivo.
				String[] palavrasDaLinha  = line.split(" "); //Recorta a string em partes dividindo por espaço em branco e armazena em um vetor.
				//Vai pegar cada palavra da linha, dividindo por espaço em branco, e armazenar em um vetor.
				for(String palavra : palavrasDaLinha) { //Para cada palavra na string PalavrasdaLinha faça:
		            if(!"".equals(palavra.trim())) { //Se não for espaço em branco, salve na listPalavras
		            	this.listPalavras.add(palavra);  //Adicionar o Objeto no ArrayList
		            }
				}
				line = br.readLine(); //Quando line receber o null ele sai do arquivo. Significa que acabou o arquivo.
			}
			
		} 
		catch (IOException e) { //Classe genérica para o tratamento de erros de Entradas e Saídas (Input/Output)
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static String removeAcents(String palavras) { //CORSI -----> POE A LISTA P RECEBER
	    return Normalizer.normalize(palavras, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	public String formatar_words(String palavras) {
		return palavras.toLowerCase();
	}
	
	public ArrayList<String> getListPalavras() {
		return listPalavras;
	}

	public void setListPalavras(ArrayList<String> listPalavras) {
		this.listPalavras = listPalavras;
	}
	
	public void exibir_elementos() {
		for (int i = 0; i <getListPalavras().size(); i++) {
			getListPalavras().set(i, removeAcents(getListPalavras().get(i)));
			getListPalavras().set(i, formatar_words(getListPalavras().get(i)));
			System.out.println(getListPalavras().get(i));
	}		
	}
}
	


