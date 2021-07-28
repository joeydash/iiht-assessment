//package org.grow90.finmlapi.deprecated;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.grow90.finmlapi.deprecated.Person;
//import org.grow90.finmlapi.entity.Sector;
//import org.grow90.finmlapi.entity.StockExchange;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "COMPANY_TBL")
//public class CompanyDeprecated {
//
//    @Id
//    @GeneratedValue
//    private int id;
//    private String companyName;
//    private double turnover;
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "company_ceo_id", referencedColumnName = "id")
//    private Person cEO;
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "company_directors",
//            joinColumns = {@JoinColumn(name = "company_id")},
//            inverseJoinColumns = {@JoinColumn(name = "person_id")})
//    private List<Person> boardOfDirectors;
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "company_exchanges",
//            joinColumns = {@JoinColumn(name = "company_id")},
//            inverseJoinColumns = {@JoinColumn(name = "stock_exchange_id")})
//    private List<StockExchange> listedInStockExchanges;
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "company_sector_id", referencedColumnName = "id")
//    private Sector sector;
//    private String details;
//    @Column(unique = true)
//    private String symbol;
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
