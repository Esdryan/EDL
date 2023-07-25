package ArvoreBinaria;

import java.util.ArrayList;
import java.util.Iterator;

public class No implements INo{
    
    private Object chave;
    private No pai;
    private No filhoEsquerdo;
    private No filhoDireito;
    private ArrayList filhos = new ArrayList();
    
    //Construtor
    public No(No p, Object o){
        pai = p;
        chave = o;
    }

    @Override
    public No getFilhoDireito() {
        return filhoDireito;
    }

    @Override
    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    @Override
    public No getPai() {
        return pai;
    }

    @Override
    public Object getChave() {
        return chave;
    }

    @Override
    public void setFilhoDireito(No fD) {
        filhoDireito = fD;
    }

    @Override
    public void setFilhoEsquerdo(No fE) {
        filhoEsquerdo = fE;
    }

    @Override
    public void setPai(No father) {
        pai = father;
    }

    @Override
    public void setChave(Object ch) {
        chave = ch;
    }
    
    public void addChild(No o){
        filhos.add(o);
    }
    
    public void rmChild(No o){
        filhos.remove(o);
    }
    
    public int childrenNumber(){
        return filhos.size();
    }
    
    public Iterator children(){
        return filhos.iterator();
    }
}