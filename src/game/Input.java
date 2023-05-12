package game;

import java.util.Scanner;

public class Input {
	
	static Scanner scanner = new Scanner(System.in);
	
	/*
	 * Método "read(int userChoices)": Este método lê um valor inteiro digitado pelo usuário. 
	 * Ele recebe um parâmetro "userChoices" que representa o número máximo de escolhas válidas que o usuário pode fazer. 
	 * O método exibe "->" como prompt e solicita ao usuário que digite um valor. 
	 * Em seguida, ele tenta converter a entrada em um valor inteiro usando o método "parseInt" da classe "Integer". 
	 * Se a conversão for bem-sucedida, o método retorna o valor inteiro digitado pelo usuário. 
	 * Caso contrário, se ocorrer uma exceção durante a conversão, o valor de entrada é definido como -1 e uma mensagem é 
	 * exibida solicitando ao usuário que insira um número inteiro válido. O método continua pedindo uma entrada até que 
	 * um valor válido seja fornecido dentro do intervalo de 1 a "userChoices".
	 */
	public static int read(int userChoices) {
		int input;
		String s = "->";
		
		do{
			System.out.print(s + " ");
			try{
				input = Integer.parseInt(scanner.next());
			}
			catch(Exception e){
				input = -1;
				System.out.println("Por favor insira apenas números.");
			}
		}while(input < 1 || input > userChoices);
		return input;
	}
	
	/*
	 * Método "anythingToContinue()": Este método exibe uma mensagem para o usuário solicitar que ele insira qualquer 
	 * coisa para continuar. Em seguida, ele aguarda a entrada do usuário usando o método "next()" do objeto "scanner".
	 */
	public static void anythingToContinue() {
		System.out.println("\nInsira qualquer coisa para continuar...");
		Input.scanner.next();
	}
}