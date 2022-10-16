/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: lab4-db
 * Package: com.rostyslav.domain
 * Class: User
 */

package com.rostyk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String name;
    private Integer rating;
}
