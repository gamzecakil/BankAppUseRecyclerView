package com.examples.recyclerviewexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BankAdapter extends RecyclerView.Adapter <BankAdapter.MyViewHolder> {

    //private static RecyclerViewClickListener itemListener;
    static  ArrayList<Bank> mBankList;
    LayoutInflater inflater;
    public int position;

    //Constructor
    public BankAdapter(Context context, ArrayList<Bank> banks) {
        inflater = LayoutInflater.from(context);
        this.mBankList = banks;
    }


    @NonNull
    @Override
    //Bu method adaptör oluşturulduğunda oluşturduğumuz ViewHolder'ın başlatılması için çağrılır.
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_bank_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    //OncreateViewHolder'dan dönen verileri bağlama işlemini gerçekleştirildiği metotdur.
    //Listenin hangi veri ile dolacağı ve elemana tıklanma olaylarını kontrol edeceğiz.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Bank selectedBank = mBankList.get(position);

      /*  System.out.println("Selected bank name :"+selectedBank.getBankName());
        System.out.println("Selected bank name :"+selectedBank.getBankName());*/
        holder.setData(selectedBank, position);

        //Seçilen bankanın ismini ve pozisyon degerini aldık.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Selected bank name :" + selectedBank.getBankName());
                System.out.println("Position : "+position);
            }
        });
    }


    //Listemizin eleman sayısını döndüren metotdur.
    @Override
    public int getItemCount() {
        return mBankList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView bankName, bankDescription;
        ImageView bankImage, deleteBank;


        //MyViewHolder() her bir satırımızın içinde bulunan bileşenleri tanımlama işleminin yapıldığı metotdur.
        //Constructor
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bankName = itemView.findViewById(R.id.bankName);
            bankDescription = itemView.findViewById(R.id.bankDescription);
            bankImage = itemView.findViewById(R.id.bankImage);
            deleteBank = itemView.findViewById(R.id.deleteBank);
            deleteBank.setOnClickListener(this);

            // itemView.setOnClickListener(this);


        }

        public void setData(Bank selectedBank, int position) {
            this.bankName.setText(selectedBank.getBankName());
            this.bankDescription.setText(selectedBank.getBankDescriptions());
            this.bankImage.setImageResource(selectedBank.getImageID());

            }

        @Override
        public void onClick(View view) {
            int clickedPosition=getAdapterPosition();
            System.out.println("Tıklanan position :"+clickedPosition);
           // Toast.makeText(MainActivity.this,"The Item Clicked is: "+getPosition(),Toast.LENGTH_SHORT).show();
        }
        private void deleteBank(int position){
            mBankList.remove(position);

        }
    }

     /*   @Override
        public void onClick(View view) {
            if(view==deleteBank)
                deleteBank(getLayoutPosition());

        }*/
    }

