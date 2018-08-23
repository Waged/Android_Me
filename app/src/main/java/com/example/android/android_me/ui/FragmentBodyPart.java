package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class FragmentBodyPart extends Fragment {


    private List<Integer> mImageIds;
    private int mListIndex;
    static final String IMAGE_ID_LIST = "IMAGE_LIST" ;
    static final String LIST_INDEX = "IMAGE_INDEX" ;

    public FragmentBodyPart() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            if(savedInstanceState != null){
                mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
                mListIndex = savedInstanceState.getInt(LIST_INDEX);

            }
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);


        if (mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    }
                    else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });

        } else {
            Log.e("mImageIds", "is Null !");
        }


        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
      currentState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>)mImageIds);
      currentState.putInt(LIST_INDEX,mListIndex);



    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

}
