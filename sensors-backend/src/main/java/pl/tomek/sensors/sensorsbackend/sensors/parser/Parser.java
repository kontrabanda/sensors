package pl.tomek.sensors.sensorsbackend.sensors.parser;

import com.fasterxml.jackson.databind.JsonNode;

interface Parser<T> {
    T parse(JsonNode input);
}
