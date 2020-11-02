package com.plutus.system.model.entity;

import com.plutus.system.validation.annotation.Email;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column
    @NotEmpty
    private String name;

    @Column
    @NotEmpty
    private String surname;

    @Column
    @Email
    private String email;

    @Column
    @NotNull
    // TODO: 10/6/2020 Solve problem with timezones
    private LocalDateTime createdWhen = LocalDateTime.now();

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "owner")
    private List<Account> accounts = new ArrayList<>();
}
