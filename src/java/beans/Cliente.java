package beans;
public class Cliente {
    private String codc;
    private String ape;
    private String nom;
    private String clave;
    public Cliente() {
    }

    public Cliente(String codc, String ape, String nom, String clave) {
        this.codc = codc;
        this.ape = ape;
        this.nom = nom;
        this.clave = clave;
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
     * @return the ape
     */
    public String getApe() {
        return ape;
    }

    /**
     * @param ape the ape to set
     */
    public void setApe(String ape) {
        this.ape = ape;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
   
   
   
   
}
