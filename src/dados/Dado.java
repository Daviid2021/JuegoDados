package dados;

public class Dado{
    private final int valor;
    public Dado(){
        this.valor=(int) (Math.random()*6+1);
    }
    public int getValor() {
        return valor;
    }
}
