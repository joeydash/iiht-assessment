package org.grow90.finmlapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private double turnover;
    private String cEO;
    private String boardOfDirectors;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "company_exchanges",
            joinColumns = {@JoinColumn(name = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "exchange_id")})
    private List<Exchange> exchanges = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sector_id", referencedColumnName = "id")
    private Sector sector;
    private String details;
    @Column(unique = true)
    private String symbol;
    @Basic(optional = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();

    public Company(String companyName, double turnover, String cEO, String boardOfDirectors, String details, String symbol) {
        this.companyName = companyName;
        this.turnover = turnover;
        this.cEO = cEO;
        this.boardOfDirectors = boardOfDirectors;
        this.details = details;
        this.symbol = symbol;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }
}
