package com.example.user.introductionpageandnewspage.news_page;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.introductionpageandnewspage.R;

/**
 * Created by user on 18/8/2017.
 */

public class NewsAdapter extends ArrayAdapter<String> {
    String [] names;
    int [] pics;
    String [] title;
    Context context;


    public NewsAdapter(Context context, String [] textnews, int [] imagenews,String [] title) {
        super(context, R.layout.news_page_listview_item_news);
        this.names = textnews;
        this.pics = imagenews;
        this.context = context;
        this.title = title;
    }

    @Override
    public int getCount() {
        return names.length;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.news_page_listview_item_news, parent, false);
            mViewHolder.mpics = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mNames = (TextView) convertView.findViewById(R.id.textView);
            mViewHolder.mTitle = (TextView) convertView.findViewById(R.id.tv_description);

            convertView.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder)convertView.getTag();
        }
        mViewHolder.mpics.setImageResource(pics[position]);
        mViewHolder.mNames.setText(names[position]);
        mViewHolder.mTitle.setText(title[position]);

        return convertView;
    }
    static class ViewHolder{
        ImageView mpics;
        TextView mNames;
        TextView mTitle;
    }
}
