/*
 * File: src\main\java\com\taylor\mybatis\models\Student.java
 * Project: jpa
 * Created Date: Friday, November 3rd 2023, 7:36:34 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Friday, 3rd November 2023 7:37:23 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Friday, November 3rd 2023	Rui Yu		Initial version
 */

package com.taylor.mybatis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private Long id;
    private String name;
    private Boolean sex;
    private Integer age;
    private String description;
    private Integer score;
}