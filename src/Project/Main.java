package Project;

/* BufferedReader -> Gerencia a mem�ria para leitura
FileReader -> Classe padr�o para ler uma String de dados */
public class Main {
	public static void main(String[] args) {
		try {
			Start_controller start_controller = new Start_controller();
			start_controller.start();
		} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
		}
		

		
	}
}
