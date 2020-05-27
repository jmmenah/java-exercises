/*
 * Introduction to MyBatis
 * http://zetcode.com/db/mybatis/
 */

package com.zetcode.mybatisdynamicsql;

import com.zetcode.mybatisdynamicsql.bean.Book;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisDynamicSQL {

    private static SqlSessionFactory factory = null;

    public static void main(String[] args) throws IOException {

        String resource = "mybatis3-config.xml";
        Reader reader = null;
        SqlSession session = null;

        reader = Resources.getResourceAsReader(resource);

        factory = new SqlSessionFactoryBuilder().build(reader);

        try {
            session = factory.openSession();
            Book book = session.selectOne("getBook", 1);
            System.out.println(book);

            List<Book> books = session.selectList("getBook");

            for (Book b : books) {
                System.out.println(b);
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}
