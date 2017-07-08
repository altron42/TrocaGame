package tk.trocagame.trocagame.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.model.Usuario;
import tk.trocagame.trocagame.utils.LocalStorage;


public class PerfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private TextView name;
    private TextView login;
    private TextView dercricao;
    private TextView telefone;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Perfil");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);

        Usuario usuario = LocalStorage.getInstance(rootView.getContext()).getObject(LocalStorage.ACTIVE_USER, Usuario.class);

        // Ate aqui esta funcionando.
        Log.i("NOME DO USUARIO: ", usuario.getNome());

        /*
         * Depois daqui da crash.
         * Provavelmente nao esta conseguindo encontrar a ID do textView
         * Verificar e corrigir os textViews no xml desse fragment

        name = (TextView) rootView.findViewById(R.id.tv_name);
        name.setText(usuario.getNome());
        login = (TextView) rootView.findViewById(R.id.tv_login);
        login.setText(usuario.getLogin());

        */

        return rootView;
    }

}