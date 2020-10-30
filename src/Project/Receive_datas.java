package Project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Receive_datas {
	
	private ArrayList<String> Graph_of_words = new ArrayList<>();
	private ArrayList<String> Alphabetical_Order = new ArrayList<>();

	public String format_words(String words) {
		return words.toLowerCase();
	}

	public ArrayList<String> getGraph_of_words() {
		return Graph_of_words;
	}

	public void setGraph_of_words(ArrayList<String> Graph_of_words) {
		this.Graph_of_words = Graph_of_words;
	}

	public ArrayList<String> getAlphabetical_Order() {
		return Alphabetical_Order;
	}

	public void setAlphabetical_Order(ArrayList<String> arrayList) {
		this.Alphabetical_Order = arrayList;
	}

	public ArrayList<String> alphabetic_order(ArrayList<String> list) {
		Collections.sort(list);
		return list;
	}

	public void get_data_archives(String path) {
		// ------------------- Getting data from file.txt-------------------------
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"))) {
			String line = br.readLine();
			while (line != null) {
				// ------------------- Removing punctuation-------------------------	
				
				line = br.readLine();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Error:" + e);
		}
	}

	public void process_elements() {
		try {
			// ------------------- Lowercase Words -------------------------
			for (int i = 0; i < getGraph_of_words().size(); i++) {
				getGraph_of_words().set(i, format_words(getGraph_of_words().get(i)));
				getAlphabetical_Order().add(i, getGraph_of_words().get(i));
			}
			// ------------------- Alphabetical order-------------------------
			setAlphabetical_Order(alphabetic_order(getAlphabetical_Order()));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error:" + e);
		}

	}

}
