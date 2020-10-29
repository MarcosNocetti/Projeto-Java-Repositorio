package Project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



public class Receive_datas {
	
	private ArrayList<String> listWords = new ArrayList<>(); //Instanciando o ArrayList com a class words
	private ArrayList<String> formatedList = new ArrayList<>(); //lista das palavras formatadas (sem acento, etc...)
	
	
	public List<String> sem_duplicacao() {
		Set<String> semDuplicidade = new LinkedHashSet<>(getFormatedList());
		List<String> list = new ArrayList<>(semDuplicidade);//Transformei em lista novamente para conseguir utilizar o .get(0)
		return list;
	}
	
	
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


		public void setFormatedList(ArrayList<String> arrayList) {
		this.formatedList = (ArrayList<String>) arrayList;
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
		

			System.out.println(getlistWords());//exibindo as palavras da lista formatada
			System.out.println(getFormatedList());//exibindo as palavras da lista formatada
			System.out.println(sem_duplicacao());//Exibindo palavras da lista em ordem alfabetica sem repetição
			//System.out.println(getlistWords().size());
			//System.out.println(sem_duplicacao().size());
			
			//For percorrendo a ListWords inteira, salvando os indices de ocorrencias da palavra com em um array.
		int count =0;
		int cont_ocorrencias= 0;
		int cont_repeticao =0;
		 ArrayList<Integer> posicoes_vetor = new ArrayList<>();
		 ArrayList<String> palavras = new ArrayList<>();
			while(count < sem_duplicacao().size()) {
				cont_ocorrencias =0;
				cont_repeticao=0;
				posicoes_vetor.clear();
				palavras.clear();
				//System.out.println(posicoes_vetor);
				for(int i=0; i<getlistWords().size()-1;i++) {//Procurar e salvar os indices da primeira palavra
					if(sem_duplicacao().get(count).equals(getlistWords().get(i))) {
						posicoes_vetor.add(i);
						cont_ocorrencias++;
						//System.out.println("Entrou aqui2.");
					}
				}
				if(cont_ocorrencias==1) {
					System.out.println(sem_duplicacao().get(count)+","+getlistWords().get(posicoes_vetor.get(0)+1));
					//System.out.println("Entrou aqui.3");
				}
				else {
					for(int i=0;i<cont_ocorrencias;i++) {
						//System.out.println("Entrou aqui.4");
						if(cont_repeticao == 0) {
							System.out.print(sem_duplicacao().get(count)+",");
							System.out.print(getlistWords().get(posicoes_vetor.get(i)+1));
							palavras.add(getlistWords().get(posicoes_vetor.get(i)+1));
							cont_repeticao++;
						}
						//getlistWords().get(posicoes_vetor.get(i)+1).equals(getlistWords().get(posicoes_vetor.get(i-1)+1))
						else if(palavras.contains(getlistWords().get(posicoes_vetor.get(i)+1))) {
							continue;
						}
						else {
							System.out.print(","+getlistWords().get(posicoes_vetor.get(i)+1));
							palavras.add(getlistWords().get(posicoes_vetor.get(i)+1));
						}
					}
					System.out.println();
				}
				count++;	
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
	


