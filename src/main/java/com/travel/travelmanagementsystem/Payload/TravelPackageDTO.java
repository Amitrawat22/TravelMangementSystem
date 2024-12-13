package com.travel.travelmanagementsystem.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelPackageDTO {
    private Long travelPackageId;
    private String travelPackageName;
    private String startDate;
    private String endDate;
    private String destination;
}
