package com.team24.stp.Mgr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.nirvasoft.database.SysKeyMgr;
import com.team24.stp.Dao.ClinicDao;
import com.team24.stp.framework.ConnAdmin;
import com.team24.stp.framework.MrBean;
import com.team24.stp.framework.Result;
import com.team24.stp.shared.ClinicData;
import com.team24.stp.shared.ClinicDataset;
import com.team24.stp.shared.ValueCaptionDataSet;
import com.team24.stp.util.ServerUtil;

public class ClinicMgr {

	public static Result saveClinicData(ClinicData data, MrBean user) {
		Result res = new Result();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = saveClinicData(data, user, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ServerUtil.closeConnection(conn);
		}
		return res;
	}

	public static Result saveClinicData(ClinicData data, MrBean user, Connection conn) throws SQLException {
		Result res = new Result();
		data = initData(data, user, conn);
		if (data.getSyskey() == 0) {
			data.setSyskey(SysKeyMgr.getSysKey(1, "syskey", ConnAdmin.getConn(user.getUser().getOrganizationID())));
			res = ClinicDao.insert(data, conn);
		} else {
			res = ClinicDao.update(data, conn);
		}
		if (res.isState()) {
		}
		return res;
	}

	public static ClinicData initData(ClinicData data, MrBean user, Connection con) {
		data.setModified_date(new java.sql.Date(new Date().getTime()));
		if (data.getSyskey() == 0) {
			String id = ClinicDao.getClinicId(con);
			data.setT1(id);
			data.setCreated_date(new java.sql.Date(new Date().getTime()));
			data.setRecord_status(1);
		}
		return data;
	}

	public static ClinicData readDataBySyskey(long pKey, MrBean user) {
		ClinicData res = new ClinicData();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = ClinicDao.read(pKey, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public static Result deleteClinicData(long syskey, MrBean user) {
		Result res = new Result();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = ClinicDao.delete(syskey, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ClinicDataset searchClinicbyValue(MrBean user) {
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		ClinicDataset res = new ClinicDataset();
		try {
			res = ClinicDao.searchClinic(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ValueCaptionDataSet getClinicName(MrBean user) {
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		ValueCaptionDataSet res = new ValueCaptionDataSet();
		try {
			res = ClinicDao.getClinicName(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
