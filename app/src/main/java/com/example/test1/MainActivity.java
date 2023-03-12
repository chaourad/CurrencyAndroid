package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,AdapterView.OnItemSelectedListener {
    Spinner change1;
    EditText numeroEntre;
    TextView resultat;
    TextView TextViews;
    TextView resultats;
    Button convertBtn;
    String[] currencies = {"MAD", "EUR", "USD"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                currencies
        );


        change1 = findViewById(R.id.test1);
        numeroEntre = findViewById(R.id.numero);
        resultat = findViewById(R.id.resultat);

        resultats = findViewById(R.id.resultat2);
        convertBtn = findViewById(R.id.convertBtn);
        change1.setAdapter(adapter);
        convertBtn.setOnClickListener(this);
        change1.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.convertBtn){
            Double total;
            Double tot;


            Double amt = Double.parseDouble(numeroEntre.getText().toString());

            if(change1.getSelectedItem().toString() == "MAD")
            {
                tot = amt * 10.0;

                Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                resultat.setText(tot.toString()+" EUR");
                total = amt*0.097;
                resultats.setText(total.toString()+" USD");

            }
            else if(change1.getSelectedItem().toString() == "EUR"){
                tot = amt * 11.01;

                Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                resultat.setText(tot.toString()+" MAD");
                total = amt*1.06;
                resultats.setText(total.toString()+" USD");
            } else if(change1.getSelectedItem().toString() == "USD"){
                tot = amt * 10.34;

                Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                resultat.setText(tot.toString()+" MAD");
                total = amt*0.94;
                resultats.setText(total.toString()+" EUR");
            }
            //Toast.makeText(MainActivity.this, numeroEntre.getText().toString(), Toast.LENGTH_LONG).show();
            //resultat.setText(numeroEntre.getText().toString());



        }
    }


    private void convertMoney(){
        Double total;
        Double tot;


        Double amt = Double.parseDouble(numeroEntre.getText().toString());

        if(change1.getSelectedItem().toString() == "MAD")
        {
            tot = amt * 10.0;
            resultat.setText(tot.toString()+" EUR");
            Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
            total = amt*0.097;
            resultats.setText(total.toString()+" USD");

        }
        else if(change1.getSelectedItem().toString() == "EUR"){
            tot = amt * 11.01;
            resultat.setText(tot.toString()+" MAD");
            Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
            total = amt*1.06;
            resultats.setText(total.toString()+" USD");
        } else if(change1.getSelectedItem().toString() == "USD"){
            tot = amt * 10.34;
            resultat.setText(tot.toString()+" MAD");
            Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
            total = amt*0.94;
            resultats.setText(total.toString()+" EUR");
        }        Toast.makeText(MainActivity.this, numeroEntre.getText().toString(), Toast.LENGTH_LONG).show();
        resultat.setText(numeroEntre.getText().toString());


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selected = currencies[i];
        Toast.makeText(this, selected, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}