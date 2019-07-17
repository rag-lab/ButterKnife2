package com.example.rodrigoaugusto.butterknife;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class Ingredients_activity extends AppCompatActivity {

    Recipes recipe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        //get the data (recipe class) from the parent activity
        Intent intent = getIntent();
        recipe = intent.getParcelableExtra("recipe");

        setTitle(recipe.getName() + " - Ingredients");

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        FragmentIngredients mFragmentListIngredients = new FragmentIngredients();

        //send data to fragment
        Bundle bundle = new Bundle();
        bundle.putParcelable("Recipe", recipe);
        mFragmentListIngredients.setArguments(bundle);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.gridIngredients, mFragmentListIngredients).commit();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                Log.v("RAG", this.getClass().getSimpleName() + " home");
                //Intent intent = new Intent(getApplicationContext(),StepsActivity.class);
                //put recipes inside it
                //intent.putExtra("recipe", recipe);
                //startActivity(intent);
                finish();

                //NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("RAG", this.getClass().getSimpleName() + " pause");
    }

    @Override
    protected void onStop() {
        Log.v("RAG", this.getClass().getSimpleName() + " stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("RAG", this.getClass().getSimpleName() + "destroy");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v("RAG", this.getClass().getSimpleName() + " onBackPressed()");
    }


}
