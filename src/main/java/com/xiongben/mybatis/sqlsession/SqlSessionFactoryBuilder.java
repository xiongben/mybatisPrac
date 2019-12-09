package com.xiongben.mybatis.sqlsession;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config){
      return new SqlSessionFactory() {
          public SqlSession openSession() {
              return null;
          }
      };
    }
}
