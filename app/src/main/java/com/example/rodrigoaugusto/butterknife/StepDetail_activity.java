package com.example.rodrigoaugusto.butterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class StepDetail_activity extends AppCompatActivity {


    Steps step;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_detail);

        Log.v("RAG","onCreate steps detail");

        //get the data (recipe class) from the parent activity
        Intent intent = getIntent();
        step = intent.getParcelableExtra("step");

        setTitle(step.getShortDescription());

        //fragment exoplayer
        FragmentStepDetail mFragmentStepDetail = new FragmentStepDetail();

        Log.v("RAG","=>"+step.getDescription());

        //send data to fragment
        Bundle bundle = new Bundle();
        bundle.putParcelable("step", step);
        mFragmentStepDetail.setArguments(bundle);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.container_frag_step_detail, mFragmentStepDetail).commit();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                Log.v("RAG", this.getClass().getSimpleName() + " home");
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
