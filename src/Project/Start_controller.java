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


	public  void start () {
	try {
		setPathString(JOptionPane.showInputDialog("Enter the file path:"));
		Receive_datas data = new Receive_datas();
		data.get_data_archives(getPathString());
		data.see_elements(); //mostra a lista somente formatada (sem ser na ordem alfabetica)
		data.see_alphabetic_list(); //mostra a lista na ordem alfabetica

	} catch (Exception e) {
		System.out.println("Error: " + e.getMessage());
	}
	
	}
		
}
	   
	    
	
