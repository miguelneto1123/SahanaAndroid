package br.ita.sahanaandroid.database;

/**
 * Created by Giancarlo on 7/4/2017.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class SahanaWS {

    public String customerData(){
        String customerInfo = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.98:3306","ces29","kabart");
            //Find customer information where the customer ID is maximum
            PreparedStatement statement =  con.prepareStatement("SELECT * FROM EVENTO;");
            ResultSet result = statement.executeQuery();

            while(result.next()){
                //customerInfo = customerInfo + result.getString("name") + "&" + result.getString("C_ID") + "&"+result.getString("address") + "&"+result.getString("email");
                customerInfo = customerInfo + result.getString("NOME");
                System.out.println(customerInfo);
            }
        }

        catch(Exception exc){
            System.out.println(exc.getMessage());
        }

        return customerInfo;
    }
}
