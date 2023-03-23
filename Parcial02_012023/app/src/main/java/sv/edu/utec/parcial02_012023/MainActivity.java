package sv.edu.utec.parcial02_012023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private ArrayList<Personas> listapersonas;
    ListView lista;
    Integer[]Imgpersonas={
            R.drawable.fotoy,
            R.drawable.lead_photo_1,
            R.drawable.lead_photo_2,
            R.drawable.lead_photo_3,
            R.drawable.lead_photo_4,
            R.drawable.lead_photo_5,
            R.drawable.lead_photo_6,
            R.drawable.lead_photo_7,
            R.drawable.lead_photo_8,
            R.drawable.lead_photo_9,
            R.drawable.lead_photo_10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listapersonas=new ArrayList<Personas>();
        listapersonas.add(new Personas("Cesar Blanco","Supervisor de Contabilidad", "BlancoA2 Inc"));
        listapersonas.add(new Personas("Alexander Pierrot","CEO", "Insures S.O."));
        listapersonas.add(new Personas("Carlos Lopez","Asistente", "Hospital Blue"));
        listapersonas.add(new Personas("Sara Bonz","Directora de Marketing", "Electrical Parts Itd"));
        listapersonas.add(new Personas("Liliana Clarence","Diseñadora de producto", "Creativa App"));
        listapersonas.add(new Personas("Benito Peralta","Supervisor de ventas", "Neumaticos Press"));
        listapersonas.add(new Personas("Juan Jaramillo", "CEO", "Banco Nacional"));
        listapersonas.add(new Personas("Cristian Steps","CTO", "Cooperativa Verde"));
        listapersonas.add(new Personas("Alexa Giraldo","Lead Programer", "Frutysofy"));
        listapersonas.add(new Personas("Linda Murillo","Directora de Marketing", "Seguros Boliver"));
        listapersonas.add(new Personas("Lizeth Astrada","CEO", "Consecionario Molotox"));

        AdaptadorPersona adaptador = new AdaptadorPersona(this);
        lista = findViewById(R.id.lvLista);
        lista.setAdapter(adaptador);
    }

    class AdaptadorPersona extends ArrayAdapter<Personas>
    {
        AppCompatActivity appCompatActivity;

        AdaptadorPersona(AppCompatActivity context)
        {
            super(context, R.layout.personas_layout, listapersonas);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.personas_layout, null);

            TextView textView1 = item.findViewById(R.id.tvNombre);
            textView1.setText(listapersonas.get(position).getNombre());

            TextView textView2 = item.findViewById(R.id.tvCargo);
            textView2.setText(listapersonas.get(position).getCargo());

            TextView textView3 = item.findViewById(R.id.tvCompañia);
            textView3.setText(listapersonas.get(position).getCompañia());

            ImageView imageView1 = item.findViewById(R.id.imvFoto);
            imageView1.setImageResource(Imgpersonas[position]);

            return item;
        }
    }
}