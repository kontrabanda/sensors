package pl.tomek.sensors.sensorsbackend.sensors.parser;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class ParserUtil {
    static String parseTextOrNull(JsonNode input, String fieldName) {
        return parseText(input, fieldName)
                .orElse(null);
    }

    static String parseText(JsonNode input, String fieldName, String defaultValue) {
        return parseText(input, fieldName)
                .orElse(defaultValue);
    }

    static Optional<String> parseText(JsonNode input, String fieldName) {
        return Optional.of(input)
                .map(el -> el.get(fieldName))
                .map(JsonNode::asText);
    }

    static Integer parseIntegerOrNull(JsonNode input, String fieldName) {
        return parseInteger(input, fieldName)
                .orElse(null);
    }

    static Optional<Integer> parseInteger(JsonNode input, String fieldName) {
        return Optional.of(input)
                .map(el -> el.get(fieldName))
                .filter(JsonNode::isInt)
                .map(JsonNode::asInt);
    }

    static Float parseFloatOrNull(JsonNode input, String fieldName) {
        return parseFloat(input, fieldName)
                .orElse(null);
    }

    static Optional<Float> parseFloat(JsonNode input, String fieldName) {
        return Optional.of(input)
                .map(el -> el.get(fieldName))
                .map(JsonNode::asText)
                .filter(NumberUtils::isParsable)
                .map(Float::parseFloat);
    }

    static <T> T parseObjectOrNull(JsonNode input, String fieldName, Parser<T> parser) {
        return parseObject(input, fieldName, parser)
                .orElse(null);
    }

    static <T> Optional<T> parseObject(JsonNode input, String fieldName, Parser<T> parser) {
        return Optional.of(input)
                .map(node -> node.get(fieldName))
                .map(parser::parse);
    }

    static <T> List<T> parseList(JsonNode input, String fieldName, Parser<T> parser) {
        return Optional.of(input)
                .map(node -> node.get(fieldName))
                .filter(JsonNode::isArray)
                .map(JsonNode::iterator)
                .map(IteratorUtils::toList)
                .map(nodes -> parseElements(nodes, parser))
                .orElse(new ArrayList<>());

    }

    private static <T> List<T> parseElements(List<JsonNode> nodes, Parser<T> parser) {
        return nodes.stream()
                .map(parser::parse)
                .collect(Collectors.toList());
    }

    static <T extends Enum<T>> T getEnum(JsonNode jsonNode, String name, Class<T> enumClass, T defaultValue) {
        return parseText(jsonNode, name)
                .filter(StringUtils::isNotEmpty)
                .filter(enumTxt -> existInPossibleValues(enumTxt, enumClass))
                .map(enumTxt -> Enum.valueOf(enumClass, enumTxt))
                .orElse(defaultValue);
    }

    private static <T extends Enum<T>> boolean existInPossibleValues(String enumTxt, Class<T> enumClass) {
        T[] possibleValues = enumClass.getEnumConstants();
        return Arrays.stream(possibleValues)
                .map(Enum::toString)
                .anyMatch(enumTxt::equals);
    }
}
