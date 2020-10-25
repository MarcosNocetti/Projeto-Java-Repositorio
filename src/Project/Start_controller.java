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
	setPathString(JOptionPane.showInputDialog("Digite o caminho do arquivo:"));
	receber_dados dados = new receber_dados();
	dados.pegar_dados_arq(getPathString());
	dados.exibir_elementos();
	}
		
}
	   
	    
	
