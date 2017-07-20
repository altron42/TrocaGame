package tk.trocagame.trocagame.view.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.api.ApiService;
import tk.trocagame.trocagame.api.ApiUtils;
import tk.trocagame.trocagame.model.Console;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.utils.GameRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConsoleInicioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConsoleInicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsoleInicioFragment extends Fragment {

    private static final String TAG = ConsoleInicioFragment.class.getName();

    // parametros para inicializacao do fragment
    private static final String ARG_CONSOLE_ID = "tk.trocagame.id.CONSOLE";

    private int mConsoleId;

    private OnFragmentInteractionListener mListener;

    private List<Jogo> gameList = new ArrayList<>();

    private List<Jogo> gameSet1 = new ArrayList<>();
    private List<Jogo> gameSet2 = new ArrayList<>();
    private List<Jogo> gameSet3 = new ArrayList<>();

    private View rootView;

    private RecyclerView gameRecyclerView1;
    private RecyclerView gameRecyclerView2;
    private RecyclerView gameRecyclerView3;

    private GameRecyclerAdapter gSetAdapter1;
    private GameRecyclerAdapter gSetAdapter2;
    private GameRecyclerAdapter gSetAdapter3;

    private ApiService mApiService;

    public ConsoleInicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param consoleId Name for this console fragment.
     * @return A new instance of fragment ConsoleInicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsoleInicioFragment newInstance(int consoleId) {
        ConsoleInicioFragment fragment = new ConsoleInicioFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CONSOLE_ID, consoleId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mConsoleId = getArguments().getInt(ARG_CONSOLE_ID);
        }
        mApiService = ApiUtils.getApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_console_inicio, container, false);

        gameRecyclerView1 = (RecyclerView) rootView.findViewById(R.id.rv_console_inicio_1);
        gameRecyclerView2 = (RecyclerView) rootView.findViewById(R.id.rv_console_inicio_2);
        gameRecyclerView3 = (RecyclerView) rootView.findViewById(R.id.rv_console_inicio_3);

        gSetAdapter1 = new GameRecyclerAdapter(gameSet1);
        gSetAdapter2 = new GameRecyclerAdapter(gameSet2);
        gSetAdapter3 = new GameRecyclerAdapter(gameSet3);
        buscaJogos();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(rootView.getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(rootView.getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(rootView.getContext(),
                LinearLayoutManager.HORIZONTAL, false);

        gameRecyclerView1.setHasFixedSize(true);
        gameRecyclerView1.setLayoutManager(mLayoutManager1);
        gameRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        gameRecyclerView1.setAdapter(gSetAdapter1);

        gameRecyclerView2.setHasFixedSize(true);
        gameRecyclerView2.setLayoutManager(mLayoutManager2);
        gameRecyclerView2.setItemAnimator(new DefaultItemAnimator());
        gameRecyclerView2.setAdapter(gSetAdapter2);

        gameRecyclerView3.setHasFixedSize(true);
        gameRecyclerView3.setLayoutManager(mLayoutManager3);
        gameRecyclerView3.setItemAnimator(new DefaultItemAnimator());
        gameRecyclerView3.setAdapter(gSetAdapter3);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void buscaJogos() {
        mApiService.buscaJogosConsole(new Console(mConsoleId)).enqueue(new Callback<List<Jogo>>() {
            @Override
            public void onResponse(Call<List<Jogo>> call, Response<List<Jogo>> response) {
                if(response.isSuccessful()) {
                    Log.i(TAG,"GET enviado para API.");
                    populateDataSet(response.body());
                } else {
                    Log.e(TAG, "RESPONSE ERROR CODE: " + response.code() + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Jogo>> call, Throwable t) {
                Log.e(TAG, "Ocorreu algum erro. " + t.getMessage());
            }
        });
    }

    private void populateDataSet(List<Jogo> response) {
        if (response.isEmpty()) {
            Toast.makeText(getActivity(),"Erro, retorno vazio",Toast.LENGTH_SHORT).show();
        } else {
            gameList.clear();
            gameList.addAll(response);

            gameSet1.clear();
            gameSet1.addAll(gameList.subList(0,9));
            gameSet2.clear();
            gameSet2.addAll(gameList.subList(10,19));
            gameSet3.clear();
            gameSet3.addAll(gameList.subList(20,gameList.size()-1));

            gSetAdapter1.notifyDataSetChanged();
            gSetAdapter2.notifyDataSetChanged();
            gSetAdapter3.notifyDataSetChanged();
        }
    }
}
