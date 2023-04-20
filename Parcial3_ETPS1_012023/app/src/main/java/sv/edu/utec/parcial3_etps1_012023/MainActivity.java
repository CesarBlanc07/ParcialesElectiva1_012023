package sv.edu.utec.parcial3_etps1_012023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.parcial3_etps1_012023.helper.AdminSQLite;

public class MainActivity extends AppCompatActivity
{

    BottomNavigationView Nav;
    EditText nombre, apellido, correo, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nav = findViewById(R.id.btnNv);
        Nav.setOnNavigationItemSelectedListener(NavL);
        nombre = findViewById(R.id.edtNombre);
        apellido = findViewById(R.id.edtApellido);
        correo = findViewById(R.id.edtCorreo);
        telefono = findViewById(R.id.edtTelefono);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener NavL = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccion = null;

            switch (item.getItemId()) {
                case R.id.opcion_buscar:

                    AdminSQLite admin = new AdminSQLite(getApplicationContext(), "Parcial", null, 1);
                    SQLiteDatabase bd = admin.getWritableDatabase();

                    String nom = nombre.getText().toString();

                    Cursor filas = bd.rawQuery("select apellidop, correop, telefonop from contactos where nombrep = " + nom, null);

                    if(filas.moveToFirst())
                    {
                        apellido.setText(filas.getString(0));
                        correo.setText(filas.getString(1));
                        telefono.setText(filas.getString(1));
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No se encontro el contacto", Toast.LENGTH_LONG).show();
                    }

                    bd.close();

                    break;

                case R.id.opcion_insertar:

                    AdminSQLite admin2 = new AdminSQLite(getApplicationContext(), "Parcial", null, 1);
                    SQLiteDatabase bd2 = admin2.getWritableDatabase();

                    String nom2 = nombre.getText().toString();
                    String ape = apellido.getText().toString();
                    String cor = correo.getText().toString();
                    String tel = telefono.getText().toString();

                    ContentValues info = new ContentValues();
                    info.put("nombrep", nom2);
                    info.put("apellidop", ape);
                    info.put("correop", cor);
                    info.put("telefonop", tel);

                    bd2.insert("contactos", null, info);
                    bd2.close();

                    Toast.makeText(getApplicationContext(), "Se agrego el contacto", Toast.LENGTH_LONG).show();

                    break;

                case R.id.opcion_trash:

                    AdminSQLite admin3 = new AdminSQLite(getApplicationContext(), "Parcial", null, 1);
                    SQLiteDatabase bd3 = admin3.getWritableDatabase();

                    String nom3 = nombre.getText().toString();

                    int can = bd3.delete("contactos","nombrep =" + nom3, null);
                    bd3.close();

                    nombre.setText("");
                    apellido.setText("");
                    correo.setText("");
                    telefono.setText("");

                    if(can == 1)
                    {
                        Toast.makeText(getApplicationContext(), "Se borro el contacto", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No se borro el contacto", Toast.LENGTH_LONG).show();
                    }

                    break;

                case R.id.opcion_update:

                    AdminSQLite admin4 = new AdminSQLite(getApplicationContext(), "Parcial", null, 1);
                    SQLiteDatabase bd4 = admin4.getWritableDatabase();

                    String nom4 = nombre.getText().toString();
                    String ape4 = apellido.getText().toString();
                    String cor4 = correo.getText().toString();
                    String tel4 = telefono.getText().toString();

                    ContentValues info2 = new ContentValues();
                    info2.put("nombrep", nom4);
                    info2.put("apellidop", ape4);
                    info2.put("correop", cor4);
                    info2.put("telefonop", tel4);

                    int can4 = bd4.update("contactos", info2, "nombrep =" + nom4, null);
                    bd4.close();

                    if(can4 == 1)
                    {
                        Toast.makeText(getApplicationContext(), "Se actualizo el producto", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No se actualizo el producto", Toast.LENGTH_LONG).show();
                    }

                    break;
            }

            return false;
        }
    };

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_config, menu);
        return true;
    }


}