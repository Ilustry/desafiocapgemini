package desafiocapgemini;

import java.io.IOException;
import java.util.Scanner;

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
		
		int opcao = 0, paramInt = 0;
		String paramString = "";
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
			opcao = scan.nextInt();
			System.out.print("");
			
			scan = new Scanner(System.in);
			switch (opcao) {
			case 1:
				System.out.println("Informe o valor.");
				paramInt = scan.nextInt();
				questao1(paramInt);
				break;
			case 2:
				System.out.println("Informe a senha.");
				paramString = scan.nextLine();
				questao2(paramString);
				break;
			case 3:
				System.out.println("Informe a palavra.");
				paramString = scan.nextLine();
				System.out.println("Anagramas encontrados: "+ questao3(paramString));
				break;
			case 0:
				scan.close();
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			if(opcao != 0) {
				System.out.println("Pressione enter para continuar.");
				System.in.read();
				scan = new Scanner(System.in);
			}
		} while (opcao != 0);
		
	}

}
