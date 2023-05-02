package Modelo.DTO;

import java.util.Date;

public class Apoderado {
    
    private String dniApd;
    private String apPatApd;
    private String apMatApd;
    private String nomApd;
    private String sgNomApd;
    private Date fecNacApd;

    public Apoderado() {
    }

    public Apoderado(String dniApd, String apPatApd, String apMatApd, String nomApd, String sgNomApd, Date fecNacApd) {
        this.dniApd = dniApd;
        this.apPatApd = apPatApd;
        this.apMatApd = apMatApd;
        this.nomApd = nomApd;
        this.sgNomApd = sgNomApd;
        this.fecNacApd = fecNacApd;
    }

    public String getDniApd() {
        return dniApd;
    }

    public void setDniApd(String dniApd) {
        this.dniApd = dniApd;
    }

    public String getApPatApd() {
        return apPatApd;
    }

    public void setApPatApd(String apPatApd) {
        this.apPatApd = apPatApd;
    }

    public String getApMatApd() {
        return apMatApd;
    }

    public void setApMatApd(String apMatApd) {
        this.apMatApd = apMatApd;
    }

    public String getNomApd() {
        return nomApd;
    }

    public void setNomApd(String nomApd) {
        this.nomApd = nomApd;
    }

    public String getSgNomApd() {
        return sgNomApd;
    }

    public void setSgNomApd(String sgNomApd) {
        this.sgNomApd = sgNomApd;
    }

    public Date getFecNacApd() {
        return fecNacApd;
    }

    public void setFecNacApd(Date fecNacApd) {
        this.fecNacApd = fecNacApd;
    }
    
}
