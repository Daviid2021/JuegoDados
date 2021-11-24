package dados;


import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int lanzamiento;
    private int cantDados;
    private ArrayList listaDados;
    private int valorTotal;
    public Jugador(){
        cantDados=2;
        listaDados=null;
        valorTotal=0;
        lanzamiento=1;
        nombre="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }
    private void crearDados() {
        listaDados = new ArrayList();
        for (int i = 0; i < cantDados; i++) {
            Dado d = new Dado();         
            listaDados.add(d);            
        }        
    }
    public int lanzarDados(){
        crearDados();
         for (int i = 0; i < listaDados.size(); i++) {
            Dado d = (Dado) listaDados.get(i);
            valorTotal+=d.getValor();
        }
         return valorTotal;
    }
    public int dadoIndividual(int num){
        Dado d = (Dado) listaDados.get(num);
        return d.getValor();
    }
    public void reiniciarDados(){
        listaDados.clear();
        valorTotal=0;
    }
}