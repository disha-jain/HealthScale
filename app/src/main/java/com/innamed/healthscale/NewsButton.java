package com.innamed.healthscale;

import android.content.Context;
import android.widget.ImageButton;
import android.util.AttributeSet;

/**
 * Created by diyarocker on 7/21/16.
 */
public class NewsButton extends ImageButton {

    private String articleTitle;
    private boolean clicked = false;
    private int indexNumber;
    public NewsButton(Context context){
        super(context);
    }
    public NewsButton(Context context, String name, int index){
        super(context);
        articleTitle = name;
        indexNumber = index;
    }
    public String getArticleTitle(){
        return articleTitle;
    }
    public boolean isClicked(){
        return clicked;
    }
    public void setClicked(boolean c){
        clicked = c;
    }
    public int getIndexNumber(){
        return indexNumber;
    }

}
