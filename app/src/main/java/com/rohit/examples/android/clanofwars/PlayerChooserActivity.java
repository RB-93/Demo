package com.rohit.examples.android.clanofwars;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.rohit.examples.android.clanofwars.model.Player;
import com.rohit.examples.android.clanofwars.model.Team;

import java.util.ArrayList;

public class PlayerChooserActivity extends AppCompatActivity {

    private ArrayList<Team> mAllTeamList;
    private ArrayList<Player> mAllPlayerList;

    private char teamLetter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chooser);

        RecyclerView mRecyclerView = findViewById(R.id.team_recylcerview);
        RecyclerView recyclerView = findViewById(R.id.player_recyclerview);
        mAllTeamList = new ArrayList<>();
        mAllPlayerList = new ArrayList<>();

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        TeamChooserAdapter teamChooserAdapter = new TeamChooserAdapter(this, mAllTeamList);
        LinearLayoutManager linearLayoutManagerStart = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManagerStart);
        mRecyclerView.setAdapter(teamChooserAdapter);

        teamLetter = 'A';
        for(int i = 1; i <= 2; i++) {
            Team team = new Team();
            team.setId(i);
            team.setTeam_Title("TEAM " + teamLetter);
            ArrayList<Player> mAllPlayerList = new ArrayList<>();

            mAllPlayerList.add(new Player(i, R.drawable.barbarian1, "Barbarian", "Level 1"));
            mAllPlayerList.add(new Player(i, R.drawable.archer, "Archer", "Level 1"));
            mAllPlayerList.add(new Player(i, R.drawable.giants, "Giants", "Level 2"));
            mAllPlayerList.add(new Player(i, R.drawable.goblin, "Goblin", "Level 3"));
            mAllPlayerList.add(new Player(i, R.drawable.wallbreaker, "Wall Breaker", "Level 4"));
            mAllPlayerList.add(new Player(i, R.drawable.balloon, "Balloon", "Level 4"));
            mAllPlayerList.add(new Player(i, R.drawable.wizard, "Wizard", "Level 5"));
            mAllPlayerList.add(new Player(i, R.drawable.healer, "Healer", "Level 5"));

            team.setAllPlayersInTeam(mAllPlayerList);
            mAllTeamList.add(team);

            teamLetter = 'A' + 1 ;
        }
    }
}
