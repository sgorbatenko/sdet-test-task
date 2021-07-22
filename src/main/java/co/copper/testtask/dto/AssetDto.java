package co.copper.testtask.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("asset")
public class AssetDto implements Collateral {
    private Long id;
    private String name;
    private String currency;
    private Short year;
    private BigDecimal value;
}
