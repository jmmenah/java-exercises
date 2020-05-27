/*
 * Introduction to MyBatis
 * http://zetcode.com/db/mybatis/
 */

package com.zetcode.version;

import org.apache.ibatis.annotations.Select;

public interface MyMapper {

    @Select("SELECT VERSION()")
    public String getMySQLVersion();
}