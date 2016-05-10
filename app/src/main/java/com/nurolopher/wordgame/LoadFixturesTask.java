package com.nurolopher.wordgame;

import android.content.Context;
import android.os.AsyncTask;

import com.nurolopher.wordgame.complexity.Complexity;

import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;

/**
 * Created by Nursultan Turdaliev on 5/10/16.
 */
public class LoadFixturesTask extends AsyncTask<Context, Integer, Integer> {

    private Realm realm;

    private Context context;

    @Override
    protected Integer doInBackground(Context... contexts) {

        realm = Realm.getInstance(contexts[0]);
        this.context = contexts[0];
        loadAll();
        return 1;
    }

    private void loadAll() {
        try {
            loadComplexities();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadComplexities() throws IOException {

        InputStream inputStream = context.getAssets().open("fixtures/complexities.json");
        realm.beginTransaction();
        realm.createAllFromJson(Complexity.class, inputStream);
        realm.commitTransaction();
        inputStream.close();
    }
}
