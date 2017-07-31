package tk.trocagame.trocagame.view;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.adapter.OffersRecyclerAdapter;
import tk.trocagame.trocagame.api.ApiService;
import tk.trocagame.trocagame.api.ApiUtils;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.model.Oferta;
import tk.trocagame.trocagame.utils.LocalStorage;

public class TrocaActivity extends Activity {

    private static final String TAG = TrocaActivity.class.getName();

    private List<Oferta> mOfferList = new ArrayList<>();
    private RecyclerView offerRecyclerView;
    private OffersRecyclerAdapter oSetAdapter;

    private ApiService mApiService;

    private Jogo jogo;
    private ImageView imagem_jogo;
    private TextView title_ofertas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troca);

        mApiService = ApiUtils.getApiService();

        jogo = LocalStorage.getInstance(this).getObject(LocalStorage.JOGO_CLICADO,Jogo.class);

        imagem_jogo = (ImageView) findViewById(R.id.image_jogo_troca);
        title_ofertas = (TextView) findViewById(R.id.text_title_ofertas);
        title_ofertas.setText("Ofertas para " + jogo.getNome());


        Glide.with(this)
                .load(jogo.getImageUri())
                .into(imagem_jogo);

        offerRecyclerView = (RecyclerView) findViewById(R.id.rv_ofertas);

        if (mOfferList.isEmpty()) {
            buscaOfertas(new Oferta(jogo.getId()));
        }

        oSetAdapter = new OffersRecyclerAdapter(mOfferList);

        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,true);

        offerRecyclerView.setHasFixedSize(true);
        offerRecyclerView.setLayoutManager(mLayoutManager1);
        offerRecyclerView.setItemAnimator(new DefaultItemAnimator());
        offerRecyclerView.setAdapter(oSetAdapter);
    }

    private void buscaOfertas(Oferta oferta) {
        mApiService.buscaOfertasJogo(oferta).enqueue(new Callback<List<Oferta>>() {
            @Override
            public void onResponse(Call<List<Oferta>> call, Response<List<Oferta>> response) {
                if (response.isSuccessful()) {
                    populateDataSet(response.body());
                } else {
                    Log.e(TAG, "RESPONSE ERROR CODE: " + response.code() + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Oferta>> call, Throwable t) {

            }
        });
    }

    private void populateDataSet(List<Oferta> response) {
        if (response.isEmpty()) {
            Toast.makeText(this,"Nao ha ofertas",Toast.LENGTH_SHORT).show();
        } else {
            mOfferList.clear();
            mOfferList.addAll(response);
            oSetAdapter.notifyDataSetChanged();
        }
    }

}
