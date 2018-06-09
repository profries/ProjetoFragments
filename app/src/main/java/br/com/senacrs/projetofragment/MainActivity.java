package br.com.senacrs.projetofragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Comunicador{

    private String mensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment_content, new PrimeiroFragment());
        ft.commit();

    }

    public void abrirPrimeiroFragment(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment_content, new PrimeiroFragment());
        ft.commit();

    }

    public void abrirSegundoFragment(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment fragment = new SegundoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg", this.mensagem);
        fragment.setArguments(bundle);
        ft.replace(R.id.fragment_content, fragment);
        ft.commit();

    }

    
    @Override
    public void enviaMensagem(String msg) {
        this.mensagem = msg;
        Toast.makeText(this, "Mensagem: "+mensagem, Toast.LENGTH_SHORT).show();
    }
}
