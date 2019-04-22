package com.example.tanmay.bingeapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LikeScreen extends AppCompatActivity {

    public ImageView backBtn;

    int[] IMAGES = {R.drawable.wonderwoman};

    String[] NAMES = {"Wonderwoman"};

    String[] DESCRIPTIONS = {"Action"};

    public void likes() {
        backBtn = (ImageView) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMovieScreen = new Intent(LikeScreen.this,MovieScreenTwo.class);
                startActivity(backToMovieScreen);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.likes_screen);
        likes();

        ListView listView = (ListView) findViewById(R.id.listView);

        CustomeAdapter customeAdapter = new CustomeAdapter();

        listView.setAdapter(customeAdapter);
    }

    class CustomeAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView_name = (TextView)view.findViewById(R.id.textView3_name);
            TextView textView3_description = (TextView) view.findViewById(R.id.textView4_description);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView3_description.setText(DESCRIPTIONS[i]);

            return view;
        }
    }
}

