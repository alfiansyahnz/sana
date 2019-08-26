package com.sana;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    //Array

    public int[] slide_image = {
            R.drawable.on_1,
            R.drawable.on_2,
            R.drawable.on_3
    };

    public String[] slide_headings = {
            "DONASI",
            "VOLUNTEER",
            "EVENT & CHALLENGE"
    };
    public String[] slide_desk = {
            "Menyediakan wadah untuk para donatur yang " +
                    "ingin mendonasikan uangnya sebagai\n" +
                    "salah satu bentuk kepedulian terhadap\n" +
                    "lingkungan",
            "Bersama - sama menyumbangkan tenaga\n" +
                    "untuk menjaga keasrian lingkungan hidup\n" +
                    "dan melestarikannya melalui kegiatan sosial",
            "Acara tahunan dan challenge berhadiah\n" +
                    "diadakan secara rutin untuk\n" +
                    "menarik perhatian masyarakat"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view,Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout_adapter, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desk[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);
    }
}
