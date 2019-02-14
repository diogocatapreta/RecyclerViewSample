package com.example.diogocatapreta.recyclerviewsample.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.diogocatapreta.recyclerviewsample.R;
import com.example.diogocatapreta.recyclerviewsample.RecyclerItemClickListener;
import com.example.diogocatapreta.recyclerviewsample.adapter.AdapterSolicitacao;
import com.example.diogocatapreta.recyclerviewsample.model.Solicitacao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recycleview;
    private List<Solicitacao> listaSolicitacao = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //recycleview
        recycleview = findViewById(R.id.recyclerView);

        //criar a listagem de solicitações
        this.criarSolicitacao();

        //configuracao do adapter
        AdapterSolicitacao adapter = new AdapterSolicitacao(listaSolicitacao);


        //configuracao do recycleview

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycleview.setLayoutManager(layoutManager);
        recycleview.setHasFixedSize(true);
        recycleview.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recycleview.setAdapter(adapter);


        //evento de click
        recycleview.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recycleview,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Solicitacao sol = listaSolicitacao.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Solicitacao: PDL "+sol.getNumero()+" clicada.",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                Solicitacao sol = listaSolicitacao.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Solicitacao: PDL "+sol.getNumero()+" selecionada.",
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );


    }

    public void criarSolicitacao(){

        Solicitacao sol = new Solicitacao( 121118, "Vivencci Comercio de Cosmeticos LTDA ME", "18.465.887/0001-23", 234.99);
        this.listaSolicitacao.add(sol);

        Solicitacao sol2 = new Solicitacao( 123490, "Carlos Henrique Santos", "076.445.334-23", 34.19);
        this.listaSolicitacao.add(sol2);

        Solicitacao sol3 = new Solicitacao( 123455, "Jucquinha Comercio de Balas e Produtos LTDA", "11.465.667/0001-21", 154.99);
        this.listaSolicitacao.add(sol3);

        Solicitacao sol4 = new Solicitacao( 124456, "Jose Santana Henrique Santos", "098.432.111-23", 23.99);
        this.listaSolicitacao.add(sol4);

        Solicitacao sol5 = new Solicitacao( 125559, "Figurinos Medicina", "11.465.887/0001-23", 234.10);
        this.listaSolicitacao.add(sol5);

        Solicitacao sol6 = new Solicitacao( 123677, "Medicos Especializados em Dores", "13.005.887/0001-23", 1234.00);
        this.listaSolicitacao.add(sol6);

        Solicitacao sol7 = new Solicitacao( 123490, "Carlos Henrique Santos", "076.445.334-23", 34.19);
        this.listaSolicitacao.add(sol7);

        Solicitacao sol8 = new Solicitacao( 123455, "Jucquinha Comercio de Balas e Produtos LTDA", "11.465.667/0001-21", 154.99);
        this.listaSolicitacao.add(sol8);

        Solicitacao sol9 = new Solicitacao( 124456, "Jose Santana Henrique Santos", "098.432.111-23", 23.99);
        this.listaSolicitacao.add(sol9);

        Solicitacao sol10 = new Solicitacao( 125559, "Figurinos Medicina", "11.465.887/0001-23", 234.10);
        this.listaSolicitacao.add(sol10);

        Solicitacao sol11 = new Solicitacao( 123677, "Medicos Especializados em Dores", "13.005.887/0001-23", 1234.00);
        this.listaSolicitacao.add(sol11);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
