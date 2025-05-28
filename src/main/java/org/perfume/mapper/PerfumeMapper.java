package org.perfume.mapper;

import lombok.RequiredArgsConstructor;
import org.perfume.domain.entity.Perfume;
import org.perfume.model.dto.response.PerfumeResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PerfumeMapper implements EntityMapper<Perfume, PerfumeResponse> {

    private final BrandMapper brandMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public PerfumeResponse toDto(Perfume entity) {
        if (entity == null) {
            return null;
        }

        return new PerfumeResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getDiscountedPrice(),
                entity.getImageUrl(),
                entity.getStockQuantity(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                brandMapper.toDto(entity.getBrand()),
                categoryMapper.toDto(entity.getCategory()),
                entity.isFeatured(),
                entity.isBestseller(),
                entity.getDiscountPercent(),
                entity.getFragranceFamily(),
                entity.getGender(),
                false
        );
    }

    @Override
    public Perfume toEntity(PerfumeResponse dto) {
        if (dto == null) {
            return null;
        }

        Perfume perfume = new Perfume();
        perfume.setId(dto.getId());
        perfume.setName(dto.getName());
        perfume.setDescription(dto.getDescription());
        perfume.setPrice(dto.getPrice());
        perfume.setImageUrl(dto.getImageUrl());
        perfume.setStockQuantity(dto.getStockQuantity());
        perfume.setFeatured(dto.isFeatured());
        perfume.setBestseller(dto.isBestseller());
        perfume.setDiscountPercent(dto.getDiscountPercent());
        perfume.setFragranceFamily(dto.getFragranceFamily());
        perfume.setGender(dto.getGender());
        perfume.setBrand(brandMapper.toEntity(dto.getBrand()));
        perfume.setCategory(categoryMapper.toEntity(dto.getCategory()));
        return perfume;
    }
}