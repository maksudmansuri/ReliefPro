package com.unique_upgrade.proHeal.model;

public class DiseaseModel {
  private  String disease_name,disease_symptoms;
    private int disease_img;

    public DiseaseModel(){}

    public DiseaseModel(String disease_name, String disease_symptoms, int disease_img) {
        this.disease_name=disease_name;
        this.disease_symptoms=disease_symptoms;
        this.disease_img=disease_img;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name=disease_name;
    }

    public String getDisease_symptoms() {
        return disease_symptoms;
    }

    public void setDisease_symptoms(String disease_symptoms) {
        this.disease_symptoms=disease_symptoms;
    }

    public int getDisease_img() {
        return disease_img;
    }

    public void setDisease_img(int disease_img) {
        this.disease_img=disease_img;
    }
}
