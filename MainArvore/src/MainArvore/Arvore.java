package MainArvore;

public class Arvore {

    private Node raiz;

    public Arvore() {
        this.raiz = null;

    }

    public Node getRaiz() {
        return raiz;
    }

    /* -------------- Adicionar Node na arvore -------------- */
    public void adicionar(int info) {

        Node novoNode = new Node();
        novoNode.setInfo(info);

        // Checa se existe uma raiz
        if (raiz == null) {
            raiz = novoNode;
        } else {
            Node atual = raiz;

            while (true) {
                // Menor (não igual) -> esqueda
                if (novoNode.getInfo() < atual.getInfo()) {
                    // Pega o proximo esquerda e compara no if acima de novo.
                    if (atual.getEsquerda() != null) {
                        atual = atual.getEsquerda();
                    }
                    // Set o node para esquerda
                    else {
                        atual.setEsquerda(novoNode);
                        break;
                    }

                }
                // Como se fosse: (novoNode.getInfo() >= atual.getInfo()) -> direita
                else {
                    if (atual.getDireita() != null) {
                        atual = atual.getDireita();
                    }
                    // Set o node para direita
                    else {
                        atual.setDireita(novoNode);
                        break;
                    }
                }

            }

            novoNode.setAnterior(atual);

        } // Else

        System.out.println("ADICIONADO!");


    }
    /* -------------- Remover Node da arvore -------------- */
    public void remover(int info) {
        Node atual = null;
        Node pai = null;

        atual = busca(info);

        if (atual == null) {
            return;
        } // Se não encontrar

        if (atual != raiz) {
            pai = atual.getAnterior();
        } // Se não for a raíz


        // Se tiver filhos a direita:
        if (atual.getDireita() != null) {
            Node temp = atual.getDireita();

            while (temp.getEsquerda() != null) {
                temp = temp.getEsquerda();
            }


            if (pai != null) {
                // Se o pai do temporario for o node que vamos deletar:
                if (atual == temp.getAnterior()) {
                    // Se o node (para deletar) for o da direita:
                    if (pai.getDireita() == atual) {
                        pai.setDireita(temp);
                        temp.setEsquerda(atual.getEsquerda());
                    }
                    // Se for o node da esquerda
                    else {
                        pai.setEsquerda(temp);
                        temp.setEsquerda(atual.getEsquerda());
                    }
                    temp.setAnterior(pai);
                }

                // Remove 11
                else {
                    atual.setInfo(temp.getInfo());
                    Node tempPai = temp.getAnterior();

                    if (temp.getDireita() == null) {
                        tempPai.setEsquerda(null);
                    } else {
                        tempPai.setEsquerda(temp.getDireita());
                        temp.getDireita().setAnterior(tempPai);
                    }

                }
            } else {
                // Se o pai do temporario for o node que vamos deletar:
                if (atual == temp.getAnterior()) {
                    temp.setEsquerda(atual.getEsquerda());
                    temp.setAnterior(null);
                    atual.getEsquerda().setAnterior(temp);

                    raiz = temp;
                } else {
                    atual.setInfo(temp.getInfo());
                    Node tempPai = temp.getAnterior();

                    if (temp.getDireita() == null) {
                        tempPai.setEsquerda(null);
                    } else {
                        tempPai.setEsquerda(temp.getDireita());
                        temp.getDireita().setAnterior(tempPai);
                    }
                }
            }
        }

        // Se tiver filhos somente a esquerda:
        else if (atual.getEsquerda() != null) {
            Node temp = atual.getEsquerda();

            while (temp.getDireita() != null) {
                temp = temp.getDireita();
            }

            if (pai != null) {
                if (atual == temp.getAnterior()) {
                    if (pai.getDireita() == atual) {
                        pai.setDireita(temp);
                    } else {
                        pai.setEsquerda(temp);
                    }
                    temp.setAnterior(pai);
                } else {
                    atual.setInfo(temp.getInfo());
                    Node tempPai = temp.getAnterior();

                    // Se o node (para deletar) for o da direita:
                    if (tempPai.getDireita() == temp) {
                        tempPai.setDireita(null);
                    }
                    // Se for o node da esquerda
                    else {
                        tempPai.setEsquerda(null);
                    }
                }
            } else {
                // Se o pai do temporario for o node que vamos deletar:
                if (atual == temp.getAnterior()) {
                    temp.setAnterior(null);

                    raiz = temp;
                } else {
                    atual.setInfo(temp.getInfo());
                    Node tempPai = temp.getAnterior();

                    if (temp.getEsquerda() == null) {
                        tempPai.setDireita(null);
                    } else {
                        temp.getEsquerda().setAnterior(tempPai);
                    }
                }
            }
        }

        // Se não tiver filhos (ta certo)
        else {
            if (pai != null) {
                // Se o node (para deletar) for o da direita:
                if (pai.getDireita() == atual) {
                    pai.setDireita(null);
                }
                // Se for o node da esquerda
                else {
                    pai.setEsquerda(null);
                }
            }
        }

        System.out.println("Node deletado");

    }

    /* --------------  Busca Node na arvore -------------- */
    public Node busca(int info) {
        Node atual = raiz;
        int count = 0;

        while (atual != null) {
            count++;

            if (atual.getInfo() == info) {
                System.out.println("Achou em " + count + " galhos percorridos");
                return atual;
            } else {
                if (atual.getInfo() > info) {
                    atual = atual.getEsquerda();
                } else {
                    atual = atual.getDireita();
                }
            }
        }

        System.out.println("Nao foi possivel achar esse node! " + count + " galhos percorridos");
        return null;

    }

    /* -------------- Métodos para printar -------------- */
    // Printar Em-Ordem:
    public void print_EmOrdem(Node atual) {
        if (atual != null) {
            print_EmOrdem(atual.getEsquerda());
            atual.printInfo();
            print_EmOrdem(atual.getDireita());
        }
    }

    public void print_PreOrdem(Node atual) {
        if (atual != null) {
            atual.printInfo();
            print_PreOrdem(atual.getEsquerda());
            print_PreOrdem(atual.getDireita());
        }
    }

    public void print_PosOrdem(Node atual) {
        if (atual != null) {
            print_PosOrdem(atual.getEsquerda());
            print_PosOrdem(atual.getDireita());
            atual.printInfo();
        }
    }


}