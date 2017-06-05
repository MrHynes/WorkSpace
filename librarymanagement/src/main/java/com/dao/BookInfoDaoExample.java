package com.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.BookInfo;

public interface BookInfoDaoExample extends JpaRepository<BookInfo, Integer>, JpaSpecificationExecutor<BookInfo> {
	// 不写sql语句,根据方法名自动生成sql语句
	// select * from BookInfo where bookname like %?
	public List<BookInfo> findByBooknameStartingWith(String name);

	// 使用hql语句,并且使用占位符
	@Query("select o from BookInfo o where bookname like %?1%")
	public List<BookInfo> findByHql(String name);

	// 使用hql语句,并且使用参数
	@Query("select o from BookInfo o where bookname like %:name%")
	public List<BookInfo> findByHql2(@Param("name") String name2);

	// 使用sql语句 ,nativeQuery设置为true表示开启sql查询
	@Query(nativeQuery = true, value = "select count(1) from t_bookinfo")
	public long getCount();

	// 除了查询(select)以外，其他的操作(增删改)都需要@Modifying
	@Query("update BookInfo o set o.price=:price where o.id=:id")
	@Modifying
	public void update(@Param("price") float price, @Param("id") Integer id);

	// 联表查询
	@Query("select bookInfo from BookInfo bookInfo JOIN bookInfo.booktype booktype where booktype.typename like %:name%")
	public Set<BookInfo> linkTableQuery(@Param("name") String typename);
}
