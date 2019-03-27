package pl.tomek.sensors.sensorsbackend.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Optional;

public class ParserUtil {
    public static String parseTextOrNull(JsonNode input, String fieldName) {
        return parseText(input, fieldName)
                .orElse(null);
    }

    public static Optional<String> parseText(JsonNode input, String fieldName) {
        return Optional.of(input)
                .map(el -> el.get(fieldName))
                .map(JsonNode::asText);
    }

    public static Integer parseIntegerOrNull(JsonNode input, String fieldName) {
        return parseInteger(input, fieldName)
                .orElse(null);
    }

    public static Optional<Integer> parseInteger(JsonNode input, String fieldName) {
        return Optional.of(input)
                .map(el -> el.get(fieldName))
                .filter(JsonNode::isInt)
                .map(JsonNode::asInt);
    }

    public static Float parseFloatOrNull(JsonNode input, String fieldName) {
        return parseFloat(input, fieldName)
                .orElse(null);
    }

    public static Optional<Float> parseFloat(JsonNode input, String fieldName) {
        return Optional.of(input)
                .map(el -> el.get(fieldName))
                .map(JsonNode::asText)
                .filter(NumberUtils::isParsable)
                .map(Float::parseFloat);
    }
}
