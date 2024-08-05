package org.example.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class DesktopComputer extends Product {
    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }

    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
    }
}
