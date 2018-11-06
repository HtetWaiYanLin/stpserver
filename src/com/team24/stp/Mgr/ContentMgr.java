package com.team24.stp.Mgr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.nirvasoft.database.SysKeyMgr;
import com.team24.stp.Dao.ContentDao;
import com.team24.stp.framework.ConnAdmin;
import com.team24.stp.framework.MrBean;
import com.team24.stp.framework.Result;
import com.team24.stp.shared.ContentData;
import com.team24.stp.shared.ContentDataSet;
import com.team24.stp.shared.ValueCaptionDataSet;
import com.team24.stp.util.ServerUtil;

public class ContentMgr {
	
	public static Result saveContentData(ContentData data, MrBean user) {
		Result res = new Result();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = saveContentData(data, user, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ServerUtil.closeConnection(conn);
		}
		return res;
	}

	public static Result saveContentData(ContentData data, MrBean user, Connection conn) throws SQLException {
		Result res = new Result();
		data = initData(data, user, conn);
		if (data.getSyskey() == 0) {
			data.setSyskey(SysKeyMgr.getSysKey(1, "syskey", ConnAdmin.getConn(user.getUser().getOrganizationID())));
			res = ContentDao.insert(data, conn);
		} else {
			res = ContentDao.update(data, conn);
		}
		if (res.isState()) {
		}
		return res;
	}

	public static ContentData initData(ContentData data, MrBean user, Connection con) {
		data.setModifieddate(new java.sql.Date(new Date().getTime()));
		if (data.getSyskey() == 0) {
			String id = ContentDao.getContentID(con);
			data.setT1(id);
			data.setCreateddate(new java.sql.Date(new Date().getTime()));
			data.setRecordstatus(1);
		}
		return data;
	}

	public static ContentData readDataBySyskey(long pKey, MrBean user) {
		ContentData res = new ContentData();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = ContentDao.read(pKey, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public static Result deleteContentData(long syskey, MrBean user) {
		Result res = new Result();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = ContentDao.delete(syskey, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static int getMenuCount(String searchVal, MrBean user) {

		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		int res = 0;
		try {
			res = ContentDao.getMenuCount(searchVal, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ContentDataSet searchContentbyValue(String searchVal, String start, String end, String sort,
			String order, MrBean user) {
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		ContentDataSet res = new ContentDataSet();
		try {
			res = ContentDao.searchContent(searchVal, start, end, sort, order, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ValueCaptionDataSet getContentName(MrBean user) {
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		ValueCaptionDataSet res = new ValueCaptionDataSet();
		try {
			res = ContentDao.getContentName(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
