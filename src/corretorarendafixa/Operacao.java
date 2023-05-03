package corretorarendafixa;
 
import java.util.Calendar;

public interface Operacao {
    
    public void mostrar();
    
    public int getId();

    public Calendar getData();

    public double getValor();

    public String getTipo();

    public void setId(int id);
    
    public void setData(Calendar data);

    public void setValor(double valor);

    public void setTipo(String tipo);
}