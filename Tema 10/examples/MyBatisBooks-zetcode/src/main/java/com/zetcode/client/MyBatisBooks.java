/*
 * Introduction to MyBatis
 * http://zetcode.com/db/mybatis/
 */

package com.zetcode.client;

import com.zetcode.map.MyMapper;
import com.zetcode.books.bean.Book;
//import com.zetcode.util.MyBatisUtils;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisBooks {

    private static SqlSessionFactory factory = null;

    public static void main(String[] args) throws IOException {

        SqlSession session = null;

        //factory = MyBatisUtils.getSqlSessionFactory();
        //factory.getConfiguration().addMapper(MyMapper.class);


        String resource = "mybatis-config.xml";
        Reader reader = null;

        reader = Resources.getResourceAsReader(resource);

        factory = new SqlSessionFactoryBuilder().build(reader);
        factory.getConfiguration().addMapper(MyMapper.class);

        reader.close();





        try {
            session = factory.openSession();
            Book book = session.selectOne("getBookById", 4L);
            System.out.println(book);

            List<Book> books = session.selectList("getBooksByAuthor", "Leo Tolstoy");

            for (Book b : books) {
                System.out.println(b);
            }

            Book newBook = new Book("Miguel de Cervantes", "Don Quixote",
                    1605, "First modern novel");

            session.update("insertBook", newBook);
            session.commit();

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}