package com.team24.stp.service;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.team24.stp.Mgr.RoleMgr;
import com.team24.stp.framework.MrBean;
import com.team24.stp.framework.Result;
import com.team24.stp.framework.ServerSession;
import com.team24.stp.shared.RoleData;
import com.team24.stp.shared.RoleDataset;
import com.team24.stp.shared.RoleMenuData;
import com.team24.stp.shared.RoleParentMenuData;
import com.team24.stp.shared.ValueCaptionDataSet;

@Path("/serviceRole")
public class ServiceRole {

	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	@javax.ws.rs.core.Context
	ServletContext context;

	public static String userid = "";
	public static String username = "";
	public static String userpsw = "";

	private MrBean getUser() {
		ServerSession.serverPath = request.getServletContext().getRealPath("/") + "/";
		MrBean user = new MrBean();
		user.getUser().setOrganizationID("001");
		user.getUser().setUserId(userid);
		user.getUser().setUserName(username);
		user.getUser().setPassword(userpsw);
		return user;
	}

	@POST
	@Path("saveRole")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Result saveRole(RoleData data) {
		Result res = new Result();
		res = RoleMgr.saveRoleData(data, getUser());
		return res;
	}

	@GET
	@Path("deleteRole")
	@Produces(MediaType.APPLICATION_JSON)
	public Result deleteRoleData() {
		Result res = new Result();
		long pKey = Long.parseLong(request.getParameter("syskey"));
		try {
			res = RoleMgr.deleteRoleData(pKey, getUser());
		} catch (Exception e) {
			res.setMsgDesc("Can't Delete!");
		}
		return res;
	}

	@GET
	@Path("readRole")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RoleData readURoleDataBySyskey() {
		RoleData res = new RoleData();
		String key = request.getParameter("syskey");
		long syskey = 0;
		if (key != null) {
			syskey = Long.parseLong(key);
		}
		res = RoleMgr.readDataBySyskey(syskey, getUser());
		return res;
	}

	@GET
	@Path("getRolelist")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RoleDataset getRolelist() {
		String searchVal = request.getParameter("searchVal");
		String page = request.getParameter("page");
		String order = request.getParameter("order");
		String sort = request.getParameter("sort");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		System.out.println("page  : " + page + "  order  : " + order + "  sort  :  " + sort);
		System.out.println("start  :" + start);
		System.out.println("end  :" + end);
		RoleDataset res = new RoleDataset();
		res = RoleMgr.searchRolebyValue(searchVal, start, end, sort, order, getUser());
		return res;
	}

	@GET
	@Path("getRoleCombo")
	@Produces(MediaType.APPLICATION_JSON)
	public ValueCaptionDataSet getRoleCombo() {
		ValueCaptionDataSet res = new ValueCaptionDataSet();
		res = RoleMgr.getRoleCombo(getUser());
		return res;
	}

	@GET
	@Path("getRoleMenus")
	@Produces(MediaType.APPLICATION_JSON)
	public RoleParentMenuData getRoleMenus() throws SQLException {
		RoleMenuData[] dataarray;
		RoleParentMenuData res = new RoleParentMenuData();
		dataarray = RoleMgr.getRoleMenuList(getUser());
		res.setMenu(dataarray);
		return res;
	}

}
