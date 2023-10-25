package com.example.demo.service.mapper.gis;

import com.example.demo.service.dto.PlaceDTO;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

@Component
public class PointResolver {
    @ObjectFactory
    public Point resolve(PlaceDTO.PointDTO dto, @TargetType Class<Point> type) {
        return dto != null ? new Point(dto.getX(),dto.getY()):null;
    }
}
