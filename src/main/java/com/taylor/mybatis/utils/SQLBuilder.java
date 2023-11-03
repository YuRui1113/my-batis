/*
 * File: src\main\java\com\taylor\mybatis\\utils\SQLBuilder.java
 * Project: jpa
 * Created Date: Friday, November 3rd 2023, 8:37:14 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Friday, 3rd November 2023 8:55:58 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Friday, November 3rd 2023	Rui Yu		Initial version
 */

package com.taylor.mybatis.utils;

import org.apache.ibatis.jdbc.SQL;

public class SQLBuilder {

    public String getStudentsByName(String name) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("students");
                if (name != null && name.length() > 0) {
                    WHERE("name like #{name} || '%'");
                }
            }
        }.toString();

        return sql;
    }

    public String getStudentsForPage(int page, int size) {
        int offset = (page - 1) * size;

        String sql = new SQL() {
            {
                SELECT("*");
                FROM("students");
                OFFSET(offset);
                LIMIT(size);
            }
        }.toString();

        return sql;
    }
}