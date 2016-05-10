package com.nurolopher.wordgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nurolopher.wordgame.complexity.Complexity;
import com.nurolopher.wordgame.complexity.ComplexityAdapter;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity {

    private static final String LAUNCHED = "launched";
    private Realm realm;
    private RealmResults<Complexity> complexities;
    private ComplexityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configProperties();
        loadFixtures();
        configRecyclerView();
    }

    private void configProperties() {
        realm = Realm.getInstance(this);
    }

    private void configRecyclerView() throws NullPointerException {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.complexityListView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(layoutManager);

            complexities = realm.where(Complexity.class).findAllSorted("id", Sort.ASCENDING);
            adapter = new ComplexityAdapter(complexities);

            recyclerView.setAdapter(adapter);
            realm.addChangeListener(new RealmChangeListener() {
                @Override
                public void onChange() {
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }

    private void loadFixtures() {
        if (!isLaunched()) {
            new LoadFixturesTask().execute(this);
        }
    }

    private boolean isLaunched() {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        boolean launched = sharedPreferences.getBoolean(MainActivity.LAUNCHED, false);
        if (!launched) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(MainActivity.LAUNCHED, true);
            editor.apply();
        }
        return launched;
    }
}
