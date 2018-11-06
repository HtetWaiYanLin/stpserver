package com.team24.stp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team24.stp.database.DBField;
import com.team24.stp.database.DBMgr;
import com.team24.stp.database.DBRecord;
import com.team24.stp.framework.Result;
import com.team24.stp.shared.AddressRefData;
import com.team24.stp.shared.AddressRefDataSet;
import com.team24.stp.shared.Ref1;

public class AddressDao {

	public static DBRecord define() {
		DBRecord ret = new DBRecord();
		ret.setTableName("addressref");
		ret.setFields(new ArrayList<DBField>());
		ret.getFields().add(new DBField("code", (byte) 5));
		ret.getFields().add(new DBField("despMyan", (byte) 5));
		ret.getFields().add(new DBField("despEng", (byte) 5));
		ret.getFields().add(new DBField("isLocal", (byte) 2));
		ret.getFields().add(new DBField("minLat", (byte) 5));
		ret.getFields().add(new DBField("minLon", (byte) 5));
		ret.getFields().add(new DBField("maxLat", (byte) 5));
		ret.getFields().add(new DBField("maxLon", (byte) 5));
		return ret;
	}

	public static DBRecord define(String tabName) {
		DBRecord ret = new DBRecord();
		ret.setTableName(tabName);
		ret.setFields(new ArrayList<DBField>());
		ret.getFields().add(new DBField("code", (byte) 5));
		ret.getFields().add(new DBField("despMyan", (byte) 5));
		ret.getFields().add(new DBField("despEng", (byte) 5));
		ret.getFields().add(new DBField("isLocal", (byte) 2));
		ret.getFields().add(new DBField("minLat", (byte) 5));
		ret.getFields().add(new DBField("minLon", (byte) 5));
		ret.getFields().add(new DBField("maxLat", (byte) 5));
		ret.getFields().add(new DBField("maxLon", (byte) 5));

		return ret;
	}

	public static AddressRefData getDBRecord(DBRecord adbr) {
		AddressRefData ret = new AddressRefData();
		ret.setCode(adbr.getString("code"));
		ret.setDespMyan(adbr.getString("despMyan"));
		ret.setDespEng(adbr.getString("despEng"));
		ret.setIsLocal(adbr.getLong("isLocal"));
		ret.setMinLat(adbr.getString("minLat"));
		ret.setMinLon(adbr.getString("minLon"));
		ret.setMaxLat(adbr.getString("maxLat"));
		ret.setMaxLon(adbr.getString("maxLon"));
		return ret;
	}

	public static DBRecord setDBRecord(AddressRefData data) {
		DBRecord ret = define();
		ret.setValue("code", data.getCode());
		ret.setValue("despMyan", data.getDespMyan());
		ret.setValue("despEng", data.getDespEng());
		ret.setValue("isLocal", data.getIsLocal());
		ret.setValue("minLat", data.getMinLat());
		ret.setValue("minLon", data.getMinLon());
		ret.setValue("maxLat", data.getMaxLon());
		ret.setValue("maxLon", data.getMaxLon());
		return ret;
	}

	public static Ref1[] getDivision(Connection aConnection) throws SQLException {
		Ref1[] arr = null;
		Ref1 ref = new Ref1();
		int count = 0;

		String l_Query = "select COUNT(*) c from dbo.AddressRef where SUBSTRING(code,3,6) = '000000' and code<>'00000000'";
		PreparedStatement pstmt = aConnection.prepareStatement(l_Query);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("c");
			pstmt.close();
		}
		arr = new Ref1[count];

		l_Query = "select Code ,despMyan from dbo.AddressRef where SUBSTRING(code,3,6) = '000000' and code<>'00000000' order by code ";

		pstmt = aConnection.prepareStatement(l_Query);
		rs = pstmt.executeQuery();

		int index = 0;
		while (rs.next()) {
			ref = new Ref1();
			ref.setValue(rs.getString("Code"));
			ref.setCaption(rs.getString("despMyan"));
			arr[index] = ref;
			index++;
		}
		return arr;
	}

	public static Ref1[] getDistinctbyDiv(String division, Connection l_Conn) throws SQLException {
		Ref1[] arr = null;
		Ref1 ref = new Ref1();
		int count = 0;
		String l_Query = "select COUNT(*) c from dbo.AddressRef "
				+ " where SUBSTRING(code,1,2) = ? and SUBSTRING(code,3,3) <> '000' and "
				+ " SUBSTRING(code,6,3) = '000'";
		PreparedStatement pstmt = l_Conn.prepareStatement(l_Query);
		pstmt.setString(1, division.substring(0, 2));
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("c");
			pstmt.close();
		}
		arr = new Ref1[count];
		l_Query = "select Code ,despMyan from dbo.AddressRef "
				+ " where SUBSTRING(code,1,2) = ? and SUBSTRING(code,3,3) <> '000' and "
				+ " SUBSTRING(code,6,3) = '000' order by code ";

		pstmt = l_Conn.prepareStatement(l_Query);
		pstmt.setString(1, division.substring(0, 2));
		rs = pstmt.executeQuery();

		int index = 0;
		while (rs.next()) {
			ref = new Ref1();
			ref.setValue(rs.getString("Code"));
			ref.setCaption(rs.getString("despMyan"));
			arr[index] = ref;
			index++;
		}
		return arr;
	}
	
	public static Ref1[] getAllDistrict(Connection l_Conn) throws SQLException {
		Ref1[] arr = null;
		Ref1 ref = new Ref1();
		int count = 0;
		String l_Query = "select COUNT(*) c from dbo.AddressRef "
				+ " where SUBSTRING(code,3,3) <> '000' and "
				+ " SUBSTRING(code,6,3) = '000'";
		PreparedStatement pstmt = l_Conn.prepareStatement(l_Query);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("c");
			pstmt.close();
		}
		arr = new Ref1[count];
		l_Query = "select Code ,despMyan from dbo.AddressRef "
				+ " where  SUBSTRING(code,3,3) <> '000' and "
				+ " SUBSTRING(code,6,3) = '000' order by code ";

		pstmt = l_Conn.prepareStatement(l_Query);
		rs = pstmt.executeQuery();

		int index = 0;
		while (rs.next()) {
			ref = new Ref1();
			ref.setValue(rs.getString("Code"));
			ref.setCaption(rs.getString("despMyan"));
			arr[index] = ref;
			index++;
		}
		return arr;
	}

	public static Ref1[] getTownshipByDistinct(String distinct, Connection l_Conn) throws SQLException {
		Ref1[] arr = null;
		Ref1 ref = new Ref1();
		int count = 0;
		/*int div = 0;
		if (distinct == null || distinct.trim().equals("")) {
			div = 0;
		} else {
			div = Integer.parseInt(distinct);
		}*/
		String l_Query = "select COUNT(*) c from dbo.AddressRef " + " where SUBSTRING(code,1,5) = ? and  "
				+ " SUBSTRING(code,6,3) <> '000' ";
		PreparedStatement pstmt = l_Conn.prepareStatement(l_Query);
		pstmt.setString(1, distinct.substring(0, 5));
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			count = rs.getInt("c");
			pstmt.close();
		}

		arr = new Ref1[count];

		l_Query = "select Code ,despMyan from dbo.AddressRef " + " where SUBSTRING(code,1,5) = ? and  "
				+ " SUBSTRING(code,6,3) <> '000' order by code ";
		pstmt = l_Conn.prepareStatement(l_Query);
		pstmt.setString(1, distinct.substring(0, 5));
		rs = pstmt.executeQuery();

		int index = 0;
		while (rs.next()) {
			ref = new Ref1();
			ref.setValue(rs.getString("Code"));
			ref.setCaption(rs.getString("despMyan"));
			arr[index] = ref;
			index++;
		}
		return arr;
	}

	public static Ref1[] getAllTownship(Connection l_Conn) throws SQLException {
		Ref1[] arr = null;
		Ref1 ref = new Ref1();
		int count = 0;
		String l_Query = "select COUNT(*) c from dbo.AddressRef where "
				+ " SUBSTRING(code,6,3) <> '000' ";
		PreparedStatement pstmt = l_Conn.prepareStatement(l_Query);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			count = rs.getInt("c");
			pstmt.close();
		}

		arr = new Ref1[count];

		l_Query = "select Code ,despMyan from dbo.AddressRef where "
				+ " SUBSTRING(code,6,3) <> '000' order by code ";
		pstmt = l_Conn.prepareStatement(l_Query);
		rs = pstmt.executeQuery();

		int index = 0;
		while (rs.next()) {
			ref = new Ref1();
			ref.setValue(rs.getString("Code"));
			ref.setCaption(rs.getString("despMyan"));
			arr[index] = ref;
			index++;
		}
		return arr;
	}
	
	
	public static String getNewwardCode(String township, Connection aConn) {
		String ret = new String();
		String l_Key = "";
		try {
			l_Key = WardDao.getMaxWardCode(township, aConn);
			if (l_Key == null || l_Key.equalsIgnoreCase("")) {
				ret = township + "001";

			} else {
				String key = l_Key.substring(1);
				int paramkey = Integer.parseInt(key);

				paramkey += 1;

				ret = leadZeros("" + paramkey, 3);
				ret = township + ret;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static String getNewDistCode(String dist, Connection aConn) {
		String ret = new String();
		String l_Key = "";
		String distinct = "";
		try {
			l_Key = WardDao.getMaxDistCode(dist, aConn);
			if (l_Key == null || l_Key.equalsIgnoreCase("")) {
				distinct = dist.substring(0, 5);
				ret = distinct + "001";
			} else {
				ret = "0" + l_Key;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static String leadZeros(String p, int size) {
		String ret = p;
		for (int i = p.length(); i < size; i++) {
			ret = "0" + ret;
		}
		return ret;
	}

	public static boolean saveTownship(AddressRefData aData, Connection aConn) throws SQLException {
		boolean isvalid = false;
		String query = "INSERT INTO AddressRef (Code ,DespMyan, DespEng , isLocal ,MinLat,MaxLat,MinLon,MaxLon) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = aConn.prepareStatement(query);
		pstmt.setString(1, aData.getCode());
		pstmt.setString(2, aData.getDespMyan());
		pstmt.setString(3, aData.getDespEng().toUpperCase());
		pstmt.setInt(4, 0);
		pstmt.setString(5, aData.getMinLat());
		pstmt.setString(6, aData.getMaxLat());
		pstmt.setString(7, aData.getMinLon());
		pstmt.setString(8, aData.getMaxLon());
		if (pstmt.executeUpdate() > 0) {
			isvalid = true;
		}
		pstmt.close();
		pstmt.close();

		return isvalid;
	}

	public static boolean updateTownship(AddressRefData obj, Connection conn) throws SQLException {
		boolean isvalid = false;
		if (isCodeExist(obj, conn)) {
			String sql = DBMgr.updateString(" WHERE code=" + obj.getCode(), define(), conn);
			PreparedStatement stmt = conn.prepareStatement(sql);
			DBRecord dbr = setDBRecord(obj);
			DBMgr.setValues(stmt, dbr);
			int count = stmt.executeUpdate();
			if (count > 0) {
				isvalid = true;

			} else {
				isvalid = false;
			}
		}
		return isvalid;
	}

	public static boolean isCodeExist(AddressRefData obj, Connection conn) throws SQLException {
		ArrayList<DBRecord> dbrs = DBMgr.getDBRecords(define(), " where code = " + obj.getCode() + " ", "", conn);
		if (dbrs.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static AddressRefDataSet search(String searchVal, String sort, String type,
			Connection conn) throws SQLException {
		AddressRefDataSet res = new AddressRefDataSet();
		ArrayList<AddressRefData> datalist = new ArrayList<AddressRefData>();
		String whereclause = "";
		String orderclause = "ORDER BY code";
		/*if (type.equals("1")) {
			orderclause += " ORDER BY code ";
		} else if (type.equals("2")) {
			orderclause += " ORDER BY code ";
		}
		if (!orderclause.isEmpty()) {
			if (sort.equals("asc")) {
				orderclause += " asc ";
			} else {
				orderclause += " desc ";
			}
		}*/
		// PagerData pgdata = asdata.getPager();
		// String searchStr = "";
		// searchStr = AdvancedSearchStringUtil.getSearchString(asdata.getSearch());
/*		if (!searchStr.isEmpty()) {
			whereclause += searchStr;
		}
		if (!searchVal.equals("")) {
			whereclause += " WHERE ( code LIKE '%" + searchVal + "%' OR despmyan LIKE '%" + searchVal
					+ "%' OR  despeng LIKE '%" + searchVal + "%')";

		}*/
		// int start = pgdata.getStart() - 1;
		int start = 1;
		ArrayList<DBRecord> dbrs = DBMgr.getDBRecordSandE(define(), whereclause, orderclause, start, 1000, 0,
				conn);

		for (int i = 0; i < dbrs.size(); i++) {
			datalist.add(getDBRecord(dbrs.get(i)));
		}
		// res.setPageSize(pgdata.getSize());
		// res.setCurrentPage(pgdata.getCurrent());
		if (datalist.size() > 0) {
			res.setState(true);
		} else {
			res.setState(false);
		}

		PreparedStatement stat = conn.prepareStatement("SELECT COUNT(*) AS recCount FROM addressref " + whereclause);
		ResultSet result = stat.executeQuery();
		result.next();
		res.setTotalCount(result.getInt("recCount"));
		AddressRefData[] dataarray = new AddressRefData[datalist.size()];
		dataarray = datalist.toArray(dataarray);
		res.setData(dataarray);

		return res;
	}

	public static AddressRefData read(String code, Connection conn) throws SQLException {
		AddressRefData ret = new AddressRefData();
		ArrayList<DBRecord> dbrs = DBMgr.getDBRecords(define(), "where code=" + code, "", conn);
		if (dbrs.size() > 0)
			ret = getDBRecord(dbrs.get(0));
		return ret;
	}

	public static AddressRefData readstate(String state, Connection conn) throws SQLException {
		AddressRefData ret = new AddressRefData();
		ArrayList<DBRecord> dbrs = DBMgr.getDBRecords(define(), "where code=" + state, "", conn);
		if (dbrs.size() > 0)
			ret = getDBRecord(dbrs.get(0));
		return ret;
	}

	public static Result delete(String code, Connection conn) throws SQLException {
		Result res = new Result();
		String sql = "DELETE FROM Addressref WHERE code=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, code);
		int rs = stmt.executeUpdate();
		if (rs > 0) {
			res.setState(true);
			res.setMsgDesc("Deleted Successfully!!!");
		} else {
			res.setMsgDesc("Deleting Unsuccessful!!!");
		}
		return res;
	}

}
