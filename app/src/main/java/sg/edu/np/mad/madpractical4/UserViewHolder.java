package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView description;
    ImageView imageView;

    public UserViewHolder(View itemView) {
        super(itemView);
//        name = itemView.findViewById(android.R.id.text1);
//        description = itemView.findViewById(android.R.id.text2);
//        imageView = (ImageView) ((ViewGroup) itemView).getChildAt(0);
            name = itemView.findViewById(R.id.tvName);
            imageView = itemView.findViewById(R.id.ivSmallImage);
            description = itemView.findViewById(R.id.tvDescription);

    }

}
