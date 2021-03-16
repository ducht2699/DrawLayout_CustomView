package com.example.drawlayout_customview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawlayout_customview.R;

import java.util.List;

public class KeyWordAdapter extends RecyclerView.Adapter<KeyWordAdapter.ViewHolder> {
    private List<String> keyWords;
    private Context context;

    public KeyWordAdapter(List<String> keyWords, Context context) {
        this.keyWords = keyWords;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.keyword_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.m_tvKeyWord.setText(keyWords.get(position));
    }

    @Override
    public int getItemCount() {
        return keyWords.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView m_tvKeyWord;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            m_tvKeyWord = itemView.findViewById(R.id.tv_keyword);
        }
    }
}
