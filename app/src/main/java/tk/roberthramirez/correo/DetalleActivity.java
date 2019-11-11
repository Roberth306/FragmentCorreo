package tk.roberthramirez.correo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "hola mundo";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle detalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        detalle.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}
