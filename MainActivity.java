package com.example.yusuph.andela;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.yusuph.andela.R.id.url;

public class MainActivity extends AppCompatActivity {
  ListView listView;
    private ArrayList<Profile> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create profile element
        arrayList.add(new Profile(
                        "Yusciti", "ade", "http://www.yusciti.com"
                )

        );
        arrayList.add(new Profile(
                "uncletee", "adeniyi", "http://www.yusciti.com"
        ));
        arrayList.add(new Profile(
                "uncletee", "adeniyi", "http://www.yusciti.com"
        ));
        arrayList.add(new Profile(
                "uncletee", "adeniyi", "http://www.yusciti.com"
        ));
        arrayList.add(new Profile(
                "uncletee", "adeniyi", "http://www.yusciti.com"
        ));


        ArrayAdapter adapter = new andelaAdapter(this,0,arrayList);
         listView = (ListView) findViewById(R.id.lisv);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Profile profile = (Profile) parent.getItemAtPosition(position);
                        //arrayList.get(position);
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("img",profile.getImage());
                intent.putExtra("username",profile.getUsername());
                intent.putExtra("url",profile.getUrl());
                startActivity(intent);
            }
        });


    }

   /* private AdapterView.OnItemClickListener adapterViewListener = new AdapterView.OnItemClickListener(){
        public void OnItemClick(AdapterView<?>parent, View view,int position, long id){
            Profile profile = arrayList.get(position);
            Intent intent = new Intent(MainActivity.this, DetailsActivity.this);
            intent.putExtra("image",profile.getImage());
            intent.putExtra("name",profile.getUsername());
            intent.putExtra("image",profile.getUrl());
            startActivity(intent);
            listView.setOnItemClickListener(adapterViewListener);
        }
    }*/
}
//create custom array adapter
class andelaAdapter extends ArrayAdapter<Profile>{

    private Context context;
    private List <Profile> arrayList ;
    public  andelaAdapter(Context context,int resource, ArrayList<Profile>objects) {
        super(context,resource,objects);
         this.context = context;
        this.arrayList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
    Profile profile = arrayList.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview, null);

        TextView username = (TextView) view.findViewById(R.id.username);
        TextView url = (TextView) view.findViewById(R.id.url);
        ImageView img = (ImageView) view.findViewById(R.id.imageV);

        username.setText(String.valueOf(profile.getUsername()));
       url.setText(String.valueOf(profile.getUrl()));
        Integer imageId = context.getResources().getIdentifier(profile.getImage(), "drawable",context.getPackageName());
        img.setImageResource(imageId);
        return view;

    }

}
