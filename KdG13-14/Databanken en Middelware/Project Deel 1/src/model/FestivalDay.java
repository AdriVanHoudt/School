package model;

import javax.persistence.*;
import java.util.Date;

/**
 * User: Adri
 * Date: 21/10/13
 * Time: 19:10
 */
@Entity
@Table(name = "t_festivalDay")
public class FestivalDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;

}
