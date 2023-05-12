package game;

public class UIMethods {
	
	/*
	 * Método "clearConsole()": Este método é responsável por limpar o console, proporcionando uma aparência mais limpa 
	 * para a interface do usuário. Ele usa sequências de escape ANSI ("\033[H\033[2J") para realizar a limpeza.
	 */
	public static void clearConsole() {
		System.out.print("\033[H\033[2J");
	}
	
	/*
	 * Método "printSeparator(int n)": Este método imprime um separador composto por um determinado número de 
	 * hífens ("-"). O parâmetro "n" especifica quantos hífens serão impressos.
	 */
	public static void printSeparator(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	/*
	 * Método "printHeading(String title)": Este método imprime um título centralizado entre separadores. 
	 * Ele recebe um parâmetro "title" que representa o título a ser exibido. 
	 * O método chama o método "printSeparator" para imprimir um separador superior, imprime o título na linha seguinte e,
	 * em seguida, chama novamente o método "printSeparator" para imprimir um separador inferior
	 */
	public static void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}
}
