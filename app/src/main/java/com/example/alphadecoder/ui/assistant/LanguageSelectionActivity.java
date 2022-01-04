package com.example.alphadecoder.ui.assistant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alphadecoder.R;
import com.example.alphadecoder.utils.Preferences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LanguageSelectionActivity extends AppCompatActivity {

    LanguageSelectionListAdapter adapter;
    RecyclerView rvLanguageSelection;
    private Context context;
    private String source;
    private long mStartTime = 0;


    public static final String LANGUAGE_CHANGE_ACTION = "com.mofirst.playstore.app.LANGUAGE_CHANGE";
    public static final String LANGUAGE_CODE = "LANGUAGE_CODE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);
        this.setFinishOnTouchOutside(false);
        context = this;

        if (getIntent() != null && getIntent().getExtras() != null) {
            source = getIntent().getExtras().getString("source") != null ? getIntent().getExtras().getString("source") : "";
        }

        setupLanguageList();
        TextView btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedLanguageCode = adapter.getSelectedLanguageCode();
                Preferences.setMotherTongue(selectedLanguageCode);
                Preferences.setMotherTongueSelectedByUser(true);

                Intent intent = new Intent(LANGUAGE_CHANGE_ACTION);
                intent.putExtra(LANGUAGE_CODE, selectedLanguageCode);
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                finish();
            }
        });


    }

    private void setupLanguageList() {
        List<String> languageList = Arrays.asList(getResources().getStringArray(R.array.languages));
        Map<String, String> dataMap = new HashMap<>();
        for (String language : languageList) {
            String[] nameKey = language.split("\\|");
            String languageCode = nameKey[0].trim();
            String languageName = nameKey[1].trim();
            dataMap.put(languageCode, languageName);
        }

        adapter = new LanguageSelectionListAdapter(dataMap);
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        decoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        rvLanguageSelection = findViewById(R.id.rv_language_selection);
        rvLanguageSelection.setHasFixedSize(true);
        rvLanguageSelection.setLayoutManager(new LinearLayoutManager(this));
        rvLanguageSelection.addItemDecoration(decoration);
        rvLanguageSelection.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;

    }
}
