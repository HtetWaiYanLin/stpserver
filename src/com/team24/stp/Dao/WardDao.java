package com.team24.stp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nirvasoft.database.DBField;
import com.nirvasoft.database.DBMgr;
import com.nirvasoft.database.DBRecord;
import com.team24.stp.framework.Result;
import com.team24.stp.shared.AddressData;
import com.team24.stp.shared.AddressDataList;
import com.team24.stp.shared.AdvancedSearchData;
import com.team24.stp.shared.PagerData;
import com.team24.stp.shared.WardData;
import com.team24.stp.shared.WardDataSet;

public class WardDao {
	public static DBRecord define() {
		DBRecord ret = new DBRecord();
		ret.setTableName("AddressExRef");
		ret.setFields(new ArrayList<DBField>());
		ret.getFields().add(new DBField("syskey", (byte) 5));
		ret.getFields().add(new DBField("code", (byte) 5));
		ret.getFields().add(new DBField("despMyan", (byte) 5));
		ret.getFields().add(new DBField("despEng", (byte) 5));
		ret.getFields().add(new DBField("isLocal", (byte) 2));
		ret.getFields().add(new DBField("wardcode", (byte) 5));
		ret.getFields().add(new DBField("recordstatus", (byte) 1));

		return ret;
	}

	public static DBRecord define(String tabName) {
		DBRecord ret = new DBRecord();
		ret.setTableName(tabName);
		ret.setFields(new ArrayList<DBField>());
		ret.getFields().add(new DBField("syskey", (byte) 5));
		ret.getFields().add(new DBField("code", (byte) 5));
		ret.getFields().add(new DBField("despMyan", (byte) 5));
		ret.getFields().add(new DBField("despEng", (byte) 5));
		ret.getFields().add(new DBField("isLocal", (byte) 2));
		ret.getFields().add(new DBField("wardcode", (byte) 5));
		ret.getFields().add(new DBField("recordstatus", (byte) 1));
		return ret;
	}

	public static WardData getDBRecord(DBRecord adbr) {
		WardData ret = new WardData();
		ret.setSyskey(adbr.getLong("syskey"));
		ret.setCode(adbr.getString("code"));
		ret.setDespMyan(adbr.getString("despMyan"));
		ret.setDespEng(adbr.getString("despEng"));
		ret.setIsLocal(adbr.getLong("isLocal"));
		ret.setWardcode(adbr.getString("wardcode"));
		ret.setRecordstatus(adbr.getInt("RecordStatus"));
		return ret;
	}

	public static DBRecord setDBRecord(WardData data) {
		DBRecord ret = define();
		ret.setValue("syskey", data.getSyskey());
		ret.setValue("code", data.getCode());
		ret.setValue("despMyan", data.getDespMyan());
		ret.setValue("despEng", data.getDespEng());
		ret.setValue("isLocal", data.getIsLocal());
		ret.setValue("wardcode", data.getWardcode());
		ret.setValue("recordstatus", data.getRecordstatus());
		return ret;
	}

	public static String getMaxWardCode(String township, Connection aConn) throws SQLException {
		String l_Key = "";
		String l_Query = "select MAX(SUBSTRING(WardCode,9,3)) maxkey from AddressExRef where Code = ?";
		PreparedStatement pstmt = aConn.prepareStatement(l_Query);
		pstmt.setString(1, township);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			l_Key = rs.getString("maxkey");
		}
		return l_Key;

	}

	public static String getMaxDistCode(String dist, Connection aConn) throws SQLException {
		String l_Key = "";

		String distinct = dist.substring(0, 5);
		System.out.println("Distinct --> " + dist + " After cut  --> " + dist.substring(0, 5));
		String l_Query = "select ISNULL(MAX(Code) + 1, 1) as maxdist from dbo.AddressRef  where SUBSTRING(code,1,5) = ? and  SUBSTRING(code,6,3) <> '000'";
		PreparedStatement pstmt = aConn.prepareStatement(l_Query);
		pstmt.setString(1, distinct);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			l_Key = rs.getString("maxdist");
		}
		return l_Key;

	}

	public static boolean saveWard(WardData aData, Connection aConn) throws SQLException {
		boolean isvalid = false;
		String query = "INSERT INTO AddressExRef (Syskey,Code ,DespMyan, DespEng , isLocal ,wardcode,recordstatus) "
				+ "VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = aConn.prepareStatement(query);
		pstmt.setLong(1, aData.getSyskey());
		pstmt.setString(2, aData.getTownship());
		pstmt.setString(3, aData.getDespMyan());
		pstmt.setString(4, aData.getDespEng().toUpperCase());
		pstmt.setInt(5, 0);
		pstmt.setString(6, aData.getWardcode());
		pstmt.setInt(7, 1);
		if (pstmt.executeUpdate() > 0) {
			isvalid = true;
		}
		pstmt.close();
		String Query = "select Syskey from AddressExRef where Code=?";
		pstmt = aConn.prepareStatement(Query);
		pstmt.setString(1, aData.getTownship());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			aData.setSyskey(rs.getLong("Syskey"));
		}
		pstmt.close();

		return isvalid;
	}

	public static boolean updateWard(WardData aData, Connection aConn) throws SQLException {
		boolean isvalid = false;
		String query = "Update AddressExRef set Code=? ,DespMyan = ?, DespEng=?, isLocal=? " + " where wardcode = ? ";
		int j = 1;
		PreparedStatement pstmt = aConn.prepareStatement(query);
		pstmt.setString(j++, aData.getTownship());
		pstmt.setString(j++, aData.getDespMyan());
		pstmt.setString(j++, aData.getDespEng().toUpperCase());
		pstmt.setInt(j++, 0);
		pstmt.setString(j++, aData.getWardcode());
		if (pstmt.executeUpdate() > 0) {
			isvalid = true;
		}
		pstmt.close();
		return isvalid;
	}

	public static AddressDataList addressSetuplist(String searchText, int pageSize, int currentPage, Connection pConn)
			throws SQLException {

		AddressDataList result = new AddressDataList();
		ArrayList<AddressData> datalist = new ArrayList<AddressData>();

		int l_startRecord = (currentPage - 1) * pageSize;
		int l_endRecord = l_startRecord + pageSize;
		String whereClause = "";
		if ((!searchText.isEmpty()) && (searchText.trim().length() > 0)) {
			whereClause += " WHERE (DespMyan LIKE N'%" + searchText + "%'OR DespEng LIKE N'%" + searchText
					+ "%' OR wardcode LIKE N'%" + searchText + "%')";
		} else {

		}

		String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER (ORDER BY [Code] ASC) AS RowNum, "
				+ " Syskey , SUBSTRING(code,1,2)+'000000' division,SUBSTRING(code,1,5)+'000' dist,[Code],[DespMyan],[DespEng],[IsLocal],[wardcode] FROM [AddressExRef]"
				+ whereClause + ") AS RowConstrainedResult" + " WHERE ( RowNum > " + l_startRecord + " and RowNum <= "
				+ l_endRecord + " )";

		PreparedStatement pstmt = pConn.prepareStatement(sql);
		System.out.println("Queryforlist: " + sql);
		ResultSet rs = pstmt.executeQuery();
		int j = 1;
		while (rs.next()) {
			AddressData data = new AddressData();
			data.setSrno(j++);
			data.setSyskey(rs.getLong("Syskey"));
			data.setDivision(rs.getString("division"));
			data.setDistinct(rs.getString("dist"));
			data.setCode(rs.getString("code"));
			data.setDespmyan(rs.getString("DespMyan"));
			data.setDespeng(rs.getString("DespEng"));
			data.setIslocal(rs.getString("IsLocal"));
			data.setWardcode(rs.getString("wardcode"));
			datalist.add(data);
		}

		AddressData[] dataarry = new AddressData[datalist.size()];

		for (int i = 0; i < datalist.size(); i++) {
			dataarry[i] = datalist.get(i);
		}
		result.setData(dataarry);
		result.setSearchText(searchText);
		result.setCurrentPage(currentPage);
		result.setPageSize(pageSize);

		PreparedStatement stat = pConn.prepareStatement("SELECT COUNT(*) AS tot FROM AddressExRef" + whereClause);

		ResultSet rSet = stat.executeQuery();
		rSet.next();

		result.setTotalCount(rSet.getInt("tot"));
		return result;

	}

	public static String getmaxSyskey(String tablename, Connection aConn) throws SQLException {
		String l_Key = "";
		String l_Query = " SELECT MAX(syskey) as syskey  from " + tablename;
		PreparedStatement pstmt = aConn.prepareStatement(l_Query);
		ResultSet rs = pstmt.executeQuery();
		int plus = 0;
		while (rs.next()) {
			l_Key = rs.getString("syskey");
		}
		if (l_Key == null || l_Key == "") {
			l_Key = "111";
		} else {
			plus = Integer.parseInt(l_Key) + 1;
			l_Key = String.valueOf(plus);
		}
		return l_Key;
	}

	public static WardDataSet search(AdvancedSearchData asdata, String searchVal, String sort, Connection conn)
			throws SQLException {
		WardDataSet res = new WardDataSet();
		ArrayList<WardData> datalist = new ArrayList<WardData>();
		String whereclause = " WHERE RecordStatus<>4 ";
		PagerData pgdata = asdata.getPager();
		String searchStr = "";
		// searchStr = AdvancedSearchStringUtil.getSearchString(asdata.getSearch());

		if (!searchStr.isEmpty()) {
			whereclause += searchStr;
		}
		if (!searchVal.equals("")) {
			whereclause += "AND ( code LIKE '%" + searchVal + "%' OR  wardcode LIKE '%" + searchVal
					+ "%' OR despmyan LIKE '%" + searchVal + "%' OR  despeng LIKE '%" + searchVal + "%')";

		}
		int start = pgdata.getStart() - 1;
		ArrayList<DBRecord> dbrs = DBMgr.getDBRecordSandE(define(), whereclause, " ORDER BY syskey  ", start,
				pgdata.getEnd(), 0, conn);

		for (int i = 0; i < dbrs.size(); i++) {
			datalist.add(getDBRecord(dbrs.get(i)));
		}
		res.setPageSize(pgdata.getSize());
		res.setCurrentPage(pgdata.getCurrent());
		if (datalist.size() > 0) {
			res.setState(true);
		} else {
			res.setState(false);
		}
		PreparedStatement stat = conn.prepareStatement("SELECT COUNT(*) AS recCount FROM AddressExRef " + whereclause);
		ResultSet result = stat.executeQuery();
		result.next();
		res.setTotalCount(result.getInt("recCount"));
		WardData[] dataarray = new WardData[datalist.size()];
		dataarray = datalist.toArray(dataarray);
		res.setData(dataarray);

		return res;
	}

	public static WardData read(String wardcode, Connection conn) throws SQLException {
		WardData ret = new WardData();
		ArrayList<DBRecord> dbrs = DBMgr.getDBRecords(define(), "where wardcode='" + wardcode + "'", "", conn);
		if (dbrs.size() > 0)
			ret = getDBRecord(dbrs.get(0));
		return ret;
	}

	public static Result deletevillage(String wardcode, Connection conn) throws SQLException {
		Result res = new Result();
		String sql = "DELETE FROM Addressexref WHERE wardcode=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, wardcode);
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
