package com.example.jpa2.entity;

import javax.persistence.*;

// ============================= Joined strategy.==============================
//@Entity
//@Table(name = "bankcheck")
//@PrimaryKeyJoinColumn(name = "id")
//public class Check extends Payment {
//
//    @Column(name = "checknumber")
//    private String checkNumber;
//
//    public String getCheckNumber() {
//        return checkNumber;
//    }
//
//    public void setCheckNumber(String checkNumber) {
//        this.checkNumber = checkNumber;
//    }
//}
//=============================single type strategy ============================

@Entity
@Table(name = "payment")
@DiscriminatorValue("ch")
public class Check extends Payment {
    private String checkNumber;

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}


//================ tables for Table Per Class strategy. =====================
/*
@Entity
@Table(name = "bankcheck")
public class Check extends Payment {
    @Column(name = "checknumber")
    private String checkNumber;

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}
 */