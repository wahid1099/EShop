package com.example.e_shop;

public class catogery_model {
    private int catoger_iconlink;
    private String catogery_name;

    public int getCatoger_iconlink() {
        return catoger_iconlink;
    }

    public void setCatoger_iconlink(int catoger_iconlink) {
        this.catoger_iconlink = catoger_iconlink;
    }

    public String getCatogery_name() {
        return catogery_name;
    }

    public void setCatogery_name(String catogery_name) {
        this.catogery_name = catogery_name;
    }

    public catogery_model(int catoger_iconlink, String catogery_name) {
        this.catoger_iconlink = catoger_iconlink;
        this.catogery_name = catogery_name;
    }
}
