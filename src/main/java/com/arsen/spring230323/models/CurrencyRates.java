package com.arsen.spring230323.models;

import com.arsen.spring230323.dto.CurrencyModel;
import com.arsen.spring230323.dto.CurrencyRatesModel;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CurrencyRates.TABLE_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyRates {

    public static final String TABLE_NAME = "CURRENCY_RATES";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @GeneratedValue(generator = SEQ_NAME)
    Long id;

    Timestamp createDate;

    String name;

    Timestamp currencyDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "CURRENCY", joinColumns = @JoinColumn(name = "CURRENCY_RATES_ID"))
    List<CurrencyModel> currencyModelList = new ArrayList<>();

    public CurrencyRatesModel toModel() {
        return CurrencyRatesModel.builder()
                .id(id)
                .createDate(createDate.toLocalDateTime())
                .name(name)
                .date(currencyDate.toLocalDateTime().toLocalDate())
                .currencyModelList(currencyModelList)
                .build();
    }
}
