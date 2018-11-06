package com.team24.stp.Mgr;

import java.sql.Connection;
import java.sql.SQLException;

import com.team24.stp.Dao.AddressDao;
import com.team24.stp.Dao.WardDao;
import com.team24.stp.framework.ConnAdmin;
import com.team24.stp.framework.MrBean;
import com.team24.stp.framework.Result;
import com.team24.stp.shared.AddressDataList;
import com.team24.stp.shared.AddressRefData;
import com.team24.stp.shared.AddressRefDataSet;
import com.team24.stp.shared.AdvancedSearchData;
import com.team24.stp.shared.Ref1;
import com.team24.stp.shared.WardData;
import com.team24.stp.shared.WardDataSet;

public class AddressMgr {
	
	public static Ref1[] getDivision(MrBean user) {
		Ref1[] ref = null;
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			ref = AddressDao.getDivision(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ref;
	}

	public static Ref1[] getDistinctbyDiv(String division, MrBean user) {
		Ref1[] ref = null;
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			ref = AddressDao.getDistinctbyDiv(division, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ref;
	}
	
	public static Ref1[] getAllDistrict( MrBean user) {
		Ref1[] ref = null;
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			ref = AddressDao.getAllDistrict(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ref;
	}

	public static Ref1[] getTownshipByDistinct(String distinct, MrBean user) {
		Ref1[] ref = null;
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			ref = AddressDao.getTownshipByDistinct(distinct, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ref;
	}
	public static Ref1[] getAllTownship(MrBean user) {
		Ref1[] ref = null;
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			ref = AddressDao.getAllTownship(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ref;
	}
	
	

	public static WardData saveWard(WardData aData, MrBean user) {
		try {
			Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
			if (aData.getWardcode().equalsIgnoreCase("TBA")) {
				// insert
				String wardcode = AddressDao.getNewwardCode(aData.getTownship(), conn);
				aData.setWardcode(wardcode);
				aData.setSyskey(Long.parseLong(WardDao.getmaxSyskey("AddressExRef", conn)));
				boolean res = WardDao.saveWard(aData, conn);
				if (res) {
					aData.setErrorcode("0000");
					aData.setErrormessage("Saved Sucessfully");
				} else {
					aData.setErrorcode("0050");
					aData.setErrormessage("Save Fail");
				}
			} else {
				// update
				boolean res = WardDao.updateWard(aData, conn);
				if (res) {
					aData.setErrorcode("0001");
					aData.setErrormessage("Updated Sucessfully");
				} else {
					aData.setErrorcode("0051");
					aData.setErrormessage("Update Fail");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			aData.setErrorcode("0050");
			aData.setErrormessage(e.getMessage());
		}
		return aData;
	}

	public static AddressRefData saveTownship(AddressRefData aData, MrBean user) {
		try {
			Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
			if (aData.getCode().equalsIgnoreCase("TBA")) {
				// insert
				String towncode = AddressDao.getNewDistCode(aData.getDistric(), conn);
				aData.setCode(towncode);
				boolean res = AddressDao.saveTownship(aData, conn);
				if (res) {
					aData.setErrorcode("0000");
					aData.setErrormessage("Saved Sucessfully");
				} else {
					aData.setErrorcode("0050");
					aData.setErrormessage("Save Fail");
				}
			} else {
				// update
				boolean res = AddressDao.updateTownship(aData, conn);
				if (res) {
					aData.setErrorcode("0001");
					aData.setErrormessage("Updated Sucessfully");
				} else {
					aData.setErrorcode("0051");
					aData.setErrormessage("Update Fail");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			aData.setErrorcode("0050");
			aData.setErrormessage(e.getMessage());
		}
		return aData;
	}

	public static AddressDataList addressSetuplist(AddressDataList data, MrBean user) {
		AddressDataList ret = new AddressDataList();
		try {
			Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
			String searchText = data.getSearchText();
			int pageSize = data.getPageSize();
			int currentPage = data.getCurrentPage();
			ret = WardDao.addressSetuplist(searchText, pageSize, currentPage, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static WardDataSet searchVillage(AdvancedSearchData p, String searchVal, String sort, MrBean user) {
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		WardDataSet res = new WardDataSet();
		try {
			res = WardDao.search(p, searchVal, sort, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static AddressRefDataSet searchtownship(String searchVal, String sort, String type,
			MrBean user) {
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		AddressRefDataSet res = new AddressRefDataSet();
		try {
			res = AddressDao.search(searchVal, sort, type, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	public static AddressRefData readDataBySyskey(String code, MrBean user) {
		AddressRefData res = new AddressRefData();
		AddressRefData resdata = new AddressRefData();
		AddressRefData resdist = new AddressRefData();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = AddressDao.read(code, conn);
			String statesub = res.getCode().substring(0, 2);
			String state = statesub + "000000";
			resdata = AddressDao.readstate(state, conn);
			res.setDivision(resdata.getCode());
			String distsub = res.getCode().substring(0, 5);
			String dist = distsub + "000";
			resdist = AddressDao.readstate(dist, conn);
			res.setDistric(resdist.getCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	// village
	public static WardData readBySyskey(String code, MrBean user) {
		WardData res = new WardData();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = WardDao.read(code, conn);
			String statesub = res.getWardcode().substring(0, 2);
			String state = statesub + "000000";
			res.setDivision(state);
			String distsub = res.getCode().substring(0, 5);
			String dist = distsub + "000";
			res.setDistinc(dist);
			res.setTownship(res.getCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static Result delettownship(String code, MrBean user) {
		Result res = new Result();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = AddressDao.delete(code, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static Result deletevillage(String wardcode, MrBean user) {
		Result res = new Result();
		Connection conn = ConnAdmin.getConn(user.getUser().getOrganizationID());
		try {
			res = WardDao.deletevillage(wardcode, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
