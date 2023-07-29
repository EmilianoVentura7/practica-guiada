public class Arista {
    private Nodo inicio;
    private Nodo fin;
    private int peso;

    public Arista(Nodo origen, Nodo destino, int valor){
        inicio = origen;
        fin = destino;
        peso = valor;
    }
    public Nodo getInicio() {
        return inicio;
    }
    public void setInicio(Nodo origen) {
        inicio = origen;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo destino) {
        fin = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int valor) {
        peso = valor;
    }
    @Override
    public String toString(){
        return "[NodoInicio=" + inicio.getDato()+ ", NodoFin="+ fin.getDato()+ "]";
    }
}
