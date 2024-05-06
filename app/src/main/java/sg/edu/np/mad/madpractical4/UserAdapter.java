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


//
public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> userlist;

    public UserAdapter(ArrayList<User> UserList, ListActivity activity) {
        this.userlist = UserList;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(UserViewHolder holder, int position) {
        User List_item = userlist.get(position);
        holder.name.setText(List_item.getName());
        holder.description.setText(List_item.getDescription());
        User user = userlist.get(position);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Profile");
                builder.setMessage(user.getName());
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", user);
                        intent.putExtras(bundle);
                        v.getContext().startActivity(intent);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                ;

            }
        });
    }

    public int getItemCount() {
        return userlist.size();
    }




}