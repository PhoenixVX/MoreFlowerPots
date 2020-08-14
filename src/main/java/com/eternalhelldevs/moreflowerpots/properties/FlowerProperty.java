package com.eternalhelldevs.moreflowerpots.properties;

import com.eternalhelldevs.moreflowerpots.util.Flower;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.state.property.Property;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlowerProperty extends Property<Flower> {
    private final ImmutableSet<Flower> allowedValues;
    private final Map<String, Flower> nameToValue = Maps.newHashMap();

    protected FlowerProperty(String name, Class<Flower> valueClass, Collection<Flower> allowedValues) {
        super(name, valueClass);
        this.allowedValues = ImmutableSet.copyOf(allowedValues);
        for (Flower f : allowedValues) {
            String s = f.getName();
            if (this.nameToValue.containsKey(s)) {
                throw new IllegalArgumentException("Multiple values have the same name '" + s + "'");
            }
            this.nameToValue.put(s, f);
        }
    }

    public Collection<Flower> getValues() {
        return this.allowedValues;
    }

    @Override
    public String name(Flower value) {
        return getName(value);
    }

    public Optional<Flower> parse(String value) {
        return Optional.ofNullable(this.nameToValue.get(value));
    }

    public String getName(Flower value) {
        return value.getName();
    }

    public boolean equals(Object p_equals_1_) {
        if (this == p_equals_1_) {
            return true;
        }
        if (p_equals_1_ instanceof FlowerProperty && super.equals(p_equals_1_)) {
            FlowerProperty flowerProperty = (FlowerProperty) p_equals_1_;
            return this.allowedValues.equals(flowerProperty.allowedValues) && this.nameToValue.equals(flowerProperty.nameToValue);
        }
        return false;
    }

    public int computeHashCode() {
        int i = super.computeHashCode();
        i = 31 * i + this.allowedValues.hashCode();
        i = 31 * i + this.nameToValue.hashCode();
        return i;
    }

    public static FlowerProperty create(String name, Predicate<Flower> filter) {
        return FlowerProperty.create(name, Arrays.stream(Flower.FLOWERS.values().toArray(new Flower[0])).filter(filter).collect(Collectors.toList()));
    }

    public static FlowerProperty create(String name, Flower ... flowers) {
        return FlowerProperty.create(name, Lists.newArrayList(flowers));
    }

    public static FlowerProperty create(String name, Collection<Flower> values) {
        return new FlowerProperty(name, Flower.class, values);
    }
}
