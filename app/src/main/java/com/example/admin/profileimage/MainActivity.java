package com.example.admin.profileimage;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int SELECT_PICTURE = 1;

    FloatingActionButton f;
    ImageView img;
    List<Friends> friendList = new ArrayList<>();
    RecyclerView recyclerView;
    adapterrecycle fAdapter;
    GridView gridView;
    private String selectedImagePath;

    String[] Name = {
            "Sahil",
            "Ridham",
            "Aagam",
            "Vardhan",
            "Rohit",
            "Disha"};

    int[] imageId = {
            R.drawable.ic_image,R.drawable.ic_image,R.drawable.ic_image,R.drawable.ic_image,R.drawable.ic_image,R.drawable.ic_image};

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                System.out.println("Image Path : " + selectedImagePath);
                img.setImageURI(selectedImageUri);
            }
        }
    }

    private String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridview_class adapter = new gridview_class(MainActivity.this, Name, imageId);
        gridView=(GridView)findViewById(R.id.gridview);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "You Clicked at " + " "+ Name [+position], Toast.LENGTH_SHORT).show();

            }
        });



        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fAdapter = new adapterrecycle(friendList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(fAdapter);

        prepareFriendData();

        f = (FloatingActionButton) findViewById(R.id.fab);
        img = (ImageView) findViewById(R.id.img);

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_PICTURE);
            }
        });
    }

    private void prepareFriendData() {
        Friends friend = new Friends("Sahil","sahil@gmail.com");
        friendList.add(friend);

        friend = new Friends("Ridham", "ridham@gmail.com");
        friendList.add(friend);

        friend = new Friends("Aagam", "aagam@gmail.com");
        friendList.add(friend);

        friend = new Friends("abcd", "r@gmail.com");
        friendList.add(friend);

    }





}