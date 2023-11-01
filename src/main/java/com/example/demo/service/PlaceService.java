package com.example.demo.service;


import com.example.demo.domain.Place;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.service.dto.PlaceDTO;
import com.example.demo.service.mapper.PlaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    private final PlaceMapper placeMapper;

    public List<PlaceDTO> findByLocationNear(Point location, Distance maxDistance){
       return placeRepository.findByLocationNear(location,maxDistance)
               .stream().map(placeMapper::toDto).collect(Collectors.toList());
    }

    public List<PlaceDTO> findInShape(Polygon polygon){
        return placeRepository.findByLocationWithin(polygon)
                .stream().map(placeMapper::toDto).collect(Collectors.toList());
    }

}
