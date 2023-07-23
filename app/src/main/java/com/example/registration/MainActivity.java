package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String userFirst;
    String userSecond;
    String userEmail;
    ArrayList<Person> userList;
    ListView userInfoScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userList = new ArrayList<Person>();
        //Finding the bottom Listview and assigning it to the main activity variable
        ListView userInfo = findViewById(R.id.textView1);
        userInfoScroll = userInfo;


    }

    //Remember that everything in the below method happens when you push the button

    public void clicked(View view) {
        //Assigning the first three textviews to instance variables
        TextView first = findViewById(R.id.firstName);
        TextView second = findViewById(R.id.lastName);
        TextView email = findViewById(R.id.email);



        userFirst = first.getText().toString() ;
        userSecond = second.getText().toString();
        userEmail = email.getText().toString();

        //I'm creating a local tring variable to hold my final message
        String outputText = "Thank you " + userFirst + " for entering your email.\n " +
                "We now have you in the system at " + userEmail;

        //Updating the bottom textview with my new final message
        //Now I'm creating a snackbar to show the text
        Snackbar.make(view, outputText, Snackbar.LENGTH_LONG)
                .show();

        Person newUser = new Person(userFirst,userSecond,userEmail);

        userList.add(newUser);

    }

    public void viewUserClick(View view) {
        //I'll make an array list of user info
        ArrayList<String> userText = new ArrayList<>();
        for(Person user : userList){
       userText.add("User " + (userList.indexOf(user) +1) + ": \n" + user.infoString() +"\n");

        }

        //I need an array adapter to put this array list onto my scrollview
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userText);

        //Now to set the array adapter to my listview
        userInfoScroll.setAdapter(adapter);



    }
}