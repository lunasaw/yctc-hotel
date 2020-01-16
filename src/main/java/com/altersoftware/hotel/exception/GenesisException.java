package com.altersoftware.hotel.exception;

public class GenesisException extends RuntimeException {

    private static final long serialVersionUID = 7780579901230034749L;
    private int code;
    private String message;
    private Object data;

    public GenesisException() {
        super();
    }

    public GenesisException(int code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public GenesisException(int code, String message) {
        this(code, message, null);
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CICException [code=");
        builder.append(code);
        builder.append(", message=");
        builder.append(message);
        builder.append(", data=");
        builder.append(data);
        builder.append("]");
        return builder.toString();
    }
}
