package com.example.agdshfkgh.ui.cookbook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.agdshfkgh.R;

public class cookbookFragment extends Fragment {

    private cookbookViewModel cookbookViewModel;
    private TextView response;
    private EditText input;
    private Button add;
    private Button remove;
    private SharedPreferences sp;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cookbookViewModel =
                ViewModelProviders.of(this).get(cookbookViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cookbook, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        cookbookViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        input = root.findViewById(R.id.editText2);
        add = root.findViewById(R.id.add2);
        sp = getContext().getSharedPreferences("recipe", Context.MODE_PRIVATE);
        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String temp = input.getText().toString();
                if(temp.length()!= 0) {
                    response.append(temp+ " ");
                    response.setVisibility(View.VISIBLE);
                    sp.edit().putString("rec",response.getText().toString()).apply();
                }
                input.setText("");
            }

        });
        remove = root.findViewById(R.id.remove2);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] temp = ((String) response.getText()).split(" ");
                String remove =  input.getText().toString();

                int index=-1;
                for(int i=0; i<temp.length;i++){
                    if(temp[i].equals(remove)){
                        index=i;
                    }
                }
                if(index!=-1){
                    String ans ="";
                    for(int i=0; i<temp.length;i++){
                        if(index!=i){
                            ans +=(temp[i]+ " ");
                        }
                    }
                    response.setText(ans);
                    sp.edit().putString("rec",response.getText().toString()).apply();
                }

                input.setText("");
            }

        });

        response = root.findViewById(R.id.recView);
        response.setVisibility(View.INVISIBLE);
        if(sp.getString("rec","")!=null){
            response.setVisibility(View.VISIBLE);
            response.setText(sp.getString("rec",""));
        }
        sp.edit().putString("rec",response.getText().toString()).apply();
        return root;
    }
}
