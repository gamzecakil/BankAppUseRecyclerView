package com.examples.recyclerviewexample;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private String bankDescription;
    private int imageID;

    public Bank(){

    }

    public Bank(String bankName, String bankDescriptions, int imageID) {
        this.bankName = bankName;
        this.bankDescription = bankDescriptions;
        this.imageID = imageID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankDescriptions() {
        return bankDescription;
    }

    public void setBankDescriptions(String bankDescriptions) {
        this.bankDescription = bankDescriptions;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
    public static ArrayList<Bank> getData(){
        ArrayList<Bank> bankList=new ArrayList<>();
        int  bankImages[]={R.drawable.garanti_logo,R.drawable.qnb,R.drawable.teb,R.drawable.vakifbank,R.drawable.yapikredi,R.drawable.ziraat};
        String[] bankNames={"Garanti","QNB","TEB","VakıfBank","Yapı Kredi","Ziraat"};
        String[] bankDescritions={"Garanti Faiz Oranları:1.70","QNB Faiz Oranları:1.59","TEB Faiz Oranları:1.80","VakıfBank Faiz Oranları:1.49","Yapı Kredi Faiz Oranları:1.56","Ziraat Bankası faiz oranları 1.48"};
        for(int i=0;i<bankImages.length;i++)
        {
            Bank temp=new Bank();
            temp.setImageID(bankImages[i]);
            temp.setBankName(bankNames[i]);
            temp.setBankDescriptions(bankDescritions[i]);
            bankList.add(temp);
        }
        return bankList;
    }
}
