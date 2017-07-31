package tk.trocagame.trocagame.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView offerCard;
        public TextView userName;
        public TextView userCity;
        public TextView offerState;
        public ImageView userImage;

        public MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            offerCard = (CardView) view.findViewById(R.id.cv_offer);
            userName = (TextView) view.findViewById(R.id.tv_offer_username);
            userCity = (TextView) view.findViewById(R.id.tv_offer_usercity);
            offerState = (TextView) view.findViewById(R.id.tv_estado_valor);
            userImage = (ImageView) view.findViewById(R.id.iv_offer_user);
        }
    }

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
        Oferta oferta = mOffersList.get(position);
        holder.userName.setText(oferta.getNome_usuario());
        holder.userCity.setText("Manaus/AM");
        holder.offerState.setText(oferta.getEstado_jogo());

        Glide.with(context)
                .load(R.drawable.account)
                .placeholder(R.drawable.trocagame_progess_orange)
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return mOffersList.size();
    }

}
