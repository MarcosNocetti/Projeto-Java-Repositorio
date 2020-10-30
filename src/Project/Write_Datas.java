package Project;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

public class Write_Datas {

	private ArrayList<String> Graph_of_words = new ArrayList<>();
	private ArrayList<String> Alphabetical_Order = new ArrayList<>();
	private StringBuilder builder_string = new StringBuilder();

	public Write_Datas(ArrayList<String> Graph_of_words, ArrayList<String> Alphabetical_Order) {
		super();
		this.Graph_of_words = Graph_of_words;
		this.Alphabetical_Order = Alphabetical_Order;
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

	public void setAlphabetical_Order(ArrayList<String> Alphabetical_Order) {
		this.Alphabetical_Order = Alphabetical_Order;
	}

	public StringBuilder getbuilder_string() {
		return builder_string;
	}

	public void setbuilder_string(StringBuilder builder_string) {
		this.builder_string = builder_string;
	}

	public List<String> remove_duplication() {
		Set<String> without_duplicity = new LinkedHashSet<>(getAlphabetical_Order());
		List<String> list = new ArrayList<>(without_duplicity);
		return list;
	}

	public void proper_word_outputs() {
		try {
			int count = 0;
			int count_occurrences = 0;
			int count_repetition = 0;
			ArrayList<Integer> positions_vector = new ArrayList<>();
			ArrayList<String> words = new ArrayList<>();
			while (count < remove_duplication().size()) {
				count_occurrences = 0;
				count_repetition = 0;
				positions_vector.clear();
				words.clear();
				for (int i = 0; i < getGraph_of_words().size() - 1; i++) {
					if (remove_duplication().get(count).equals(getGraph_of_words().get(i))) {
						positions_vector.add(i);
						count_occurrences++;
					}
				}
				if (count_occurrences == 1) {
					getbuilder_string().append(remove_duplication().get(count) + ","
							+ getGraph_of_words().get(positions_vector.get(0) + 1) + '\r');
				} else {
					for (int i = 0; i < count_occurrences; i++) {
						if (count_repetition == 0) {
							words.add(getGraph_of_words().get(positions_vector.get(i) + 1));
							count_repetition++;
							getbuilder_string().append(remove_duplication().get(count) + ","
									+ getGraph_of_words().get(positions_vector.get(i) + 1));
						} else if (words.contains(getGraph_of_words().get(positions_vector.get(i) + 1))) {
							continue;
						} else {
							words.add(getGraph_of_words().get(positions_vector.get(i) + 1));
							getbuilder_string().append("," + getGraph_of_words().get(positions_vector.get(i) + 1));
						}
					}
					getbuilder_string().append("\r");
				}
				count++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error:" + e);
		}
	}

	public void write_words(String pathString_CSV, String Name_file_CSV) {
		try {
			PrintWriter pWriter = new PrintWriter(
					new File(pathString_CSV)+"\\"+Name_file_CSV+".csv");
			proper_word_outputs();// Proper output
			pWriter.write(getbuilder_string().toString());
			pWriter.close();
			JOptionPane.showMessageDialog(null, "Finished writing the file: "+Name_file_CSV+" in the path"+pathString_CSV+"\\"+Name_file_CSV+".csv");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error:" + e);
		}
	}
}
