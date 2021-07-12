/**
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.example;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.mapper.StockMapper;
import org.mybatis.example.model.Stock;

/**
 * @author zhengyunwei
 * @title: MybatisTest
 * @projectName mybatis
 * @description: TODO
 * @date 2021/6/24 7:39 下午
 */
public class MybatisTest {

  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    StockMapper mapper = sqlSessionFactory.openSession().getMapper(StockMapper.class);
    Stock stock = new Stock();
    stock.setProductId(3);
    stock.setAmount(10);
    stock.setPrice(new BigDecimal(10));
    System.out.println(mapper.insert(stock));
    sqlSessionFactory.openSession().commit();
//    System.out.println( mapper.selectById(1));
  }

}
