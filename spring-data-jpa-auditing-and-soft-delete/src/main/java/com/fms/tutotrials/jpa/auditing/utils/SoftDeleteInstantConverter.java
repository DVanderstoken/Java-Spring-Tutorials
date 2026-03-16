package com.fms.tutotrials.jpa.auditing.utils;

import java.time.LocalDateTime;
import java.time.Month;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SoftDeleteInstantConverter implements AttributeConverter<Boolean, LocalDateTime> {

    /**
     * Date de suppression de l'enregistrement pour la gestion du @SoftDelete.
     * ATTENTION : Ne doit pas être modifiée sans envisager un redressement des données !
     */
    private static final LocalDateTime A_VERY_DISTANT_FUTURE_DATE = LocalDateTime.of(2099, Month.DECEMBER, 31, 23, 59, 59);

    @Override
    public LocalDateTime convertToDatabaseColumn(Boolean b) {
        return b == Boolean.TRUE ? LocalDateTime.now() : A_VERY_DISTANT_FUTURE_DATE;
    }

    @Override
    public Boolean convertToEntityAttribute(LocalDateTime i) {
        return i.isAfter(LocalDateTime.now()) ? Boolean.FALSE : Boolean.TRUE;
    }
}
