/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: db-4
 * Package: com.rostyk.domain
 * Class: TripDao
 */

package com.rostyk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trip {
    private Integer id;
    private String startPoint;
    private String endPoint;
    private Integer driverId;
    private String userName;
}
