package co.copper.testtask.model;

import javax.persistence.*;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASSET")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String currency;

    @Column(name = "year_of_issue")
    private Short year;

    @Column(name = "assessed_value")
    private BigDecimal value;
}
