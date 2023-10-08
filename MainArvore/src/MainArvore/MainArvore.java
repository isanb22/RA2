package MainArvore;

import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("resource")

public class MainArvore {
	
	private static Arvore binaria = new Arvore();
	private static int tam = 0;
	
	public static void main(String[] args)
	{
		int escolha = -1;
		int info = 0;
		Random gerador = new Random();
		Scanner scanner = new Scanner(System.in);
		
		// Gerando a arvore:
		menus(1);
		tam = scanner.nextInt();
		
		long tempoInicio = System.currentTimeMillis();
		
        for (int i = 0; i < tam; i++) {
            int num = 1 + gerador.nextInt(tam * 2);
            System.out.print("Numero Gerado: " + num + "   ");
            binaria.adicionar(num);
        } LineBreak();
        
        long tempoFinal = System.currentTimeMillis();
        
        System.out.println("Arvore gerada em: " + (tempoFinal - tempoInicio) + " milissegundos");
        
        System.out.println("Arvore gerada!");
        //binaria.print_EmOrdem(binaria.getRaiz());
        
        // Escolher:
        while (escolha != 0)
        {
        	menus(2);
        	escolha = scanner.nextInt();
        	
        	// ----------------------- Adicionar:
        	if (escolha == 1)
        	{
        		System.out.print("Digite o valor do node: ");
        		info = scanner.nextInt();
        		binaria.adicionar(info);
        	}
        	
        	// ----------------------- Printar:
        	else if (escolha == 2)
        	{
        		menus(3);
        		int printar = scanner.nextInt();
        		if (printar == 1) {
        			System.out.println("Printando arvore Em_Ordem: ");
                    binaria.print_EmOrdem(binaria.getRaiz());        			
        		}
        		else if(printar == 2) {
        			System.out.println("Printando arvore em Pre_Ordem: ");
                    binaria.print_PreOrdem(binaria.getRaiz());
        		}
        		else if(printar == 3) {
        			System.out.println("Printando arvore em Pos_Ordem: ");
                    binaria.print_PosOrdem(binaria.getRaiz());
        		}
                
        	}
        	
        	// ----------------------- Busca:
        	else if (escolha == 3) 
        	{
        		System.out.print("Digite o valor do node: ");
        		info = scanner.nextInt();
        		LineBreak();
        		
        		tempoInicio = System.nanoTime();
        		
        		Node node = binaria.busca(info);
        		
        		if (node != null)
        		{
    				System.out.println("Node: " + node);
        		}
        		
        		tempoFinal = System.nanoTime();
                System.out.println("Tempo decorrido " + (tempoFinal - tempoInicio) + " nanossegundos (" + ((tempoFinal - tempoInicio)/1000) + " milissegundos)");
        		
        	}
        	
        	// ----------------------- Remover:
        	else if (escolha == 4)
        	{
                System.out.print("Digite o valor que gostaria de deletar: ");
                info = scanner.nextInt();
                
                tempoInicio = System.nanoTime();
                
                binaria.remover(info);
                
                tempoFinal = System.nanoTime();
                System.out.println("Tempo decorrido " + (tempoFinal - tempoInicio) + " nanossegundos (" + ((tempoFinal - tempoInicio)/1000) + " milissegundos)");
        	}
        	
        	LineBreak();
        	LineBreak();
        }
        
            
        menus(4);
        
	}	
	
	public static void menus(int escolha)
	{
		if (escolha == 1)
		{
			System.out.println("=======================================");
			System.out.println("= Trabalho feito por:                 =");
			System.out.println("= - Isabela Navarro Benedetti         =");
			System.out.println("= - Lucas Galves Simoes               =");
			System.out.println("= - João Vitor Zambão                 =");
			System.out.println("=-------------------------------------=");
			LineBreak();
			System.out.println(" Qual seria o tamanho da arvore? ");
			System.out.print  ("   => ");
		}
		else if (escolha == 2)
		{
			System.out.println("=-------------------------------------=");
			System.out.println("=     * O que gostaria de fazer? *    =");
			System.out.println("= 1 - Adicionar um item               =");
			System.out.println("= 2 - Printar a arvore                =");
			System.out.println("= 3 - Encontrar o endereco de um item =");
			System.out.println("= 4 - Remover um item                 =");
			System.out.println("= 0 - Sair do programa                =");
			System.out.println("=-------------------------------------=");
			System.out.print  ("   => ");
		}
		else if (escolha == 3)
		{
			System.out.println("=-------------------------------------=");
			System.out.println("=     *Escolha a forma de printar*    =");
			System.out.println("= 1 - Em Ordem                        =");
			System.out.println("= 2 - Pre Ordem                       =");
			System.out.println("= 3 - Pos Ordem                       =");
			System.out.println("=-------------------------------------=");	
			System.out.print  ("   => ");
		}
		else if (escolha == 4)
		{
			System.out.println("=-------------------------------------=");
			System.out.println("=        * Fechando programa *        =");
			System.out.println("=======================================");		
		}
		
	}
	
	public static void LineBreak() {System.out.println();}
}
