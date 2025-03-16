package com.example.gridmaster;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecentGameAdapter extends RecyclerView.Adapter<RecentGameAdapter.RecentGameViewHolder> {
    private final List<RecentGame> recentGames;

    public RecentGameAdapter(List<RecentGame> recentGames) {
        this.recentGames = recentGames;
    }



    public class RecentGameViewHolder extends RecyclerView.ViewHolder{
        TextView mode;
        TextView playerOneName;
        TextView playerTwoName;
        TextView winner;
        ImageView playerTwoImg;

        public RecentGameViewHolder(View itemView){
            super(itemView);
            mode = itemView.findViewById(R.id.tv_mode);
            playerOneName = itemView.findViewById(R.id.tv_player_1_name);
            playerTwoName = itemView.findViewById(R.id.tv_player_2_name);
            winner = itemView.findViewById(R.id.tv_winner);
            playerTwoImg = itemView.findViewById(R.id.player2Img);

        }

    }

    public RecentGame getGameAtPosition(int pos){return recentGames.get(pos);}

    @NonNull
    @Override
    public RecentGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new RecentGameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentGameViewHolder holder, int position) {
        RecentGame recentGame = recentGames.get(position);
        holder.playerTwoImg.setImageURI(Uri.parse(recentGame.getPlayerTwoImage()));
        holder.playerOneName.setText(recentGame.getPlayerOneName());
        holder.playerTwoName.setText(recentGame.getPlayerTwoName());
        holder.winner.setText(recentGame.getWinner());
        holder.mode.setText(recentGame.getMode());
    }

    @Override
    public int getItemCount() {
        return recentGames.size();
    }

    public void deleteGame(int position) {
        this.recentGames.remove(position);
        notifyItemRemoved(position);
    }
}
