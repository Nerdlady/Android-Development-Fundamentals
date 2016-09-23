package com.example.homeworkthree.taskOne;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.homeworkthree.R;

public class FragmentTwo extends Fragment {

    private ImageView imageView;
    private TextView title;
    private TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_one_information_fragment,container,false);
        this.imageView = (ImageView) view.findViewById(R.id.informationInageView);
        this.title = (TextView) view.findViewById(R.id.informationTextViewTitle);
        this.text = (TextView) view.findViewById(R.id.informationTextView);

        return view;
    }

    public void setChanges(Bitmap bitmap, String title, String text){
        this.imageView.setImageBitmap(bitmap);
        this.title.setText(title);
        this.text.setText(text);
    }
}
