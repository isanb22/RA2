package MainArvore;
//Node usado na Árvore Binária:

public class Node {
 private int informacao;
 private Node proximoDireita;
 private Node proximoEsquerda;
 private Node anterior;
 
 public Node() {
     informacao = 0;
     proximoDireita = null;
     proximoEsquerda = null;
     anterior = null;
 }
 
 
 // -------------- Metodos: -------------- //
 // Sets:
 public void setInfo(int informacao)
 {
     this.informacao = informacao;
 }
 
 public void setDireita(Node direita)
 {
     this.proximoDireita = direita;
 }
 
 public void setEsquerda(Node esquerda)
 {
     this.proximoEsquerda = esquerda;
 }
 
 public void setAnterior(Node anterior)
 {
     this.anterior = anterior;
 }
 
 // Gets:
 public Node getDireita() 
 {
     return proximoDireita;
 }
 
 public Node getEsquerda() 
 {
     return proximoEsquerda;
 }
 
 public Node getAnterior() 
 {
     return anterior;
 }
 
 public int getInfo()
 {
     return informacao;
 }
 
 // Print da info:
 public void printInfo() 
 {
     System.out.println("    -> " + informacao);
 }

}