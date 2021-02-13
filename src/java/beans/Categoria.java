package beans;
public class Categoria {
    private String codc;
    private String nomc;
    private String imagen;
    
    
    
    
    public Categoria() {
    }
    public Categoria(String codc, String nomc, String imagen) {
        this.codc = codc;
        this.nomc = nomc;
        this.imagen = imagen;
    }

    /**
     * @return the codc
     */
    public String getCodc() {
        return codc;
    }

    /**
     * @param codc the codc to set
     */
    public void setCodc(String codc) {
        this.codc = codc;
    }

    /**
     * @return the nomc
     */
    public String getNomc() {
        return nomc;
    }

    /**
     * @param nomc the nomc to set
     */
    public void setNomc(String nomc) {
        this.nomc = nomc;
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
 
}
