package com.nurolopher.wordgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.nurolopher.wordgame.complexity.Complexity;

import java.util.ArrayList;
import java.util.Random;

import io.realm.Realm;

public class PlayActivity extends AppCompatActivity {

    private Realm realm;
    private Complexity complexity;
    private GridView gridView;
    private Grid grid;
    private GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initProperties();
        configToolbar();
        getComplexityFromIntent();
        initGrid();
        initAdapter();
        configGridView();
    }

    private void configGridView() {
        gridView.setNumColumns(complexity.getSize());
        gridView.setAdapter(gridAdapter);
    }

    private void initAdapter() {
        gridAdapter = new GridAdapter(this, grid);
    }

    private void initGrid() {
        grid = new Grid();
        for (char letter : getLetters()) {
            Cell cell = new Cell(letter);
            grid.addCell(cell);
        }
    }

    private ArrayList<Character> getLetters() {
        int squareOfSize = complexity.getSize() * complexity.getSize();
        Random r = new Random();
        ArrayList<Character> letters = new ArrayList<>(squareOfSize);
        for (int index = 0; index < squareOfSize; index++) {
            char c = (char) (r.nextInt(26) + 'a');
            letters.add(c);
        }
        return letters;
    }

    private void initProperties() {
        realm = Realm.getInstance(this);
        gridView = (GridView) findViewById(R.id.gridView);
    }

    private void configToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void getComplexityFromIntent() {
        Intent intent = getIntent();
        int id = intent.getIntExtra(Complexity.ITEM_ID, 1);
        complexity = realm.where(Complexity.class).equalTo("id", id).findFirst();
    }

}
