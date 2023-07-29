import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private String dato;
    private List<Arista> listaAristas;


    public Nodo(String valor){
        this.dato=valor;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String valor) {
        this.dato = valor;
    }

    public List<Arista> getAristas() {
        return listaAristas;
    }

    public void setAristas(Arista arista) {
        if (listaAristas == null){
            listaAristas = new ArrayList<>();
        }
        listaAristas.add(arista);
    }
    @Override
    public String toString(){
        return "\n \t[Vertice=" + dato + ", Lista de aristas" + listaAristas + "]";
    }
}
