package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PlaceDTO implements Serializable{
    private String id;
    private String name;
    private GeoJsonPointDTO location;

    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    public static class GeoJsonPointDTO implements Serializable {
        private double x,y;
    }
    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    public static class PointDTO implements Serializable {
        private double x,y;
    }
}
