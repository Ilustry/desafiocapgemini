package desafiocapgemini;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class questoes {
	
	public static void questao1(int valor) {

		for(int i = 0; i < valor; i++) {
			for(int j = valor; j > i; j--) {
				System.out.print(" ");
				
			}
			for(int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void questao2(String senha) {
		
		String regexDigito = ".*\\d.*";
		String regexMinusculo = ".*[a-z].*";
		String regexMaiusculo = ".*[A-Z].*";
		String regexEspecial = ".*[!@#$%\\^&\\*()\\-\\+].*";
		boolean chave = false;
		
		if(!(senha.matches(regexDigito))){
			System.out.println("A senha deve conter pelo menos 1 dígito.");
			chave = true;
		}
		if(!(senha.matches(regexMinusculo))){
			System.out.println("A senha deve conter pelo menos 1 letra em minúsculo.");
			chave = true;
		}
		if(!(senha.matches(regexMaiusculo))){
			System.out.println("A senha deve conter pelo menos 1 letra em maiúsculo.");
			chave = true;
		}
		if(!(senha.matches(regexEspecial))){
			System.out.println("A senha deve conter pelo menos 1 caractere especial entre !@#$%^&*()-+.");
			chave = true;
		}
		
		if(senha.length() < 6) {
			chave = true;
			System.out.print("A senha necessita de mais "+ (6 - senha.length()));
			if(6 - senha.length() > 1) {
				System.out.println(" caracteres.");
			} else {
				System.out.println(" caractere.");
			}
		}
		
		if(chave == false) {
			System.out.println("Senha forte.");
		}
		
	}
	
	public static int questao3(String str) {
		String temp = "";
        String aux = "";
        String letra = "";
        String letra2 = "";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                temp = str.substring(i, j);
                if(j != str.length())
                if (temp.length() >= 2) {
                	if(j != str.length())
                	aux = str.substring(i+1, j+1);
                	for(int k = 0, chave = 0; k < temp.length(); k++) {
                		if(aux.contains(String.valueOf(temp.charAt(k)))) {
                			letra = String.valueOf(temp.charAt(k));
            				chave++;
            				temp = temp.replaceFirst(letra, ",");
            				aux = aux.replaceFirst(letra, ",");
            				if(chave == temp.length()) {
            					count++;
            				}
                		}
                		
                	}
                } else if(temp.length() < 2 && !(letra2.contains(temp))){
                	letra2 += temp;
                	if(str.length() - str.replace(temp, "").length() > 1) {
                		count++;
                	}
                }
            }
        }

        return count;
	}

	public static void main(String[] args) throws IOException {
		
		String opcao = "";
		String param = "";
		
		try {
			Scanner scan = new Scanner(System.in);
			do {
				System.out.println("");
				System.out.println("\n                =========================");
				System.out.println("                |     1 - Questão 1     |");
				System.out.println("                |     2 - Questão 2     |");
				System.out.println("                |     3 - Questão 3     |");
				System.out.println("                |     0 - Sair          |");
				System.out.println("                =========================\n");
				
				System.out.println("\nSelecione uma opção.");
				opcao = scan.nextLine();
				System.out.print("");
				
				switch (opcao) {
				case "1":
					System.out.println("Informe o valor.");
					param = scan.nextLine();
					questao1(Integer.parseInt(param));
					break;
				case "2":
					System.out.println("Informe a senha.");
					param = scan.nextLine();
					questao2(param);
					break;
				case "3":
					System.out.println("Informe a palavra.");
					param = scan.nextLine();
					System.out.println("Anagramas encontrados: "+ questao3(param));
					break;
				case "0":
					scan.close();
					break;
				}
				if(Integer.parseInt(opcao) > 0 && Integer.parseInt(opcao) < 4) {
					System.out.println("\nPressione enter para continuar.");
					scan.nextLine();
				}
				scan = new Scanner(System.in);
			} while (Integer.parseInt(opcao) != 0);
			
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
