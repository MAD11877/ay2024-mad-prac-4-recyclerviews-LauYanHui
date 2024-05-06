package sg.edu.np.mad.madpractical4;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                Intent activityname = new Intent(ListActivity.this, MainActivity.class);
                startActivity(activityname);
            }
        });

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<User> userList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomNum = random.nextInt(10000000);
            String name = "Name" + randomNum;
            int randomnumD = random.nextInt(10000000);
            String description = "Description" + randomnumD;
            boolean isfollowed = random.nextBoolean();
            int randomid = random.nextInt(1000);
            User user = new User(name, description, randomid, isfollowed);
            userList.add(user);
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        UserAdapter userAdapter =  new UserAdapter(this,userList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);


    }

//    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
//        ArrayList<User> userList;
//
//        public UserAdapter(ArrayList<User> userList) {
//            this.userList = userList;
//        }
//
//        @Override
//        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            // Create a new LinearLayout
//            LinearLayout layout = new LinearLayout(parent.getContext());
//            layout.setOrientation(LinearLayout.HORIZONTAL);
//            layout.setLayoutParams(new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//            // Create a new ImageView
//            ImageView imageView = new ImageView(parent.getContext());
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//            imageView.setImageResource(R.mipmap.ic_launcher);
//
//            // Inflate the existing layout
//            View item = LayoutInflater.from(parent.getContext()).inflate(
//                    android.R.layout.simple_list_item_2, null, false);
//
//            // Add the ImageView and the existing layout to the LinearLayout
//            layout.addView(imageView);
//            layout.addView(item);
//
//            return new UserViewHolder(layout); // Pass the LinearLayout to the ViewHolder
//        }
//
//
//        @Override
//        public void onBindViewHolder(UserViewHolder holder, int position) {
//            User user = userList.get(position);
//            holder.name.setText(user.name);
//            holder.description.setText(user.description);
//            holder.imageView.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v){
//                    AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this );
//                    builder.setTitle("Profile");
//                    builder.setMessage(user.name);
//                    builder.setCancelable(true);
//                    builder.setPositiveButton("Close",new DialogInterface.OnClickListener(){
//                        @Override
//                        public void onClick(DialogInterface dialog, int id){
//                            dialog.dismiss();
//                        }
//                    });
//                    builder.setNegativeButton(  "View",new DialogInterface.OnClickListener(){
//                        @Override
//                        public void onClick(DialogInterface dialog, int id){
//                            dialog.dismiss();
//                            Intent activityname = new Intent(ListActivity.this,MainActivity.class);
//                            Bundle bundle = new Bundle();
//                            bundle.putSerializable("user",user);
//                            activityname.putExtras(bundle);
//                            startActivity(activityname);
//                        }
//                    });
//                    AlertDialog alert = builder.create();
//                    alert.show();
//                }
//            });
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return userList.size();
//        }
//
//        public class UserViewHolder extends RecyclerView.ViewHolder {
//            TextView name;
//            TextView description;
//            ImageView imageView;
//
//            public UserViewHolder(View itemView) {
//                super(itemView);
//                name = itemView.findViewById(android.R.id.text1);
//                description = itemView.findViewById(android.R.id.text2);
//                imageView = (ImageView)((ViewGroup)itemView).getChildAt(0);
//            }
//        }
//    }

}
