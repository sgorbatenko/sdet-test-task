package co.copper.testtask.service.asset;

import java.math.BigDecimal;
import java.time.LocalDate;

import co.copper.testtask.dto.AssetDto;
import co.copper.testtask.external.CollateralObject;
import co.copper.testtask.external.CollateralType;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class AssetAdapter implements CollateralObject {
    private AssetDto asset;

    @Override
    public BigDecimal getValue() {
        return asset.getValue();
    }

    @Override
    public Short getYear() {
        return asset.getYear();
    }

    @Override
    public LocalDate getDate() {
        // take now date for all assets
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.ASSET;
    }
}
