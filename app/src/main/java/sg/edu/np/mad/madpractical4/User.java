package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    public String name;
    public String description;
    public int id;
    public boolean followed;
    public User(String name, String description, int id, boolean followed){
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;

    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public boolean getFollowed() {
        return followed;
    }
    public static class UserAdapter extends RecyclerView.Adapter<User.UserAdapter.UserViewHolder> {
        ArrayList<User> userList;
        Context context;

        public UserAdapter(Context context,ArrayList<User> userList) {
            this.userList = userList;
            this.context = context;
        }

        @Override
        public User.UserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Create a new LinearLayout
            LinearLayout layout = new LinearLayout(parent.getContext());
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            // Create a new ImageView
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setImageResource(R.mipmap.ic_launcher);

            // Inflate the existing layout
            View item = LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_2, null, false);

            // Add the ImageView and the existing layout to the LinearLayout
            layout.addView(imageView);
            layout.addView(item);

            return new User.UserAdapter.UserViewHolder(layout); // Pass the LinearLayout to the ViewHolder
        }


        @Override
        public void onBindViewHolder(User.UserAdapter.UserViewHolder holder, int position) {
            User user = userList.get(position);
            holder.name.setText(user.name);
            holder.description.setText(user.description);
            holder.imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    AlertDialog.Builder builder = new AlertDialog.Builder(context );
                    builder.setTitle("Profile");
                    builder.setMessage(user.name);
                    builder.setCancelable(true);
                    builder.setPositiveButton("Close",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int id){
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton(  "View",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int id){
                            dialog.dismiss();
                            Intent activityname = new Intent(context,MainActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("user",user);
                            activityname.putExtras(bundle);
                            context.startActivity(activityname);
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return userList.size();
        }

        public class UserViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            TextView description;
            ImageView imageView;

            public UserViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(android.R.id.text1);
                description = itemView.findViewById(android.R.id.text2);
                imageView = (ImageView)((ViewGroup)itemView).getChildAt(0);
            }
        }
    }

}
