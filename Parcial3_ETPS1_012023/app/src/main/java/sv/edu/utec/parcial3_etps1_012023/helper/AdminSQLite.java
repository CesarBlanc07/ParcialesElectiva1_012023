package sv.edu.utec.parcial3_etps1_012023.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLite extends SQLiteOpenHelper
{

    public AdminSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Parcial)
    {
        Parcial.execSQL("CREATE TABLE contactos (nombrep text primary key, apellidop text, correop text, telefonop int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Parcial, int i, int i1)
    {

    }
}

