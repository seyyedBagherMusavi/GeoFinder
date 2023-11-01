package com.example.demo.service.mapper;


import com.example.demo.domain.Place;
import com.example.demo.service.dto.PlaceDTO;
import com.example.demo.service.mapper.gis.GeoJsonPointResolver;
import com.example.demo.service.mapper.gis.PointResolver;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;


@Mapper(uses = {GeoJsonPointResolver.class,
    PointResolver.class},componentModel = "spring")
public interface PlaceMapper extends EntityMapper<PlaceDTO, Place>{

    @DeepClone
    PlaceDTO clone(PlaceDTO source);

}
