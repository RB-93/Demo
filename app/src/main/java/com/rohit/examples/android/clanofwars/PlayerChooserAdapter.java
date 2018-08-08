package com.rohit.examples.android.clanofwars;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rohit.examples.android.clanofwars.model.Player;
import com.rohit.examples.android.clanofwars.model.Team;

import java.util.ArrayList;
import java.util.List;

public class PlayerChooserAdapter extends RecyclerView.Adapter<PlayerChooserAdapter.PlayerViewHolder>{

    private Context mContext;
    private ArrayList<Player> mPlayerList;

    private int selected_pos = -1;
    private long list_pos = -1;


    public PlayerChooserAdapter(Context context, ArrayList<Player> playerList) {
        this.mContext = context;
        this.mPlayerList = playerList;
    }

    public long getList_pos() {
        return list_pos;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_player, null);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlayerViewHolder holder, final int position) {
        final Player player = mPlayerList.get(position);

        holder.playerText.setText(player.getPlayerTitle());
        holder.playerImage.setImageDrawable(mContext.getResources().getDrawable(player.getPlayerImage()));
        holder.levelText.setText(player.getLevelText());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selected_pos = position;
                notifyDataSetChanged();

                Toast.makeText(view.getContext(), "Item selected: list pos:"+selected_pos +list_pos, Toast.LENGTH_SHORT).show();

            }
        });

        if (selected_pos == position) {
            holder.linearLayout.setBackgroundColor(Color.YELLOW);
            holder.playerText.setTextColor(Color.BLUE);
            holder.levelText.setTextColor(Color.BLUE);
        }
        else {
            holder.linearLayout.setBackgroundColor(Color.TRANSPARENT);
            holder.playerText.setTextColor(Color.BLACK);
            holder.levelText.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return mPlayerList.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder {

        TextView playerText;
        ImageView playerImage;
        TextView levelText;
        LinearLayout linearLayout;

        public PlayerViewHolder(View view) {
            super(view);

            this.linearLayout = view.findViewById(R.id.player_ll);
            this.playerText = view.findViewById(R.id.textView_player);
            this.playerImage = view.findViewById(R.id.player_img);
            this.levelText = view.findViewById(R.id.textView_level);
        }
    }
}
