package com.example.jpa2.entity;

import javax.persistence.*;
// ============================= Joined strategy.==============================
//@Entity
//@Table(name = "card")
//@PrimaryKeyJoinColumn(name = "id")
//public class CreditCard extends Payment {
//    private String cardnumber;
//
//    public String getCardnumber() {
//        return cardnumber;
//    }
//
//    public void setCardnumber(String cardnumber) {
//        this.cardnumber = cardnumber;
//    }
//}
// =============================single type strategy ============================

@Entity
@DiscriminatorValue("cc")
public class CreditCard extends Payment {
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}


//================ tables for Table Per Class strategy. =====================
/*
@Entity
@Table(name = "card")
public class CreditCard extends Payment {
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
*/