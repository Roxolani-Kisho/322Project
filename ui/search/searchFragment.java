package com.example.agdshfkgh.ui.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.agdshfkgh.R;

public class searchFragment extends Fragment {

    private searchViewModel searchViewModel;
    private Button search;
    private TextView response;
    private String message ="Spaghetti Carbonara";
    private TextView ingList;
    private SharedPreferences sp;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(searchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        search =  root.findViewById(R.id.confirm);
        response = root.findViewById(R.id.responses);
        ingList = root.findViewById(R.id.indList);
        response.setVisibility(View.INVISIBLE);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                response.setText(message);
                response.setVisibility(View.VISIBLE);
            }

        });
        sp = getContext().getSharedPreferences("ingredients", Context.MODE_PRIVATE);
        ingList.setText(sp.getString("ind",""));
        searchViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    public void onResume(){
        super.onResume();

    }
}
