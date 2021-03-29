package com.example.nhom10_06_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addA(View v){
        manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentA fragmentA=new FragmentA();
        transaction.add(R.id.frame,fragmentA,"fragA");
        transaction.addToBackStack("fa");
        transaction.commit();
    }
    public void addB(View v){
        manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentB fragment=new FragmentB();
        transaction.add(R.id.frame,fragment,"fragB");
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void addC(View v){
        manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentC fragment=new FragmentC();
        transaction.add(R.id.frame,fragment,"fragC");
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void removeA(View v){
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentA fragment=(FragmentA) getSupportFragmentManager().
                findFragmentByTag("fragA");
        transaction.remove(fragment);
        transaction.commit();
    }
    public void removeB(View v){
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentB fragment=(FragmentB) getSupportFragmentManager().
                findFragmentByTag("fragB");
        transaction.remove(fragment);
        transaction.commit();
    }
    public void removeC(View v){
        FragmentTransaction transaction=manager.beginTransaction();
        FragmentC fragment=(FragmentC) getSupportFragmentManager().
                findFragmentByTag("fragC");
        transaction.remove(fragment);
        transaction.commit();
    }
    public void back(View v){
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else
           super.onBackPressed();
    }
    public  void popA(View v){
        getSupportFragmentManager().popBackStack("fa",0);
    }
}
