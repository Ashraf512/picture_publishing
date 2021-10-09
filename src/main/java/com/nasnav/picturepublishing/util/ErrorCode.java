package com.nasnav.picturepublishing.util;

import gov.saip.utility.module.KeyError;
import lombok.Getter;

@Getter
public enum ErrorCode implements KeyError {
    FILE_NOT_FOUND("file.not.found"),
    TRADEMARK_REQUEST_NOT_FOUND("trademark.request.not.found"),
    FILE_BAD_FORMAT("file.bad.format"),
    KEY_NOT_LOCALIZED("key.without.message");

    private String key;

    ErrorCode(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
