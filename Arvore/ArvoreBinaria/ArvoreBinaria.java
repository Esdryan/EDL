package ArvoreBinaria;

import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreBinaria implements IArvoreBinariaPesquisa{
    
    private No raiz;
    private int qtdElementos;
    private Comparador comparador;
    private ArrayList<Object> aPreO, aPosO, aEmO;
    
    //Construtor
    public ArvoreBinaria(Comparador c, Object root){
        raiz = new No(null, root);
        qtdElementos = 1;
        setComparator(c);
    }
    
    @Override
    public void setComparator(Comparador c) {
        comparador = c;
    }

    @Override
    public Comparador getComparador() {
        return comparador;
    }
    
    @Override
    public No pesquisar(No no, Object key){
        No temp = new No(null, key);
        int res = getComparador().Comparar(temp, no);
        
        if(!(hasLeft(no) && hasRight(no))){
            return no;
        }
        
        if(res < 0){
            return pesquisar(no.getFilhoEsquerdo(), key);
        }
        else if(key == no.getChave()){
            return no;
        }
        //res > 0
        else{
            return pesquisar(no.getFilhoDireito(), key);
        }
    }

    @Override
    public No incluir(Object key) throws SameElement{
        
        No mykey = new No(null, key);
        No encontrei = pesquisar(raiz, key);
        
        int res = getComparador().Comparar(mykey, encontrei);
        
        if(res == 0){
            return encontrei;
        }
        else if(res > 0){
            encontrei.setFilhoDireito(mykey);
            mykey.setPai(encontrei);
            qtdElementos++;
            encontrei.addChild(mykey);
            return mykey;
        }
        //res < 0
        else{
            encontrei.setFilhoEsquerdo(mykey);
            mykey.setPai(encontrei);
            qtdElementos++;
            encontrei.addChild(mykey);
            return mykey;
        }
    }

    @Override
    public Object remover(Object key){
        
        ArrayList<Object> o;
        o = emOrdem(pesquisar(raiz, key).getFilhoDireito());
        No r = (No) o.get(0);
        
        Object temp = pesquisar(raiz, 2).getChave();
        pesquisar(raiz, 2).setChave(r.getChave());
        
        r.getPai().rmChild(r);
        
        qtdElementos--;
        
        return temp;
    }
    
    @Override
    public No getRaiz() {
        return raiz;
    }

    @Override
    public void setRaiz(No p) {
        if(qtdElementos == 0){
            raiz = p;
            qtdElementos++;
        }
        else{
            raiz.setChave(p.getChave());
        }
    }

    @Override
    public ArrayList<Object> emOrdem(No no) {
        aEmO = new ArrayList<Object>();
        return emOrdemLocal(no);
    }

    public ArrayList<Object> emOrdemLocal(No no){
        if(isInternal(no)){
            emOrdemLocal(leftChild(no));
        }
        aEmO.add(no);
        if(isInternal(no)){
            emOrdemLocal(rightChild(no));
        }
        return aEmO;
    }
    
    @Override
    public ArrayList<Object> preOrdem(No no){
        aPreO = new ArrayList<Object>();
        return preOrdemLocal(no);
    }
    
    private ArrayList<Object> preOrdemLocal(No no){
        aPreO.add(no);
        if(no.childrenNumber() > 0){
            Iterator i = no.children();
            while(i.hasNext()) {
                preOrdemLocal((No)i.next());
            }
        }
        return aPreO;
    }

    @Override
    public ArrayList<Object> posOrdem(No no){
        aPosO = new ArrayList<Object>();
        return posOrdemLocal(no);
    }
    
    public ArrayList<Object> posOrdemLocal(No no) {
        if(isInternal(no)){
            Iterator i = no.children();
            while(i.hasNext()){
                posOrdemLocal((No)i.next());
            }
        }
        aPosO.add(no);
        
        return aPosO;
    }

    //Retorna a altura de um No
    @Override
    public int altura(No no) {
        if(isExternal(no)){
            return 0;
        }
        else{
            int height = 0;
            
            Iterator i = no.children();
            while(i.hasNext()){
                height = Math.max(height, altura((No) i.next()));
            }
            return 1+height;
        }
    }
    
    //Testa se um No é interno
    public boolean isInternal(No no){
        return hasLeft(no) == true || hasRight(no) == true;
    }

    //Testa se um No é externo
    public boolean isExternal(No no){
        return hasLeft(no) == false && hasRight(no) == false;
    }
    
    //Retorna a profundidade de um No
    @Override
    public int profundidade(No no) {
        int profundidadeRecursiva = profundidadeRecursiva(no);
        return profundidadeRecursiva;
    }
    
    private int profundidadeRecursiva(No no){
        if (no == raiz){
            return 0;
        }
        else{
            return 1 + profundidade(no.getPai());
        }
    }
    
    //Retorna um iterador com todos os nos
    @Override
    public Iterator nos() {
        ArrayList<Object> o = new ArrayList<Object>();
        ArrayList <Object> ar = new ArrayList();
        o = preOrdem(raiz);
        for(int i=0; i<o.size(); i++){
            ar.add((No) o.get(i));
        }
        return ar.iterator();
    }

    //Retorna um iterador com todos os elementos
    @Override
    public Iterator elements() {
        ArrayList<Object> o;
        ArrayList <Object> ar = new ArrayList();
        o = preOrdem(raiz);
        for(int i=0; i<o.size(); i++){
            Object r = ((No) o.get(i)).getChave();
            ar.add(r);
        }
        return ar.iterator();
    }
    
    //Retorna a quantidade de elementos
    @Override
    public int size() {
        return qtdElementos;
    }

    //Retorna se a arvore está vazia ou nao
    @Override
    public boolean isEmpty() {
        return raiz == null;
    }

    public No leftChild(No no){
        return no.getFilhoEsquerdo();
    }
    
    public No rightChild(No no){
        return no.getFilhoDireito();
    }
    
    public boolean hasLeft(No no){
        return no.getFilhoEsquerdo() != null;
    }
    
    public boolean hasRight(No no){
        return no.getFilhoDireito() != null;
    }
    
    @Override
    public void mostrar() {
    
    }
    
}