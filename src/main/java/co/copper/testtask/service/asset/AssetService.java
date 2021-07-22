package co.copper.testtask.service.asset;

import java.util.Optional;

import co.copper.testtask.dto.AssetDto;
import co.copper.testtask.model.Asset;


public interface AssetService {
    boolean approve(AssetDto dto);
    Asset save(Asset asset);
    Optional<Asset> load(Long id);
    Asset fromDto(AssetDto dto);
    AssetDto toDTO(Asset asset);
    Long getId(Asset asset);
}
