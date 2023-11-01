package com.example.demo.rest;


import com.example.demo.service.PlaceService;
import com.example.demo.service.dto.NearByDTO;
import com.example.demo.service.dto.PlaceDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling place-related operations.
 */
@RestController
@RequestMapping("/relations")
@RequiredArgsConstructor
public class PlaceRest {
    private final PlaceService placeService;
    /**
     * Retrieves places near a specified location within a certain distance.
     *
     * @param nearByDTO the DTO containing the location coordinates and distance
     * @return a ResponseEntity containing the list of nearby places
     */
    @ResponseBody
    @GetMapping("nearby-search")
    public ResponseEntity<List<PlaceDTO>> findNearBy(@Validated NearByDTO nearByDTO){
        return  ResponseEntity.ok(
                placeService.findByLocationNear(new Point(nearByDTO.getX(),nearByDTO.getY()),
                        new Distance(nearByDTO.getDistance(), Metrics.KILOMETERS))
                );
    }
    /**
     * Retrieves places within a specified shape defined by a polygon.
     *
     * @param polygon the polygon defining the shape
     * @return a ResponseEntity containing the list of places within the shape
     */
    @ResponseBody
    @GetMapping("search-in-shape")
    public ResponseEntity<List<PlaceDTO>> searchInShape(
            @Parameter(description = "Polygon shape", content = @Content(mediaType = "text/plain",
                    schema = @Schema(type = "string", format = "polygon")))
            @RequestHeader("Polygon") @Validated Polygon polygon){
        return  ResponseEntity.ok(
                placeService.findInShape(polygon));
    }

}
