
package Modelo.DTO;

import java.util.Date;

public class Docente {
    
    private String dniDct;
    private String apPatDct;
    private String apMatDct;
    private String nomDct;
    private String sgNomDct;
    private Date fecNacDct;

    public Docente() {
    }

    public Docente(String dniDct, String apPatDct, String apMatDct, String nomDct, String sgNomDct, Date fecNacDct) {
        this.dniDct = dniDct;
        this.apPatDct = apPatDct;
        this.apMatDct = apMatDct;
        this.nomDct = nomDct;
        this.sgNomDct = sgNomDct;
        this.fecNacDct = fecNacDct;
    }

    public String getDniDct() {
        return dniDct;
    }

    public void setDniDct(String dniDct) {
        this.dniDct = dniDct;
    }

    public String getApPatDct() {
        return apPatDct;
    }

    public void setApPatDct(String apPatDct) {
        this.apPatDct = apPatDct;
    }

    public String getApMatDct() {
        return apMatDct;
    }

    public void setApMatDct(String apMatDct) {
        this.apMatDct = apMatDct;
    }

    public String getNomDct() {
        return nomDct;
    }

    public void setNomDct(String nomDct) {
        this.nomDct = nomDct;
    }

    public String getSgNomDct() {
        return sgNomDct;
    }

    public void setSgNomDct(String sgNomDct) {
        this.sgNomDct = sgNomDct;
    }

    public Date getFecNacDct() {
        return fecNacDct;
    }

    public void setFecNacDct(Date fecNacDct) {
        this.fecNacDct = fecNacDct;
    }
    
    
}
