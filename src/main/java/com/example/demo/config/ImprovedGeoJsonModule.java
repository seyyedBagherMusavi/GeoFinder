package com.example.demo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImprovedGeoJsonModule extends GeoJsonModule {
    public ImprovedGeoJsonModule() {
        super();
        addSerializer(GeoJsonPoint.class, new GeoJsonPointSerializer());
        addSerializer(GeoJsonMultiPoint.class, new GeoJsonMultiPointSerializer());
        addSerializer(GeoJsonLineString.class, new GeoJsonLineStringSerializer());
        addSerializer(GeoJsonMultiLineString.class, new GeoJsonMultiLineStringSerializer());
        addSerializer(GeoJsonPolygon.class, new GeoJsonPolygonSerializer());
        addSerializer(GeoJsonMultiPolygon.class, new GeoJsonMultiPolygonSerializer());
    }

    public static class GeoJsonPointSerializer extends JsonSerializer<GeoJsonPoint> {
        @Override
        public void serialize(GeoJsonPoint value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("type", value.getType());
            gen.writeObjectField("coordinates", value.getCoordinates());
            gen.writeEndObject();
        }

    }

    public static class GeoJsonLineStringSerializer extends JsonSerializer<GeoJsonLineString> {

        @Override
        public void serialize(GeoJsonLineString value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("type", value.getType());
            gen.writeArrayFieldStart("coordinates");
            for (Point p : value.getCoordinates()) {
                gen.writeObject(new double[]{p.getX(), p.getY()});
            }
            gen.writeEndArray();
            gen.writeEndObject();
        }
    }

    public static class GeoJsonMultiPointSerializer extends JsonSerializer<GeoJsonMultiPoint> {

        @Override
        public void serialize(GeoJsonMultiPoint value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("type", value.getType());
            gen.writeArrayFieldStart("coordinates");
            for (Point p : value.getCoordinates()) {
                gen.writeObject(new double[]{p.getX(), p.getY()});
            }
            gen.writeEndArray();
            gen.writeEndObject();
        }
    }

    public static class GeoJsonMultiLineStringSerializer extends JsonSerializer<GeoJsonMultiLineString> {

        @Override
        public void serialize(GeoJsonMultiLineString value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("type", value.getType());
            gen.writeArrayFieldStart("coordinates");
            for (GeoJsonLineString lineString : value.getCoordinates()) {
                List<double[]> arrayList = new ArrayList<>();
                for (Point p : lineString.getCoordinates()) {
                    arrayList.add(new double[]{p.getX(), p.getY()});
                }
                double[][] doubles = arrayList.toArray(new double[0][0]);
                gen.writeObject(doubles);
            }
            gen.writeEndArray();
            gen.writeEndObject();
        }
    }

    public static class GeoJsonPolygonSerializer extends JsonSerializer<GeoJsonPolygon> {

        @Override
        public void serialize(GeoJsonPolygon value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("type", value.getType());
            gen.writeArrayFieldStart("coordinates");
            for (GeoJsonLineString ls : value.getCoordinates()) {
                gen.writeStartArray();
                for (Point p : ls.getCoordinates()) {
                    gen.writeObject(new double[]{p.getX(), p.getY()});
                }
                gen.writeEndArray();
            }
            gen.writeEndArray();
            gen.writeEndObject();
        }
    }

    public static class GeoJsonMultiPolygonSerializer extends JsonSerializer<GeoJsonMultiPolygon> {

        @Override
        public void serialize(GeoJsonMultiPolygon value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("type", value.getType());
            gen.writeArrayFieldStart("coordinates");
            for (GeoJsonPolygon polygon : value.getCoordinates()) {

                gen.writeStartArray();

                gen.writeStartArray();
                for (GeoJsonLineString lineString : polygon.getCoordinates()) {

                    for (Point p : lineString.getCoordinates()) {
                        gen.writeObject(new double[]{p.getX(), p.getY()});
                    }

                }

                gen.writeEndArray();
                gen.writeEndArray();
            }
            gen.writeEndArray();
            gen.writeEndObject();
        }
    }
}
