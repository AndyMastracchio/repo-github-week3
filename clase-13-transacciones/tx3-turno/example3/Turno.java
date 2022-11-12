package z.com.example3;

public class Turno {
    private Long id;
    private String hora;
    private int dia;

    public Turno(String hora, int dia) {
        this.hora = hora;
        this.dia = dia;
    }

    public Long getId() {
        return id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
