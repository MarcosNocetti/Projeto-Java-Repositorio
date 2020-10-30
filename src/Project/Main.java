package Project;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		try {
			Start_controller start_controller = new Start_controller();
			start_controller.start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error:" + e);
		}
	}
}
