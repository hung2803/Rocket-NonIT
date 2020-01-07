package com.vti.template.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.template.entity.Candidate;
import com.vti.template.entity.ExperienceCandidate;
import com.vti.template.entity.FresherCandidate;
import com.vti.template.utils.jdbc.SqlParameter;
import com.vti.template.utils.jdbc.SqlStatement;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Jan 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Jan 6, 2020
 */

public class CandidateRepositoryImpl extends RepositoryImpl<Candidate> implements CandidateRepository {

	/*
	 * @see com.vti.template.repository.Repository#getAll()
	 */

	@Override
	public List<Candidate> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see com.vti.template.repository.Repository#getByID(int)
	 */

	@Override
	public Candidate getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see com.vti.template.repository.Repository#exists(int)
	 */

	@Override
	public boolean exists(String email) {
		// init list parameters
		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, email));

		// execute query
		ResultSet result = getJdbc().selectPreparationStatement(SqlStatement.SQL_EXITS_CANDIDATE_BY_EMAIL, params);

		// check result is null
		if (null == result) {
			getJdbc().disconnect();
			return false;
		}

		// get result
		try {
			while (result.next()) {
				getJdbc().disconnect();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getJdbc().disconnect();
		return false;

	}

	private boolean createCandidate(Candidate entity) {

		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, entity.getFirstName()));
		params.add(new SqlParameter(2, entity.getLastName()));
		params.add(new SqlParameter(3, entity.getEmail()));
		params.add(new SqlParameter(4, entity.getPassword()));
		params.add(new SqlParameter(5, entity.getPhone()));
		params.add(new SqlParameter(6, entity.getIdRole()));

		// execute query
		int result = getJdbc().updatePreparationStatement(SqlStatement.SQL_CREATE_CANDIDATE, params);
		getJdbc().disconnect();

		// return result
		if (result == 1) {
			return true;
		}
		return false;
	}

	/*
	 * @see com.vti.template.repository.CandidateRepository#
	 * createFresherCandidate(com.vti.template.entity.Candidate)
	 */

	@Override
	public boolean createCandidate(FresherCandidate entity) {

		if (!createCandidate((Candidate) entity)) {
			return false;
		}

		// init list parameters
		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, entity.getGraduationRank()));
		params.add(new SqlParameter(2, entity.getEmail()));
		
		// execute query
		int result = getJdbc().updatePreparationStatement(SqlStatement.SQL_CREATE_FRESHER_CANDIDATE, params);
		getJdbc().disconnect();

		// return result
		if (result == 1) {
			return true;
		}

		return false;
	}

	/*
	 * @see
	 * com.vti.template.repository.CandidateRepository#createCandidate(com.vti.
	 * template.entity.Candidate)
	 */

	@Override
	public boolean createCandidate(ExperienceCandidate entity) {

		if (!createCandidate((Candidate) entity)) {
			return false;
		}

		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, entity.getExpInYear()));
		params.add(new SqlParameter(2, entity.getProSkill()));

		// execute query
		int result = getJdbc().updatePreparationStatement(SqlStatement.SQL_CREATE_EXPERIENCE_CANDIDATE, params);
		getJdbc().disconnect();

		// return result
		if (result == 1) {
			return true;
		}
		return false;

	}

	/*
	 * @see com.vti.template.repository.Repository#exists(java.lang.String)
	 */

}
