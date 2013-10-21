package model;

import javax.persistence.*;

/**
 * User: Adri
 * Date: 21/10/13
 * Time: 9:37
 */
@Entity
@Table(name = "Festival")
public class Festival {

    @Id
    @GeneratedValue(GeneratedValue = GenerationType.IDENTITY)
    private Integer id;
}
