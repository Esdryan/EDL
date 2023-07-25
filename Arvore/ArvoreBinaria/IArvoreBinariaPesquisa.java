package ArvoreBinaria;

import java.util.ArrayList;
import java.util.Iterator;

public interface IArvoreBinariaPesquisa {

	void setComparator(Comparador c);

	Comparador getComparador();

	No pesquisar(No no, Object key);

	No incluir(Object key)throws SameElement;

	Object remover(Object key);

	No getRaiz();

	void setRaiz(No p);

	ArrayList<Object> emOrdem(No no);

	ArrayList<Object> preOrdem(No no);

	ArrayList<Object> posOrdem(No no);

	int altura(No no);

	int profundidade(No no);

	void mostrar();

	Iterator nos();

	Iterator elements();

	int size();

	boolean isEmpty();

}