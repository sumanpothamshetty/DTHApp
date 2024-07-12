package com.edubridge.DTHApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.DTHApp.Model1.DTH;
import com.edubridge.contactapputil.DBUtils;

public class DTHDAOIMPL implements DTHDAO {

	@Override
	public int addDTH(DTH d) {
		String INSERT=" insert into DTH(dth_id,dth_name,dth_channels,dth_price) values(?,?,?,?)";
		Connection con=DBUtils.getConnection();
		int status=0;
		try {
			PreparedStatement ps=con.prepareStatement(INSERT);
			ps.setInt(1,d.getDth_id());
			ps.setString(2,d.getDth_name());
			ps.setInt(3,d.getDth_channels());
			ps.setFloat(4, d.getDth_price());
			status=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return status;

	}

	@Override
	public List<DTH> getAllDTH() {
		
			String SELECT="select* from DTH";
			Connection con=DBUtils.getConnection();
			List<DTH> DTH =new ArrayList<DTH>();
			try {
				PreparedStatement ps=con.prepareStatement(SELECT);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					DTH d=new DTH();
					d.setDth_id(rs.getInt("dth_id"));
					d.setDth_name(rs.getString("dth_name"));
					d.setDth_channels(rs.getInt("dth_channels"));
					d.setDth_price(rs.getFloat("dth_price"));
					DTH.add(d);
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return DTH;
	}

	@Override
	public DTH getDTH(String dth_name) {
		
			String SELECT_BY_NAME="select* from DTH where dth_name=?";
			Connection con =DBUtils.getConnection();
		DTH d =new DTH();
				
			try {
				PreparedStatement ps=con.prepareStatement(SELECT_BY_NAME);
				ps.setString(1, dth_name);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
				    d.setDth_id(rs.getInt("dth_id"));
					d.setDth_name(rs.getString("dth_name"));
					d.setDth_channels(rs.getInt("dth_channels"));
					d.setDth_price(rs.getFloat("dth_price"));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return d;
		}
				
	@Override
	public int updateDTH(DTH d) {
		
			
			 String UPDATE = "update DTH set dth_name = ?, dth_channels = ?, dth_price = ? where dth_id = ?";
			    Connection con = DBUtils.getConnection();
			    int status = 0;
			    try {
			        PreparedStatement ps = con.prepareStatement(UPDATE);
			        ps.setString(1, d.getDth_name());
			        ps.setInt(2, d.getDth_channels());
			        ps.setFloat(3, d.getDth_price());
			        ps.setInt(4, d.getDth_id());
			        status = ps.executeUpdate();
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			return status;
		}
		

	@Override
	public int deleteDTH(String dth_name) {
		
		
			String DELETE = "delete from DTH where dth_name = ?";
		    Connection con = DBUtils.getConnection();
		    int status = 0;
		    try {
		        PreparedStatement ps = con.prepareStatement(DELETE);
		        ps.setString(1, dth_name);
		        status = ps.executeUpdate();
		    } catch (SQLException e) {
		    	
		        e.printStackTrace();
		    }
			return status;
		}
		
	@Override
	public void deleteAllDTH() {
		String DELETE_ALL = "delete from DTH";
	    Connection con = DBUtils.getConnection();
	    try {
	        PreparedStatement ps = con.prepareStatement(DELETE_ALL);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }		
	}

}
