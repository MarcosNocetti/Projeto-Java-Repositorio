package Project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;



public class Receive_datas {
	
	private ArrayList<String> listWords = new ArrayList<>(); //Instanciando o ArrayList com a class words
	private ArrayList<String> formatedList = new ArrayList<>(); //lista das palavras formatadas (sem acento, etc...)
	
	public void get_data_archives(String path) {	
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"))) { //Dessa maneira, já instancia os recursos no bloco try.
			//Primeira linha															//Quando terminar o bloco try ou cair no catch já haverá a desalocação dos recursos.
			String line = br.readLine(); //Ler de linha a linha. ReadLine() le a string até a quebra de linha								
			while (line != null) { //Ler até o final do arquivo.

				String[] wordsFromline  = line.split("[!-.:-@\s]"); //Recorta a string em partes dividindo por espaço em branco e armazena em um vetor.
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
	
		public String formatar_words(String words) {
			return words.toLowerCase();
		}
		
		public ArrayList<String> getlistWords() {
			return listWords;
		}
	
		public void setlistWords(ArrayList<String> listWords) {
			this.listWords = listWords;
		}
		public ArrayList<String> getFormatedList() {
		return formatedList;
		}

		public void setFormatedList(ArrayList<String> formatedList) {
		this.formatedList = formatedList;
		}
	//C:\Users\jvcco\Desktop\Ex3_LuarDoSertao.txt
	public void trat_elements() {
		try {
			// ------------------- Minuscula -------------------------
			for (int i = 0; i <getlistWords().size(); i++) {
				getlistWords().set(i, formatar_words(getlistWords().get(i)));
				getFormatedList().add(i,getlistWords().get(i));
			}
		
			// ------------------- Ordem alfabetica -------------------------
			setFormatedList(alphabetic_order(getFormatedList()));//adicionando a palavra na lista em ordem alfabetica
		
			int i=0;
			int j=0;
			int t=0;
			System.out.println(getlistWords());//exibindo as palavras da lista formatada
			System.out.println(getFormatedList());//exibindo as palavras da lista formatada
			//System.out.println(getlistWords().get(7));//exibindo as palavras da lista formatada
			//System.out.println(getlistWords().get(18));//exibindo as palavras da lista formatada
			
			while(t<getlistWords().size()){
				while(getFormatedList().get(i)!=getlistWords().get(j)){
				  j++;
				  }
				  if(getFormatedList().get(i).equals(getlistWords().get(j))){
		
				   System.out.print(getFormatedList().get(i)+i);
				   
				   System.out.print("," + getlistWords().get(j+1)+j);
				    
				   }
				    i++;
				    j=0;
				   
				}
				  
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
		public ArrayList<String> alphabetic_order(ArrayList<String> lista) {
			Collections.sort(lista);
			return lista;
		}
	
	
}
	


