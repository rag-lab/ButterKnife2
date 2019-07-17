package com.example.rodrigoaugusto.butterknife;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentSteps extends Fragment {


    View v;
    private List<Steps> lstSteps = new ArrayList<>();
    Steps_RV_Adapter listSteps_recViewAdapter;
    RecyclerView Steps_recview; //recyclcerview das receitas
    private Bundle stepsBundle = new Bundle(); //usado no loader das recipes


    public FragmentSteps() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Recipes recipe;
        recipe = new Recipes(Parcel.obtain());

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            recipe = bundle.getParcelable("Recipe");
            Steps[] step = recipe.getSteps();
        }

        Steps[] steps = recipe.getSteps();
        for(int r=0;r<steps.length;r++){
            Steps tmpStep = steps[r];
            lstSteps.add(tmpStep);
        }


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_steps, container, false);

        Steps_recview = (RecyclerView) v.findViewById(R.id.listSteps_recView);
        Steps_recview.setLayoutManager(new LinearLayoutManager(getActivity()));

        Steps_recview.addItemDecoration(
                new DividerItemDecoration(container.getContext(), DividerItemDecoration.VERTICAL));


        listSteps_recViewAdapter = new Steps_RV_Adapter(lstSteps);
        Steps_recview.setAdapter(listSteps_recViewAdapter);

        return v;

    }



}
