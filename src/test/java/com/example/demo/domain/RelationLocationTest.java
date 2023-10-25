package com.example.demo.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RelationLocationTest {
    @Test
    void equalsVerifier()  {

        Place relationLocation = new Place().setId("aaa");
        Place relationLocation1 = new Place().setId("aaa");
        assertThat(relationLocation).isEqualTo(relationLocation1);
        relationLocation1.setId("bbb");
        assertThat(relationLocation).isNotEqualTo(relationLocation1);
        relationLocation1.setId(null);
        assertThat(relationLocation).isNotEqualTo(relationLocation1);
    }
}