package com.team24.stp.service;

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

import com.team24.stp.Mgr.AddressMgr;
import com.team24.stp.framework.MrBean;
import com.team24.stp.framework.Result;
import com.team24.stp.framework.ServerSession;
import com.team24.stp.shared.AddressDataList;
import com.team24.stp.shared.AddressRefData;
import com.team24.stp.shared.AddressRefDataSet;
import com.team24.stp.shared.AdvancedSearchData;
import com.team24.stp.shared.Ref1;
import com.team24.stp.shared.WardData;
import com.team24.stp.shared.WardDataSet;

@Path("/serviceaddress")
public class ServiceAddress {
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	@javax.ws.rs.core.Context
	ServletContext context;

	private MrBean getUser() {
		ServerSession.serverPath = request.getServletContext().getRealPath("/") + "/";
		MrBean user = new MrBean();
		user.getUser().setOrganizationID("001");
		user.getUser().setUserId(Service001.userid);
		user.getUser().setUserName(Service001.username);
		return user;
	}

	@GET
	@Path("getDivision")
	@Produces(MediaType.APPLICATION_JSON)
	public Ref1[] getDivision() {
		Ref1[] res = null;
		res = AddressMgr.getDivision(getUser());
		return res;
	}

	@GET
	@Path("getDistinctbyDiv")
	@Produces(MediaType.APPLICATION_JSON)
	public Ref1[] getDistinctbyDiv() {
		String division = request.getParameter("div");
		Ref1[] res = null;
		res = AddressMgr.getDistinctbyDiv(division, getUser());
		return res;
	}
	
	@GET
	@Path("getAllDistrict")
	@Produces(MediaType.APPLICATION_JSON)
	public Ref1[] getAllDistrict() {
		Ref1[] res = null;
		res = AddressMgr.getAllDistrict(getUser());
		return res;
	}

	@GET
	@Path("getTownshipByDistinct")
	@Produces(MediaType.APPLICATION_JSON)
	public Ref1[] getTownshipByDistinct() {
		String distinct = request.getParameter("distinct");
		Ref1[] res = null;
		res = AddressMgr.getTownshipByDistinct(distinct, getUser());
		return res;
	}
	
	@GET
	@Path("getAllTownship")
	@Produces(MediaType.APPLICATION_JSON)
	public Ref1[] getAllTownship() {
		Ref1[] res = null;
		res = AddressMgr.getAllTownship(getUser());
		return res;
	}

	@POST
	@Path("saveWard")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public WardData saveWard(WardData p) {
		p = AddressMgr.saveWard(p, getUser());
		return p;
	}

	// save township
	@POST
	@Path("saveTownship")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AddressRefData saveTownship(AddressRefData p) {
		p = AddressMgr.saveTownship(p, getUser());
		return p;
	}

	@POST
	@Path("addressSetuplist")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AddressDataList addressSetuplist(AddressDataList data) {
		AddressDataList res = new AddressDataList();
		res = AddressMgr.addressSetuplist(data, getUser());
		return res;
	}

	// village list
	@POST
	@Path("searchaddressList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public WardDataSet searchaddressList(AdvancedSearchData p) {
		String searchVal = request.getParameter("searchVal");
		String sort = request.getParameter("sort");
		WardDataSet res = new WardDataSet();
		res = AddressMgr.searchVillage(p, searchVal, sort, getUser());
		return res;
	}

	@GET
	@Path("searchtownship")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AddressRefDataSet searchtownship() {
		String searchVal = request.getParameter("searchVal");
		String sort = request.getParameter("sort");
		String type = request.getParameter("type");
		AddressRefDataSet res = new AddressRefDataSet();
		res = AddressMgr.searchtownship(searchVal, sort, type, getUser());
		return res;
	}

	@GET
	@Path("readBySyskey")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AddressRefData readDataBySyskey() {
		AddressRefData ret;
		String code = request.getParameter("key");
		ret = AddressMgr.readDataBySyskey(code, getUser());
		return ret;
	}

	@GET
	@Path("readByVillageSyskey")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public WardData readBySyskey() {
		WardData ret;
		String syskey = request.getParameter("key");
		ret = AddressMgr.readBySyskey(syskey, getUser());
		return ret;
	}

	@POST
	@Path("deletetownship")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Result deletetownship(AddressRefData p) {
		Result res = new Result();
		String code = p.getCode();
		res = AddressMgr.delettownship(code, getUser());
		return res;
	}

	@POST
	@Path("deletevillage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Result deletevillage(WardData p) {
		Result res = new Result();
		String wardcode = p.getWardcode();
		res = AddressMgr.deletevillage(wardcode, getUser());
		return res;
	}
}
