package com.rohit.examples.android.clanofwars;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rohit.examples.android.clanofwars.model.Player;
import com.rohit.examples.android.clanofwars.model.Team;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class TeamChooserAdapter extends RecyclerView.Adapter<TeamChooserAdapter.TeamViewHolder>{
    private Context mContext;
    private ArrayList<Team> mTeamList;
    private RecyclerView.RecycledViewPool recycledViewPool;

   // private int[] listarr = new int[Objects.requireNonNull(mTeamList).size()];


    public TeamChooserAdapter(Context context, ArrayList<Team> teamList) {
        this.mContext = context;
        this.mTeamList = teamList;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_team, null);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, final int position) {
        final String teamName = mTeamList.get(position).getTeam_Title();
        final ArrayList<Player> players = mTeamList.get(position).getAllPlayersInTeam();

        holder.teamText.setText(teamName);
        PlayerChooserAdapter playerChooserAdapter = new PlayerChooserAdapter(mContext, players);

        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(playerChooserAdapter);
        holder.recyclerView.setRecycledViewPool(recycledViewPool);

        RecyclerSnapHelper recyclerSnapHelper = new RecyclerSnapHelper();
        recyclerSnapHelper.attachToRecyclerView(holder.recyclerView);

//        Log.v("activity", "listsize" +mTeamList.size());
        
    }

    @Override
    public int getItemCount() {
        return mTeamList.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView teamText;
        RecyclerView recyclerView;

        public TeamViewHolder(final View view) {
            super(view);

            this.recyclerView = view.findViewById(R.id.player_recyclerview);
            this.teamText = view.findViewById(R.id.textView_team);

        }
    }
}
