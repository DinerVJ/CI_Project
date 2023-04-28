
package Modelo.DTO;

import java.util.Date;

public class Alumno {
    private String dniAlm;
    private String apPatAlm;
    private String apMatAlm;
    private String nomAlm;
    private String sgNomAlm;
    private Date fecNacAlm;
    private String dniApd;
    private String gradoAlm;
    private String seccionAlm;

    public Alumno(){
        
    }

    public Alumno(String dniAlm, String apPatAlm, String apMatAlm, String nomAlm, String sgNomAlm, Date fecNacAlm, String dniApd, String gradoAlm, String seccionAlm) {
        this.dniAlm = dniAlm;
        this.apPatAlm = apPatAlm;
        this.apMatAlm = apMatAlm;
        this.nomAlm = nomAlm;
        this.sgNomAlm = sgNomAlm;
        this.fecNacAlm = fecNacAlm;
        this.dniApd = dniApd;
        this.gradoAlm = gradoAlm;
        this.seccionAlm = seccionAlm;
    }
    
    public String getDniAlm() {
        return dniAlm;
    }

    public void setDniAlm(String dniAlm) {
        this.dniAlm = dniAlm;
    }

    public String getApPatAlm() {
        return apPatAlm;
    }

    public void setApPatAlm(String apPatAlm) {
        this.apPatAlm = apPatAlm;
    }

    public String getApMatAlm() {
        return apMatAlm;
    }

    public void setApMatAlm(String apMatAlm) {
        this.apMatAlm = apMatAlm;
    }

    public String getNomAlm() {
        return nomAlm;
    }

    public void setNomAlm(String nomAlm) {
        this.nomAlm = nomAlm;
    }

    public String getSgNomAlm() {
        return sgNomAlm;
    }

    public void setSgNomAlm(String sgNomAlm) {
        this.sgNomAlm = sgNomAlm;
    }

    public Date getFecNacAlm() {
        return fecNacAlm;
    }

    public void setFecNacAlm(Date fecNacAlm) {
        this.fecNacAlm = fecNacAlm;
    }

    public String getDniApd() {
        return dniApd;
    }

    public void setDniApd(String dniApd) {
        this.dniApd = dniApd;
    }

    public String getGradoAlm() {
        return gradoAlm;
    }

    public void setGradoAlm(String gradoAlm) {
        this.gradoAlm = gradoAlm;
    }

    public String getSeccionAlm() {
        return seccionAlm;
    }

    public void setSeccionAlm(String seccionAlm) {
        this.seccionAlm = seccionAlm;
    }
    
    public Object[] registroAlumno(){
        Object[] fila = {dniAlm,apPatAlm,apMatAlm,nomAlm,sgNomAlm,fecNacAlm,dniApd,gradoAlm,seccionAlm};
        return fila;
    }
    
}
