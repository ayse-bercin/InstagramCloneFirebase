package com.aysebercin.instagramclonefirebase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {

    private final ArrayList<String> userEmail;
    private final ArrayList<String> userComment;
    private final ArrayList<String> userImage;
    private final Activity context;


    public PostClass(ArrayList<String> userEmail, ArrayList<String> userComment, ArrayList<String> userImage,Activity context) {
        super(context, R.layout.custom_view,userEmail);
        this.userEmail = userEmail;
        this.userComment = userComment;
        this.userImage = userImage;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);

        TextView userEmailText = customView.findViewById(R.id.userEmailTextViewCustomView);
        ImageView postImageView = customView.findViewById(R.id.PostImageCustomView);
        TextView userCommentText = customView.findViewById(R.id.userCommentTextViewCustomView);

        userEmailText.setText(userEmail.get(position));
        userCommentText.setText(userComment.get(position));

        Picasso.get().load(userImage.get(position)).into(postImageView);


        return customView;
    }
}
