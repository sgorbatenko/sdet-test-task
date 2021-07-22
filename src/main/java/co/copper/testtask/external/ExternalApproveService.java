package co.copper.testtask.external;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ExternalApproveService {
    private static final LocalDate MIN_ASSESS_DATE = LocalDate.of(2017, Month.OCTOBER, 1);
    private static final int MIN_ASSET_YEAR = 2000;
    private static final BigDecimal MIN_ASSET_VALUE = BigDecimal.valueOf(1000000);


    public int approve(CollateralObject object) {
        if (object.getDate() == null ||object.getYear() == null || object.getValue() == null || object.getType() == null) {
            return -1;
        }

        int code;
        switch (object.getType()) {
            case ASSET: code = approveAsset(object); break;
            default: code = -100;
        }

        return code;
    }

    private int approveAsset(CollateralObject object) {
        if (object.getYear() < MIN_ASSET_YEAR) {
            return -10;
        }
        if (object.getDate().isBefore(MIN_ASSESS_DATE)) {
            return -11;
        }
        if (object.getValue().compareTo(MIN_ASSET_VALUE) < 0) {
            return -12;
        }

        return 0;
    }
}
