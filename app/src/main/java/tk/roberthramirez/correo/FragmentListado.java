package tk.roberthramirez.correo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentListado extends Fragment {
    private Correo[] datos = new Correo[] {
            new Correo("Persona 1", "Asunto 1", "Texto del correo 1"),
            new Correo("Persona 2", "Asunto 2", "Texto del correo 2"),
            new Correo("Persona 3", "Asunto 3", "Texto del correo 3"),
            new Correo("Persona 4", "Asunto 4", "Texto del correo 4"),
            new Correo("Persona 5", "Asunto 5", "Texto del correo 5"),
            new Correo("Persona 6", "Asunto 6", "Texto del correo 6")
    };
    private ListView lvFragmento;
    private ICorreoListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_uno, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvFragmento = getView().findViewById(R.id.lvFragmento);
        lvFragmento.setAdapter(new AdaptadorCorreos(this, datos));

        lvFragmento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if (listener!=null) {
                    listener.onCorreoSeleccionado((Correo)lvFragmento.getAdapter().getItem(pos));
                }
            }
        });

    }

    public void setCorreosListener(ICorreoListener listener) {
        this.listener = listener;
    }
}
