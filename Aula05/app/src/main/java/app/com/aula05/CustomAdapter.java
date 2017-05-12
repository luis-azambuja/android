package app.com.aula05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item>{

    Context context;
    List<Item> items;

    public CustomAdapter(Context context, List<Item> items) {
        super(context, R.layout.item, items);
        this.context = context;
        this.items = items;
    }

    class ViewHolder{
        private ImageView avatar, photo;
        private TextView name, local, likes, description;
        private ImageButton button;
        public ViewHolder(){}

        public ViewHolder(ImageView avatar, ImageView photo, TextView name, TextView local, TextView likes, TextView description) {
            this.avatar = avatar;
            this.photo = photo;
            this.name = name;
            this.local = local;
            this.likes = likes;
            this.description = description;
        }

        public ImageView getAvatar() {
            return avatar;
        }

        public void setAvatar(ImageView avatar) {
            this.avatar = avatar;
        }

        public ImageView getPhoto() {
            return photo;
        }

        public void setPhoto(ImageView photo) {
            this.photo = photo;
        }

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public TextView getLocal() {
            return local;
        }

        public void setLocal(TextView local) {
            this.local = local;
        }

        public TextView getLikes() {
            return likes;
        }

        public void setLikes(TextView likes) {
            this.likes = likes;
        }

        public TextView getDescription() {
            return description;
        }

        public void setDescription(TextView description) {
            this.description = description;
        }

        public ImageButton getButton() {
            return button;
        }

        public void setButton(ImageButton button) {
            this.button = button;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.item, parent, false);

            viewHolder.setName((TextView) convertView.findViewById(R.id.textViewName));
            viewHolder.setButton((ImageButton) convertView.findViewById(R.id.imageButton) );
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.getName().setText("RONALDINHO");//TODO);

        viewHolder.button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO
            }
        });


        // Return the completed view to render on screen
        return convertView;

    }
}
