
package Modelo.DTO;

public class Usuario {
    private int idUser;
    private String Username;
    private String Password;
    private String Profile;
    private int Active;

    public Usuario() {
    }

    public Usuario(int idUser, String Username, String Password, String Profile, int Active) {
        this.idUser = idUser;
        this.Username = Username;
        this.Password = Password;
        this.Profile = Profile;
        this.Active = Active;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String Profile) {
        this.Profile = Profile;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }
    public Object[] registroUsuario(){
        Object[] fila = {idUser,Username,Password,Profile,Active};
        return fila;
    }
}
