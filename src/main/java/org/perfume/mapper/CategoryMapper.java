package org.perfume.mapper;

import org.perfume.domain.entity.Category;
import org.perfume.model.dto.response.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements EntityMapper<Category, CategoryResponse> {

    @Override
    public CategoryResponse toDto(Category entity) {
        if (entity == null) {
            return null;
        }

        return new CategoryResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }

    @Override
    public Brand toEntity(CategoryResponse dto) {
        if (dto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }
}