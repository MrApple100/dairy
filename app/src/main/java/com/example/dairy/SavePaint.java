package com.example.dairy;

import java.util.ArrayList;

public class SavePaint {
    private ArrayList<Integer> savinglist=new ArrayList<Integer>();

    public SavePaint(ArrayList<Integer> savinglist) {
        this.savinglist = savinglist;
    }

    public ArrayList<Integer> getSavinglist() {
        return savinglist;
    }

    public void setSavinglist(ArrayList<Integer> savinglist) {
        this.savinglist = savinglist;
    }
}
