package com.slotegrator.ui.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private String username;
    private String externalId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String hall;
    private String balance;
    private String regDate;
    private String lastVisit;
    private String lastVisitIp;
    private boolean isVerified;
    private boolean isOnline;
    private String status;

}
