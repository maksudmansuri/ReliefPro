package com.unique_upgrade.ReliefPro.model

class LabsModel {
    var lab_name: String? = null
    var lab_location: String? = null
    var lab_timing: String? = null
    var lab_img = 0

    constructor() {}
    constructor(lab_name: String?, lab_location: String?, lab_timing: String?, lab_img: Int) {
        this.lab_name = lab_name
        this.lab_location = lab_location
        this.lab_timing = lab_timing
        this.lab_img = lab_img
    }
}