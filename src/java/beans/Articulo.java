package beans;
public class Articulo {
 private String coda;
 private String nomart;
    private String imagen;
    private int stk;
    private double precio;
  public Articulo() {
   }
    public String getCoda() {
        return coda;
    }
    public void setCoda(String coda) {
        this.coda = coda;
    }
    public String getNomart() {
        return nomart;
    }

    public void setNomart(String nomart) {
        this.nomart = nomart;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the stk
     */
    public int getStk() {
        return stk;
    }

    /**
     * @param stk the stk to set
     */
    public void setStk(int stk) {
        this.stk = stk;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
 
}
