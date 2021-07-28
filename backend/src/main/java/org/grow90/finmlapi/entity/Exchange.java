package org.grow90.finmlapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock_exchanges")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String stockExchange;
    private String brief;
    private String contactAddress;
    private String remarks;
    //    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "exchanges")
//    private Set<Company> companies= new HashSet<Company>();
    @Basic(optional = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();



    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }
}
