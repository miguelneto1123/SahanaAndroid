package br.ita.sahanaandroid.database;

/**
 * Created by Giancarlo on 6/7/2017.
 */
public class ScriptSQL {


    public static String getCreateEvent()
    {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" CREATE TABLE IF NOT EXISTS EVENTO ( ");
        sqlBuilder.append("_id                INTEGER       NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("NOME               VARCHAR (200), ");
        sqlBuilder.append("LATITUDE               FLOAT, ");
        sqlBuilder.append("LONGITUDE               FLOAT, ");
        sqlBuilder.append("DATA     DATE, ");
        sqlBuilder.append("TIPO     VARCHAR (200), ");
        sqlBuilder.append("FECHADO  BOOLEAN ");
        sqlBuilder.append(");");

        return sqlBuilder.toString();

    }



}
