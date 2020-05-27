/*
 * Introduction to MyBatis
 * http://zetcode.com/db/mybatis/
 */

package com.zetcode.map;

import com.zetcode.books.bean.Book;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MyMapper {

    @Select("SELECT * FROM MyBooks WHERE Id = #{id}")
    public Book getBookById(Long id);

    @Select("SELECT * FROM MyBooks WHERE Author = #{author}")
    public List<Book> getBooksByAuthor(String author);

    @Insert("INSERT INTO MyBooks(Author, Title, Published, Remark) "
            + "VALUES(#{author}, #{title}, #{published}, #{remark})")
    public void insertBook(String author, String title, int published,
                           String remark);
}