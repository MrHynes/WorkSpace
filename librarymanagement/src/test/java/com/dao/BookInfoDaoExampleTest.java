package com.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.BookInfo;
import com.entity.BookType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class BookInfoDaoExampleTest {
	@Autowired
	private BookInfoDaoExample bookInfoDaoExample;

	/**
	 * 测试findByBooknameStartingWith() 注意必须使用@Transactional注解,否则会报could not
	 * initialize proxy - no Session的异常
	 */
	@Test
	@Transactional
	public void findByBooknameStartingWith() {
		List<BookInfo> bookInfoList = bookInfoDaoExample.findByBooknameStartingWith("Java");
		for (BookInfo bookInfo : bookInfoList) {
			System.out.println(bookInfo);
		}
	}

	/**
	 * 测试
	 */
	@Test
	@Transactional
	public void findByHql() {
		List<BookInfo> bookInfoList = bookInfoDaoExample.findByHql("Java");
		for (BookInfo bookInfo : bookInfoList) {
			System.out.println(bookInfo);
		}
	}

	/**
	 * 测试
	 */
	@Test
	@Transactional
	public void findByHql2() {
		List<BookInfo> bookInfoList = bookInfoDaoExample.findByHql2("Java");
		for (BookInfo bookInfo : bookInfoList) {
			System.out.println(bookInfo);
		}
	}

	/**
	 * 测试 getCount
	 */
	@Test
	public void getCount() {
		System.out.println("t_bookinfo共有" + bookInfoDaoExample.getCount() + "条记录");
	}

	/**
	 * 测试update 测试虽然通过,但数据库不会更新, 写在service层就可以
	 */
	@Test
	@Transactional
	public void update() {
		bookInfoDaoExample.update(79.10f, 1);

	}

	/**
	 * 联表查询
	 */
	@Test
	@Transactional
	public void linkTableQuery() {
		Set<BookInfo> bookInfoSet = bookInfoDaoExample.linkTableQuery("网络编程");
		Iterator<BookInfo> it = bookInfoSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/**
	 * 测试分页查询
	 * 
	 */
	@Test
	@Transactional
	public void findPaging() {
		// 按照id降序排序
		Sort.Order order = new Sort.Order(Direction.DESC, "id");
		Sort sort = new Sort(order);
		// new PageRequest(page,size,sort)
		// 1.page为页数,从0开始
		// 2.size为每页的记录数
		// 3.sort为排序
		// 如果不需要排序则直接 new PageRequest(page,size)
		Pageable pageable = new PageRequest(0, 2, sort);
		Page<BookInfo> page = bookInfoDaoExample.findAll(pageable);
		System.out.println("查询的总页数" + page.getTotalPages());
		System.out.println("查询的总记录数" + page.getTotalElements());
		System.out.println("查询的当前第几页" + (page.getNumber() + 1));
		System.out.println("查询的当前页面的记录数" + page.getNumberOfElements());
		System.out.println("当前页面的集合" + page.getContent());
	}

	/**
	 * 分页查询 1.混合条件查询
	 */
	@Test
	@Transactional
	public void findPaging2() {
		Sort.Order order = new Sort.Order(Direction.DESC, "id");
		Sort sort = new Sort(order);
		Pageable pageable = new PageRequest(0, 2, sort);
		Specification<BookInfo> spec = new Specification<BookInfo>() {

			public Predicate toPredicate(Root<BookInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 混合条件查询
				// 导入javax.persistence.criteria.Path;
				Path<String> p1 = root.get("bookname");
				Path<String> p2 = root.get("author");
				// 这里面的like模糊查询需要人为的加上%%
				query.where(cb.like(p1, "%Java1%"), cb.equal(p2, "王国辉"));
				return null;
			}
		};
		Page<BookInfo> page = bookInfoDaoExample.findAll(spec, pageable);
		System.out.println("查询的总页数" + page.getTotalPages());
		System.out.println("查询的总记录数" + page.getTotalElements());
		System.out.println("查询的当前第几页" + (page.getNumber() + 1));
		System.out.println("查询的当前页面的记录数" + page.getNumberOfElements());
		System.out.println("当前页面的集合" + page.getContent());
	}

	/**
	 * 分页查询 2.多表查询
	 */
	@Test
	@Transactional
	public void findPaging3() {
		Sort.Order order = new Sort.Order(Direction.DESC, "id");
		Sort sort = new Sort(order);
		Pageable pageable = new PageRequest(0, 2, sort);
		Specification<BookInfo> spec = new Specification<BookInfo>() {

			public Predicate toPredicate(Root<BookInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 混合条件查询
				// 导入javax.persistence.criteria.Path;
				Path<String> p1 = root.get("bookname");
				Path<String> p2 = root.get("author");
				// 这里面的like模糊查询需要人为的加上%%
				query.where(cb.like(p1, "%Java%"), cb.equal(p2, "王国辉"));
				// 多表查询
				Join<BookInfo, BookType> join = root.join("booktype", JoinType.INNER);
				Path<String> p3 = join.get("typename");
				return cb.like(p3, "%网络编程%");

			}
		};
		Page<BookInfo> page = bookInfoDaoExample.findAll(spec, pageable);
		System.out.println("查询的总页数" + page.getTotalPages());
		System.out.println("查询的总记录数" + page.getTotalElements());
		System.out.println("查询的当前第几页" + (page.getNumber() + 1));
		System.out.println("查询的当前页面的记录数" + page.getNumberOfElements());
		System.out.println("当前页面的集合" + page.getContent());
	}
}
