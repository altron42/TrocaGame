package tk.trocagame.trocagame.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.model.Jogo;

/**
 * Created by micael on 7/12/17.
 */

public class GameRecyclerAdapter extends RecyclerView.Adapter<GameRecyclerAdapter.MyViewHolder> {

    private List<Jogo> gameList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView gameName;
        public ImageView gameImage;

        public MyViewHolder(View view) {
            super(view);
            gameName = (TextView) view.findViewById(R.id.tv_game_name);
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Jogo game = gameList.get(position);
        holder.gameName.setText(game.getNome());
        //holder.gameImage.setImageURI(game.getImageUri());
        holder.gameImage.setImageResource(R.drawable.battlefield1_ps4);
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

}
