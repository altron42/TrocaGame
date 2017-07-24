package tk.trocagame.trocagame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.utils.LocalStorage;
import tk.trocagame.trocagame.view.JogoActivity;

/**
 * Created by micael on 7/12/17.
 */

public class GameRecyclerAdapter extends RecyclerView.Adapter<GameRecyclerAdapter.MyViewHolder> {

    private static final String TAG = GameRecyclerAdapter.class.getName();
    private Context context;
    private List<Jogo> gameList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView gameCard;
        public TextView gameName;
        public ImageView gameImage;

        public MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            gameCard = (CardView) view.findViewById(R.id.cv_jogo);
            //gameName = (TextView) view.findViewById(R.id.tv_game_name);
            gameImage = (ImageView) view.findViewById(R.id.iv_game_image);
        }
    }

    public GameRecyclerAdapter(List<Jogo> gameList) {
        this.gameList = gameList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_console_game, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Jogo game = gameList.get(position);
        //holder.gameName.setText(game.getNome());
        //holder.userImage.setImageURI(game.getImageUri());
        Glide.with(context)
                .load(game.getSrc_imagem())
                .placeholder(R.drawable.trocagame_progess_orange)
                .into(holder.gameImage);
        holder.gameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jogo jogo = gameList.get(position);
//                Toast.makeText(context, "Jogo clicado: " + jogo.getNome(),Toast.LENGTH_SHORT).show();
                Log.i(TAG,"Jogo clicado: " + jogo.getId() + "-" + jogo.getNome());
                openGameActivity(jogo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public void openGameActivity(Jogo jogo) {
        if (jogo != null) {
            LocalStorage.getInstance(context).addToStorage(LocalStorage.JOGO_CLICADO, jogo);
            Intent intent = new Intent(context,JogoActivity.class);
            context.startActivity(intent);
        } else {
            Toast.makeText(context,"Erro, objeto jogo = null",Toast.LENGTH_SHORT).show();
        }
    }
}
