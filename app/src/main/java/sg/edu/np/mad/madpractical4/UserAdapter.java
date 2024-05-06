package sg.edu.np.mad.madpractical4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    Context context;
    ArrayList<User> userList;


        public UserAdapter(Context context,ArrayList<User> userList) {
            this.context = context;
            this.userList = userList;
        }


        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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

            return new UserViewHolder(layout); // Pass the LinearLayout to the ViewHolder
        }



        public void onBindViewHolder(UserViewHolder holder, int position) {
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


}

