package br.ita.sahanaandroid.dominio.entidades;

/**
 * Created by Giancarlo on 6/7/2017.
 */
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Leonardo on 11/04/2017.
 */
public class Event implements Serializable{

    public static String TABELA = "EVENTO";
    public static String ID = "_id";
    public static String NOME = "NOME";
    public static String LATITUDE = "LATITUDE";
    public static String LONGITUDE = "LONGITUDE";
    public static String DATA = "DATA";
    public static String TIPO = "TIPO";
    public static String FECHADO = "FECHADO";

    private long id;
    private String nome;
    private double latitude;
    private double longitude;
    private Date date;
    private String tipo;
    private boolean fechado;

    public Event()
    {
        id = 0;
    }

    public long getId() {
        return id;
    }
    public String getNome() { return nome; }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public Date getData() { return date; }
    public String getTipo() { return tipo; }
    public boolean getFechado() { return fechado; }

    public void setId(long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setLatitude(double latitude){
        this.latitude=latitude;
    }
    public void setLongitude(double longitude){
        this.longitude=longitude;
    }
    public void setDate(java.sql.Date date){
        this.date=date;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setFechado(boolean fechado){
        this.fechado=fechado;
    }

    @Override
    public String toString()
    {
        return nome ;
    }
}
