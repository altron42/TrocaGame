package tk.trocagame.trocagame.view.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tk.trocagame.trocagame.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConsoleInicioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConsoleInicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsoleInicioFragment extends Fragment {

    // parametros para inicializacao do fragment
    private static final String ARG_CONSOLE = "tk.trocagame.view.fragment.CONSOLE";

    private String mConsoleName;

    private OnFragmentInteractionListener mListener;

    private TextView tvConsoleName;

    public ConsoleInicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param consoleName Name for this console fragment.
     * @return A new instance of fragment ConsoleInicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsoleInicioFragment newInstance(String consoleName) {
        ConsoleInicioFragment fragment = new ConsoleInicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONSOLE, consoleName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mConsoleName = getArguments().getString(ARG_CONSOLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_console_inicio, container, false);

        tvConsoleName = (TextView) rootView.findViewById(R.id.tv_console_name);
        tvConsoleName.setText(mConsoleName);

        return rootView;
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
}
