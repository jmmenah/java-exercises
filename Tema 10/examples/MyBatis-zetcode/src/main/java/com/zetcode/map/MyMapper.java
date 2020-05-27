/*
 * Introduction to MyBatis
 * http://zetcode.com/db/mybatis/
 */

package com.zetcode.map;

import org.apache.ibatis.annotations.Select;

public interface MyMapper {

    @Select("SELECT COUNT(*) FROM MyBooks")
    public int getNumberOfBooks();
}
