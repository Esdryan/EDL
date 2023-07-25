package ArvoreBinaria;

class Comparador {
    
    private int tipo;
    
    public Comparador(int t) {
        tipo = t;
    }
    
    public int Comparar(No n1, No n2){
        switch(tipo){
            case 0:
                return ComparadorDeInteiros(n1, n2);
            case 1:
                return ComparadorDeStrings(n1, n2);
            default:
                return 0;
        }
    }
    
    private int ComparadorDeInteiros(No n1, No n2) {
        int a = (int)n1.getChave();
        int b = (int)n2.getChave();
        
        if(a > b){
            return 1;
        }
        
        if(a < b){
            return -1;
        }
        
        return 0;
    }
    
    //Estou comparando pelo tamanho da string
    private int ComparadorDeStrings(No n1, No n2){
        String a = (String) n1.getChave();
        String b = (String) n2.getChave();
        
        if(a.length() > b.length()){
            return 1;
        }
        
        if(a.length() < b.length()){
            return -1;
        }
        
        return 0;
    }
}