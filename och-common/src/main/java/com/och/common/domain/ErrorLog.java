package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;


@Data
@Accessors(chain = true)
public class ErrorLog {
    private List<ErrorPeriod> errorPeriods;

    /**
     * <p>addErrorPeriod.</p>
     *
     * @param errorPeriod a {@link ErrorPeriod} object.
     * @return a {@link ErrorLog} object.
     */
    public ErrorLog addErrorPeriod(ErrorPeriod errorPeriod) {
        if (errorPeriods == null) {
            errorPeriods = new ArrayList<>(4);
        }
        errorPeriods.add(errorPeriod);
        return this;
    }
}
