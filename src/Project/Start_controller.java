package Project;

import javax.swing.JOptionPane;

public class Start_controller {
	private String pathString;
	private String pathString_CSV;
	private String name_file_CSV;

	public String getPathString() {
		return pathString;
	}

	public void setPathString(String pathString) {
		this.pathString = pathString;
	}
	public String getPathString_CSV() {
		return pathString_CSV;
	}

	public void setPathString_CSV(String pathString_CSV) {
		this.pathString_CSV = pathString_CSV;
	}
	public String getName_file_CSV() {
		return name_file_CSV;
	}

	public void setName_file_CSV(String name_file_CSV) {
		this.name_file_CSV = name_file_CSV;
	}


	public void start() {
		try {
			setPathString(JOptionPane.showInputDialog("Enter the file path:"));
			setPathString_CSV(JOptionPane.showInputDialog("Enter the path of the .CSV file you want to save:"));
			setName_file_CSV(JOptionPane.showInputDialog("The file name:"));
			Receive_datas data = new Receive_datas();
			data.get_data_archives(getPathString());
			data.process_elements(); //Processing the elements from file path.
			Write_Datas write_file_csv = new Write_Datas(data.getGraph_of_words(), data.getAlphabetical_Order()); //
			write_file_csv.write_words(getPathString_CSV(),getName_file_CSV());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro:" + e);
		}

	}

}
