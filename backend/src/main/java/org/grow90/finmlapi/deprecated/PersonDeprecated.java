//package org.grow90.finmlapi.deprecated;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "PERSON_TBL")
//public class PersonDeprecated {
//    @Id
//    @GeneratedValue
//    private int id;
//    private String name;
//    @Basic(optional = false)
//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt = new Date();
//    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedAt = new Date();
//
//    @PreUpdate
//    public void setUpdatedAt() {
//        this.updatedAt = new Date();
//    }
//}
