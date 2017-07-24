package tk.trocagame.trocagame.adapter;

import android.content.Context;

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
import tk.trocagame.trocagame.model.Comentario;

/**
 * Created by primetwo on 19-07-2017.
 */

public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.MyViewHolder> {

    private static final String TAG = CommentRecyclerAdapter.class.getName();
    private Context context;
    private List<Comentario> mCommentList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView commentCard;
        public TextView userName;
        public TextView date;
        public TextView message;
        public ImageView userImage;

        public MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            commentCard = (CardView) view.findViewById(R.id.cv_comment);
            userName = (TextView) view.findViewById(R.id.tv_comment_username);
            date = (TextView) view.findViewById(R.id.tv_comment_date);
            message = (TextView) view.findViewById(R.id.tv_comment_message);
            userImage = (ImageView) view.findViewById(R.id.iv_comment_user);
        }
    }

    public CommentRecyclerAdapter(List<Comentario> commentDataSet) {
        this.mCommentList= commentDataSet;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_comentario, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Comentario comentario = mCommentList.get(position);
        holder.userName.setText(comentario.getNome_usuario());
        holder.date.setText(comentario.getData());
        holder.message.setText(comentario.getMensagem());

        Glide.with(context)
                .load(R.drawable.account)
                .placeholder(R.drawable.trocagame_progess_orange)
                .into(holder.userImage);
        holder.commentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comentario comentario1 = mCommentList.get(position);
                Toast.makeText(context, "Comentario clicado: " + comentario1.getId(),Toast.LENGTH_SHORT).show();
                Log.i(TAG,"Jogo clicado: " + comentario1.getId() + "-" + comentario1.getMensagem());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCommentList.size();
    }

}
