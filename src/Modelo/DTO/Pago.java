
package Modelo.DTO;

public class Pago {
    
    private String codPag;
    private double precPag;

    public Pago() {
    }

    public Pago(String codPag, double precPag) {
        this.codPag = codPag;
        this.precPag = precPag;
    }

    public String getCodPag() {
        return codPag;
    }

    public void setCodPag(String codPag) {
        this.codPag = codPag;
    }

    public double getPrecPag() {
        return precPag;
    }

    public void setPrecPag(double precPag) {
        this.precPag = precPag;
    }
    
}
