package co.copper.testtask.service;

import java.util.Optional;

import co.copper.testtask.dto.AssetDto;
import co.copper.testtask.dto.Collateral;
import co.copper.testtask.service.asset.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// TODO: reimplement this
@Service
public class CollateralService {
    @Autowired
    private AssetService assetService;

    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        if (!(object instanceof AssetDto)) {
            throw new IllegalArgumentException();
        }

        AssetDto asset = (AssetDto) object;
        boolean approved = assetService.approve(asset);
        if (!approved) {
            return null;
        }

        return Optional.of(asset)
                .map(assetService::fromDto)
                .map(assetService::save)
                .map(assetService::getId)
                .orElse(null);
    }

    public Collateral getInfo(String id) {
        return Optional.of(Long.parseLong(id))
                .flatMap(assetService::load)
                .map(assetService::toDTO)
                .orElse(null);
    }
}
