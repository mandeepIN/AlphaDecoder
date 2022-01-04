package com.example.alphadecoder.ui.assistant;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.alphadecoder.R;
import com.example.alphadecoder.utils.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LanguageSelectionListAdapter extends RecyclerView.Adapter<LanguageSelectionListAdapter.ViewHolder> {

    Map<String, String> languageMap;
    private int selectedPos = -1;
    private int lastPos = -1;
    List<String> languageCodeList;

    public LanguageSelectionListAdapter(Map<String, String> languageMap) {
        this.languageMap = languageMap;
        languageCodeList = new ArrayList<>();
        languageCodeList.addAll(languageMap.keySet());
        String selectedLanguageCode = Preferences.getMotherTongue().trim();
        if (languageCodeList.contains(selectedLanguageCode))
            selectedPos = languageCodeList.indexOf(selectedLanguageCode);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_language_selection, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String languageCode = languageCodeList.get(position);
        String language = languageMap.get(languageCode);
        holder.setData(language);
    }

    @Override
    public int getItemCount() {
        return languageCodeList.size();
    }

    public String getSelectedLanguageCode() {
        return languageCodeList.get(selectedPos);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvLanguage;
        ImageView ivSelected;

        public ViewHolder(View itemView) {
            super(itemView);
            tvLanguage = itemView.findViewById(R.id.tv_language);
            ivSelected = itemView.findViewById(R.id.iv_selected);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedPos = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }

        public void setData(String language) {
            tvLanguage.setText(language);
            if (selectedPos == getAdapterPosition()) {
                tvLanguage.setTextColor(ContextCompat.getColor(tvLanguage.getContext(), R.color.language_selected_color));
                ivSelected.setVisibility(View.VISIBLE);
            } else {
                tvLanguage.setTextColor(ContextCompat.getColor(tvLanguage.getContext(), R.color.language_list_text_color));
                ivSelected.setVisibility(View.GONE);
            }
        }
    }
}
