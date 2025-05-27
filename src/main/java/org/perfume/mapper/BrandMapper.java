package org.perfume.mapper;


import org.perfume.domain.entity.Brand;
import org.perfume.model.dto.response.BrandResponse;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper implements EntityMapper<Brand, BrandResponse> {

    @Override
    public BrandResponse toDto(Brand entity) {
        return null;
    }

    @Override
    public Brand toEntity(BrandResponse dto) {
        return null;
    }
}