package org.perfume.mapper;

import lombok.RequiredArgsConstructor;
import org.perfume.domain.entity.Favorite;
import org.perfume.model.dto.response.PerfumeResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FavoriteMapper implements EntityMapper<Favorite, PerfumeResponse> {

    private final PerfumeMapper perfumeMapper;

    @Override
    public PerfumeResponse toDto(Favorite entity) {
        if (entity == null) {
            return null;
        }

        PerfumeResponse response = perfumeMapper.toDto(entity.getPerfume());
        response.setFavorite(true);
        return response;
    }

    @Override
    public Favorite toEntity(PerfumeResponse dto) {
        if (dto == null) {
            return null;
        }

        Favorite favorite = new Favorite();
        return favorite;
    }
}