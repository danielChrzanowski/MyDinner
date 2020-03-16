package com.example.mydinner;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import handling.DBConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        System.out.println("AAAAAAAAAAAAAAAAAAAAA");

        Doregister doregister = new Doregister();
        doregister.execute();
    }



    public class Doregister extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBB");
            try {
                DBConnection DBConnection = new DBConnection();
                Connection con = DBConnection.getDBConnection();

                if (con == null) {
                    System.out.println("BLAD 2");
                } else {

                    String query = "select * from pracownicy";

                    Statement stmt = con.createStatement();
                    ResultSet result = stmt.executeQuery(query);
                    System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBB");
                    result.next();
                    String nazwisko = result.getString("nazwisko");

                    System.out.println("nazwisko: " + nazwisko);

                }
            } catch (Exception ex) {
                System.out.println("BLAD 1");
            }

            return "wynik";
        }


    }
}

