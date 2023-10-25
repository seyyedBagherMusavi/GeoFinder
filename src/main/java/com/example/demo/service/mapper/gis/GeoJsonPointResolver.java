package com.example.demo.service.mapper.gis;

import com.example.demo.service.dto.PlaceDTO;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

@Component
public  class GeoJsonPointResolver {
    @ObjectFactory
    public GeoJsonPoint resolve(PlaceDTO.GeoJsonPointDTO dto, @TargetType Class<GeoJsonPoint> type) {
        return dto != null ? new GeoJsonPoint(dto.getX(),dto.getY()):null;
    }
}
