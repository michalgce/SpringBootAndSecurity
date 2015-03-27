package pl.majkel.dtos;

import pl.majkel.dtos.enums.Status;

public class EmptyResponseDto {

    protected Status status;
    protected String extras;

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(final String extras) {
        this.extras = extras;
    }
}
