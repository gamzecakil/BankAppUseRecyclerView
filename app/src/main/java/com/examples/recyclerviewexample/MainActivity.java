package com.examples.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView;
        recyclerView=findViewById(R.id.recyclerView);

        BankAdapter bankAdapter=new BankAdapter(this,Bank.getData());
        recyclerView.setAdapter(bankAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Tıklanan bilgisini activitede alma
        //reccyelrView tıklanması
       recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
           @Override
           public void onClick(View view, int position) {
               System.out.println("Position  in MainActivity  : "+position);


              /* Intent resultIntent=new Intent();
               resultIntent.putExtra("position",position);
               setResult(RESULT_OK,resultIntent);
               //bu aktiviteyi kapat
               finish();*/
           }

           @Override
           public void onLongClick(View view, int position) {

           }
       }));


    }


}