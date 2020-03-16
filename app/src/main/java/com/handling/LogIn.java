package com.handling;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LogIn extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... queries) {
        String resultString = null;

        try {
            DBConnection DBConnection = new DBConnection();
            Connection con = DBConnection.getDBConnection();

            if (con == null) {
                System.out.println("Brak połączenia z internetem");

            } else {
                Statement stmt = con.createStatement();
                ResultSet result = stmt.executeQuery(queries[0]);
                result.next();
                resultString = result.getString("nazwisko");

            }
        } catch (Exception ex) {
            System.out.println("Exception in LogIn.doInBackground();");
        }

        return resultString;
    }

    @Override
    protected void onPostExecute(String resultString) {
        System.out.println("Zalogowano: " + resultString);
    }


}
