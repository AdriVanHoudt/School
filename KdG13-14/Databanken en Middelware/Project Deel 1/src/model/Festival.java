package model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Adri
 * Date: 21/10/13
 * Time: 9:37
 */
@Entity
@Table(name = "t_festival")
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date startDate;
    private Date endDate;
    private String name;
    private String location;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "festivaldayId", nullable = false)
    private Set<FestivalDay> festivalDays = new HashSet<>();
}
