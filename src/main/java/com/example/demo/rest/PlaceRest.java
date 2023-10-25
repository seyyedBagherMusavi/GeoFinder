package com.example.demo.rest;


import com.example.demo.domain.Place;
import com.example.demo.service.PlaceService;
import com.example.demo.service.dto.BaseDTO;
import com.example.demo.service.dto.NearByDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/relations")
@RequiredArgsConstructor
@Profile("api-docs")
public class PlaceRest {
    private final PlaceService placeService;

    @ResponseBody
    @GetMapping("find")
    public ResponseEntity<List<Place>> findNearBy(NearByDTO nearByDTO){
        return new ResponseEntity<>(
                placeService.findByLocationNear(new Point(nearByDTO.getX(),nearByDTO.getY()),
                        new Distance(nearByDTO.getDistance(), Metrics.KILOMETERS))
                , HttpStatus.OK);
    }

}
