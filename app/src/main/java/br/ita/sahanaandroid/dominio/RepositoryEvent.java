package br.ita.sahanaandroid.dominio;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import br.ita.sahanaandroid.dominio.entidades.Event;


/**
 * Created by Giancarlo on 6/7/2017.
 */
public class RepositoryEvent {

    private SQLiteDatabase conn;

    public RepositoryEvent(SQLiteDatabase conn)
    {
        this.conn = conn;
    }


    private ContentValues preencheContentValues(Event evento)
    {
        ContentValues values = new ContentValues();

        values.put(Event.NOME, evento.getNome());
        values.put(Event.LATITUDE, evento.getLatitude());
        values.put(Event.LONGITUDE, evento.getLongitude());
        values.put(Event.DATA, evento.getData().getTime());
        values.put(Event.TIPO, evento.getTipo());
        values.put(Event.FECHADO, evento.getFechado());
        return values;

    }

    public void excluir(long id)
    {
        conn.delete(Event.TABELA, " _id = ? ", new String[]{ String.valueOf( id ) });
    }

    public void alterar(Event evento)
    {
        ContentValues values = preencheContentValues(evento);
        conn.update(Event.TABELA, values, " _id = ? ", new String[]{ String.valueOf( evento.getId()) } );

    }

    public void inserir(Event evento)
    {
        ContentValues values = preencheContentValues(evento);
        conn.insertOrThrow(Event.TABELA, null, values);
    }
}
