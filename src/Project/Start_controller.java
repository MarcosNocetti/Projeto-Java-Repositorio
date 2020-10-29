package Project;

import javax.swing.JOptionPane;

public class Start_controller {
	private String pathString;

	public String getPathString() {
		return pathString;
	}

	public void setPathString(String pathString) {
		this.pathString = pathString;
	}

	public void start() {
		try {
			setPathString(JOptionPane.showInputDialog("Enter the file path:"));
			Receive_datas data = new Receive_datas();
			data.get_data_archives(getPathString());
			data.process_elements(); //Processing the elements from file path.
			Write_Datas write_file_csv = new Write_Datas(data.getGraph_of_words(), data.getAlphabetical_Order()); //
			write_file_csv.write_words();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro:" + e);
		}

	}

}
