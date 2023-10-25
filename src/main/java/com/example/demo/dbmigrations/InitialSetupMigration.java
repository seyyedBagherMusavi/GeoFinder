package com.example.demo.dbmigrations;

import com.example.demo.domain.Place;
import io.mongock.api.annotations.BeforeExecution;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;

@ChangeUnit(id = "place", order = "001",author = "Seyyed")
@RequiredArgsConstructor
public class InitialSetupMigration {

    private final MongoTemplate template;

    @Execution
    public void changeSet() {
        initDepartments();
    }



    @RollbackExecution
    public void rollback() {}

    public void initDepartments() {
        template.indexOps(Place.class)
                .ensureIndex( new GeospatialIndex("location")
                        .typed(GeoSpatialIndexType.GEO_2DSPHERE));

    }
}

