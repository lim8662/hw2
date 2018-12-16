package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository // DAO bean으로 등록
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource); // dataSource를 주입해 JdbcTemplate 객체를 생성(DAO가 사용)
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from student";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class); // 2번째 인자는 return type
	}

	public List<Offer> getOffers() {
		String sqlStatement = "select year, semester, sum(credit) from student group by year,semester";
		// 복수의 레코드를 반환하므로 query사용. 레코드 수만큼 offer 객체를 만들어 List를 반환
		return jdbcTemplate.query(sqlStatement,
				// 2번째 인자
				new RowMapper<Offer>() { // 1.객체 생성, 2.클래스 선언, 일회용 클래스인 익명 클래스
					// ResultSet의 레코드를 offer객체에 저장
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

						Offer offer = new Offer();
						offer.setYear(rs.getInt("year"));
						offer.setSemester(rs.getInt("semester"));
						offer.setCredit(rs.getInt("sum(credit)"));

						return offer;
					}

				} // 익명클래스 선언 끝
		); // return문 끝
	}

	public List<Offer> getSuboffers(int year, int semester) {
		String sqlStatement = "select * from student where year=? and semester=?";

		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester },

				new RowMapper<Offer>() {

					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

						Offer subject = new Offer();
						subject.setId(rs.getInt("id"));
						subject.setYear((rs.getInt("year")));
						subject.setSemester(rs.getInt("semester"));
						subject.setCourse_id(rs.getString("course_id"));
						subject.setTitle(rs.getString("title"));
						subject.setDivision(rs.getString("division"));
						subject.setCredit(rs.getInt("Credit"));
						return subject;
					} 
				} // 익명클래스 선언 끝
		);// return문 끝
	}

	// 1개의 레코드를 insert
	public boolean insert(Offer offer) {

		int year = offer.getYear();
		int semester = offer.getSemester();
		int credit = offer.getCredit();
		String course_id = offer.getCourse_id();
		String title = offer.getTitle();
		String division = offer.getDivision();

		String sqlStatement = "insert into student (year, semester, course_id, title, division, credit) values (?, ?, ?, ?, ?, ?)";
		// 몇개가 update되었는지 그 갯수가 integer로 반환
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, course_id, title, division, credit }) == 1);
	}

}
