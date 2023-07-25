package ArvoreBinaria;

import java.util.ArrayList;
import java.util.Iterator;

public class testeArvoreBinaria {
    public static void main(String[] args) throws SameElement{
        
        //0 para comparar inteiros e 1 para comparar strings pelo tamanho
        Comparador c = new Comparador(0);
        
        ArvoreBinaria AB = new ArvoreBinaria(c, 6);
        System.out.println("Nó Raiz: "+AB.getRaiz().getChave());
                
        AB.incluir(2);
        AB.incluir(9);
        AB.incluir(1);
        AB.incluir(4);
        AB.incluir(8);
        AB.incluir(11);
        AB.incluir(3);
        AB.incluir(5);
        
        System.out.println("A profundidade do meu Nó ("+AB.getRaiz().getFilhoEsquerdo().getChave()+") é: "+AB.profundidade(AB.getRaiz().getFilhoEsquerdo()));
        System.out.println("O número de filhos do Nó ("+AB.getRaiz().getChave()+") é: "+AB.getRaiz().childrenNumber());
        System.out.println("Altura da AB: "+AB.altura(AB.getRaiz()));
        System.out.println("Quantidade de Elementos: "+AB.size());
        
        AB.remover(2);
        
        System.out.println();
        System.out.println("PreOrdem");
        ArrayList<Object> o;
        o = AB.preOrdem(AB.getRaiz());
        for(int j=0; j<o.size(); j++){
            System.out.print(((No) o.get(j)).getChave()+" ");
        }
        System.out.println();
        
        System.out.println();
        System.out.println("EmOrdem");
        ArrayList<Object> o2;
        o2 = AB.emOrdem(AB.getRaiz());
        for(int j=0; j<o2.size(); j++){
            System.out.print(((No) o2.get(j)).getChave()+" ");
        }
        System.out.println();
        
        System.out.println();
        System.out.println("PosOrdem");
        ArrayList<Object> o1;
        o1 = AB.posOrdem(AB.getRaiz());
        for(int j=0; j<o1.size(); j++){
            System.out.print(((No) o1.get(j)).getChave()+" ");
        }
        System.out.println();
        
        /*
        //Mostrar os elementos da arvore com preOrdem.
        System.out.println("Elements");
        Iterator i = AB.elements();
        while(i.hasNext()) {
            System.out.print(i.next()+" ");
        }
        */
    }
}