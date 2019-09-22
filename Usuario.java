package modelos;

public class Usuario {

    //declaracion de variables a ser usadas despues
    private int id;
    private String nickname;
    private String nombre;
    private String password;
    private String correo;
    private String direccion;

    public Usuario() {

        //empty constructor

    }

    public Usuario(int id, String nickname, String nombre, String password, String correo, String direccion) {
        this.id = id;
        this.nickname = nickname;
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Usuario(String nickname, String nombre, String password, String correo, String direccion) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
