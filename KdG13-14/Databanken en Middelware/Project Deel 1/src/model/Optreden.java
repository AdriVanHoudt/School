package model;

import javax.persistence.*;

/**
 * User: Adri
 * Date: 21/10/13
 * Time: 20:13
 */
@Entity
@Table(name = "t_optreden")
public class Optreden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer duration;
    private Integer soundcheck;
}
