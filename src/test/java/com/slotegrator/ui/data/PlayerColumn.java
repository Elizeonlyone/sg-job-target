package com.slotegrator.ui.data;

public enum PlayerColumn {

    USERNAME(1),
    EXTERNAL_ID(2),
    NAME(3),
    LAST_NAME(4),
    EMAIL(5),
    PHONE(6),
    HALL(7),
    REG_DATE(9),
    LAST_VISIT(10),
    VERIFIED_PLAYER(12),
    STATUS(14);

    PlayerColumn(int index) {
        this.index = index;
    }

    private int index;

    public int getIndex() {
        return index;
    }
}
