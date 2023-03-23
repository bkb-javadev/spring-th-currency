package com.arsen.spring230323.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "changer")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Changer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String currency;
    private BigDecimal amount;
}
