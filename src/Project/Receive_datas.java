package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;

public class Receive_datas {
	
	private ArrayList<String> listWords = new ArrayList<String>(); //Instanciando o ArrayList com a class words
	
	public void get_data_archives(String path) {	
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { //Dessa maneira, já instancia os recursos no bloco try.
			//Primeira linha															//Quando terminar o bloco try ou cair no catch já haverá a desalocação dos recursos.
			String line = br.readLine(); //Ler de linha a linha. ReadLine() le a string até a quebra de linha								
			while (line != null) { //Ler até o final do arquivo.
				String[] wordsFromline  = line.split(" "); //Recorta a string em partes dividindo por espaço em branco e armazena em um vetor.
				//Vai pegar cada word da linha, dividindo por espaço em branco, e armazenar em um vetor.
				for(String word : wordsFromline) { //Para cada word na string wordsFromline faça:
		            if(!"".equals(word.trim())) { //Se não for espaço em branco, salve na listWords
		            	this.listWords.add(word);  //Adicionar o Objeto no ArrayList
		            }
				}
				line = br.readLine(); //Quando line receber o null ele sai do arquivo. Significa que acabou o arquivo.
			}
			
		} 
		catch (IOException e) { //Classe genérica para o tratamento de erros de Entradas e Saídas (Input/Output)
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static String removeAcents(String words) { //CORSI -----> POE A LISTA P RECEBER
	    return Normalizer.normalize(words, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	public String formatar_words(String words) {
		return words.toLowerCase();
	}
	
	public ArrayList<String> getlistWords() {
		return listWords;
	}

	public void setlistWords(ArrayList<String> listWords) {
		this.listWords = listWords;
	}
	
	public void see_elements() {
		try {
			for (int i = 0; i <getlistWords().size(); i++) {
				getlistWords().set(i, removeAcents(getlistWords().get(i)));
				getlistWords().set(i, formatar_words(getlistWords().get(i)));
				System.out.println(getlistWords().get(i));
		}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
	


