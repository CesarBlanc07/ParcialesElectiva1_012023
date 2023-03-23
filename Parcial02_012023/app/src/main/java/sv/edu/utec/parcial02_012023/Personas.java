package sv.edu.utec.parcial02_012023;

public class Personas
{
    private String nombre, cargo, compañia;

    public Personas(String nombre, String cargo, String compañia)
    {
        this.nombre = nombre;
        this.cargo = cargo;
        this.compañia = compañia;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getCargo()
    {
        return cargo;
    }

    public String getCompañia()
    {
        return compañia;
    }

}
