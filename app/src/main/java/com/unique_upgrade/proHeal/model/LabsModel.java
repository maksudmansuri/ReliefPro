package com.unique_upgrade.proHeal.model;

public class LabsModel {
    private  String lab_name,lab_location,lab_timing;
    private int lab_img;

    public LabsModel(){}
    public LabsModel(String lab_name, String lab_location, String lab_timing, int lab_img) {
        this.lab_name=lab_name;
        this.lab_location=lab_location;
        this.lab_timing=lab_timing;
        this.lab_img=lab_img;
    }

    public String getLab_name() {
        return lab_name;
    }

    public void setLab_name(String lab_name) {
        this.lab_name=lab_name;
    }

    public String getLab_location() {
        return lab_location;
    }

    public void setLab_location(String lab_location) {
        this.lab_location=lab_location;
    }

    public String getLab_timing() {
        return lab_timing;
    }

    public void setLab_timing(String lab_timing) {
        this.lab_timing=lab_timing;
    }

    public int getLab_img() {
        return lab_img;
    }

    public void setLab_img(int lab_img) {
        this.lab_img=lab_img;
    }
}
