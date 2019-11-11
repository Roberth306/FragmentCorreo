package tk.roberthramirez.correo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AdaptadorCorreos extends ArrayAdapter<Correo> {
    private Context context;
    private Correo[] correos;

    public AdaptadorCorreos(Fragment context, Correo[] correos) {
        super(context.getActivity(), R.layout.list_item, correos);
        this.correos = correos;
        this.context = context.getActivity();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.list_item, null);
        TextView tvDe = item.findViewById(R.id.tvDe);
        tvDe.setText("De: "+correos[position].getDe());
        TextView tvTexto = item.findViewById(R.id.tvTexto);
        tvTexto.setText("Asunto: "+correos[position].getAsunto());
        return item;
    }
}
