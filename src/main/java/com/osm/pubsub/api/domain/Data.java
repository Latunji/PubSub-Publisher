package com.osm.pubsub.api.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Data {

    private String topic;
    private Object data;
}
