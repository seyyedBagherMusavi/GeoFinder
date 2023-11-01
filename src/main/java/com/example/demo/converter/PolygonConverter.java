package com.example.demo.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class PolygonConverter implements Converter<String, Polygon> {

    private final ObjectMapper objectMapper;

    public PolygonConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Polygon convert(String source) {
        try {
            JsonNode jsonNode = objectMapper.readTree(source);
            JsonNode pointsNode = jsonNode.get("points");

            Iterator<JsonNode> iterator = pointsNode.iterator();
            List<Point> pointList = new ArrayList<>();

            while (iterator.hasNext()) {
                JsonNode pointNode = iterator.next();
                double x = pointNode.get("x").asDouble();
                double y = pointNode.get("y").asDouble();
                pointList.add(new Point(x, y));
            }

            return new Polygon(pointList);
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid polygon format", e);
        }
    }
}