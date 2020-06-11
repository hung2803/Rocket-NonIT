package com.vti.template.utils.jdbc;

/**
 * This class is parameter using for calling procedure.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Jan 13, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Jan 13, 2020
 */
public class SqlProcedureParameter {

	public class In {
		private String nameParameter;
		private Object values;

		/**
		 * Constructor for class In.
		 * 
		 * @Description: .
		 * @author: NNDuy
		 * @create_date: Jan 13, 2020
		 * @version: 1.0
		 * @modifer: NNDuy
		 * @modifer_date: Jan 13, 2020
		 * @param nameParameter
		 * @param values
		 */
		public In(String nameParameter, Object values) {
			this.nameParameter = nameParameter;
			this.values = values;
		}

		/**
		 * @return the nameParameter
		 */
		public String getNameParameter() {
			return nameParameter;
		}

		/**
		 * @return the values
		 */
		public Object getValues() {
			return values;
		}
	}

	public class Out {
		private String nameParameter;
		private int typeSql;

		/**
		 * Constructor for class Out.
		 * 
		 * @Description: .
		 * @author: NNDuy
		 * @create_date: Jan 13, 2020
		 * @version: 1.0
		 * @modifer: NNDuy
		 * @modifer_date: Jan 13, 2020
		 * @param nameParameter
		 * @param typeSql
		 */
		public Out(String nameParameter, int typeSql) {
			this.nameParameter = nameParameter;
			this.typeSql = typeSql;
		}

		/**
		 * @return the nameParameter
		 */
		public String getNameParameter() {
			return nameParameter;
		}

		/**
		 * @return the typeSql
		 */
		public int getTypeSql() {
			return typeSql;
		}
	}
}
