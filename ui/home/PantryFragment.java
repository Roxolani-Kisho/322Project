package com.example.agdshfkgh.ui.home;

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

public class PantryFragment extends Fragment {

    private PantryViewModel pantryViewModel;

    private TextView response;
    private EditText input;
    private Button add;
    private Button remove;
    private SharedPreferences sp;
    public String stuff;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         sp = getContext().getSharedPreferences("ingredients", Context.MODE_PRIVATE);
        pantryViewModel =
                ViewModelProviders.of(this).get(PantryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pantry, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        pantryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        stuff="";
        input = root.findViewById(R.id.editText1);
        add = root.findViewById(R.id.add1);


        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String temp = input.getText().toString();
                if(temp.length()!= 0) {
                    response.append(temp + " ");
                    response.setVisibility(View.VISIBLE);
                }
                input.setText("");
                sp.edit().putString("ind",response.getText().toString()).apply();
            }

        });
        remove = root.findViewById(R.id.remove1);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] temp = ( response.getText().toString()).split(" ");
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
                }

                input.setText("");
                sp.edit().putString("ind",response.getText().toString()).apply();
        }

        });

        response = root.findViewById(R.id.indView);
        response.setVisibility(View.INVISIBLE);
        if(sp.getString("ind","")!=null){
            response.setVisibility(View.VISIBLE);
            response.setText(sp.getString("ind",""));
        }
        sp.edit().putString("ind",response.getText().toString()).apply();

        return root;
    }

    /*
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("MyString", response.getText().toString());

    }

    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState!=null){
            String myString = savedInstanceState.getString("MyString");
            response.setText(myString);
            response.setVisibility(View.VISIBLE);
        }

    }
    */


}
