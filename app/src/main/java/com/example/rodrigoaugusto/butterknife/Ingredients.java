package com.example.rodrigoaugusto.butterknife;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredients implements Parcelable{


    private String measure;
    private String ingredient;
    private String quantity;

    public Ingredients(String measure, String ingredient, String quantity) {
        this.measure = measure;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }


    public String getMeasure ()
    {
        return measure;
    }

    public void setMeasure (String measure)
    {
        this.measure = measure;
    }

    public String getIngredient ()
    {
        return ingredient;
    }

    public void setIngredient (String ingredient)
    {
        this.ingredient = ingredient;
    }

    public String getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (String quantity)
    {
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [measure = "+measure+", ingredient = "+ingredient+", quantity = "+quantity+"]";
    }

    //
    //PARCELABLE SHIT
    //
    protected Ingredients(Parcel in) {
        measure = in.readString();
        ingredient = in.readString();
        quantity = in.readString();
    }


    public static final Creator<Ingredients> CREATOR = new Creator<Ingredients>() {
        @Override
        public Ingredients createFromParcel(Parcel in) {
            return new Ingredients(in);
        }

        @Override
        public Ingredients[] newArray(int size) {
            return new Ingredients[size];
        }

    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(measure);
        dest.writeString(ingredient);
        dest.writeString(quantity);
    }
    //
    //END PARCELABLE SHIT
    //

}
