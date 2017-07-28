package tk.trocagame.trocagame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.model.Oferta;

/**
 * Created by micael on 7/28/17.
 */

public class OffersRecyclerAdapter extends RecyclerView.Adapter<OffersRecyclerAdapter.MyViewHolder> {

    private static final String TAG = OffersRecyclerAdapter.class.getName();
    private Context context;
    private List<Oferta> mOffersList;

    public OffersRecyclerAdapter(List<Oferta> mOffersList) {
        this.mOffersList = mOffersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_oferta,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
        }
    }

}
