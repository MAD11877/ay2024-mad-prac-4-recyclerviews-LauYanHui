package sg.edu.np.mad.madpractical4;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        User user = (User)intent.getSerializableExtra("user");
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        if (user.followed) {
            btnFollow.setText("Unfollow");
        } else {
            btnFollow.setText("Follow");
        }


        btnFollow.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
                if (user.followed) {
                    user.followed = false;
                    btnFollow.setText("Follow");
                    Toast.makeText(MainActivity.this, "UnFollowed", Toast.LENGTH_SHORT).show();

                } else {
                    user.followed = true;
                    btnFollow.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();

                }
            }
        });
//        Button BtnMessage = findViewById(R.id.btnMessage);
//        BtnMessage.setOnClickListener(new View.OnClickListener(){
//            @Override public void onClick(View v){
//                Intent activityname = new Intent(MainActivity.this,message.class);
//                startActivity(activityname);
//            }
//        });

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}