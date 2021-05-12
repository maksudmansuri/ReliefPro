package com.unique_upgrade.ReliefPro.model

class DiseaseModel {
    var disease_name: String? = null
    var disease_symptoms: String? = null
    var disease_img = 0

    constructor() {}
    constructor(disease_name: String?, disease_symptoms: String?, disease_img: Int) {
        this.disease_name = disease_name
        this.disease_symptoms = disease_symptoms
        this.disease_img = disease_img
    }
}