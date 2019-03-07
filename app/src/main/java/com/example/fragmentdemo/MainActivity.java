package com.example.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements BlankFragment.communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BlankFragment fragment= new BlankFragment();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack("fragment");

        fragmentTransaction.commit();

        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        BlankFragment2 fragment2= new BlankFragment2();
        fragmentTransaction2.add(R.id.fragment_container, fragment2);
        fragmentTransaction2.addToBackStack("fragment1");
        fragmentTransaction2.commit();

        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
        BlankFragment3 fragment3= new BlankFragment3();
        fragmentTransaction3.add(R.id.fragment_container, fragment3);
        fragmentTransaction3.addToBackStack("fragment2");
        fragmentTransaction3.commit();



        fragmentManager.popBackStack("fragment2", 0);
    }

    @Override
    public void result() {
        Log.i("TAG", "result called in activity " + i );
    }
}
