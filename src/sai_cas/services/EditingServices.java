/*
	   Copyright (C) 2005-2006 Sergey Koposov
   
    Author: Sergey Koposov
    Email: math@sai.msu.ru 
    http://lnfm1.sai.msu.ru/~math

    This file is part of SAI CAS

    SAI CAS is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    SAI CAS is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SAI CAS; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/



package sai_cas.services;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import sai_cas.db.*;

public class EditingServices {
	static Logger logger = Logger.getLogger("sai_cas.EditingServices");
	
	/**
	 * 
	 * @return String -- the info about the catalogue
	 * @throws Exception
	 */
	public static void renameTable(String catalog, String table, String newTable, String user, String password)  throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			dbi.renameTable(catalog, table, newTable);
		}
		catch(SQLException e)
		{
			logger.debug("Caught an exception... ", e);			
			DBInterface.close(dbi, conn, false);
			throw new RemoteException(e.getMessage());		
		}
		DBInterface.close(dbi, conn);
	}


	public static void setUCD(String catalog, String table, String column, 
		String ucd, String user, String password) throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			ArrayList<String> alColumn  = new ArrayList<String>();
			alColumn.add(column);
			ArrayList<String> alUcd  = new ArrayList<String>();
			alUcd.add(ucd);
			dbi.setUcds (catalog, table, alColumn, alUcd);
		}
		catch(SQLException e)
		{
			logger.error("Caught an exception... ", e);
			DBInterface.close(dbi, conn, false);
			throw new RemoteException(e.getMessage());
		}
		DBInterface.close(dbi, conn);
	} 
	public static void setUnit(String catalog, String table, String column, 
		String unit, String user, String password) throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			dbi.setUnit (catalog, table, column, unit);
		}
		catch(SQLException e)
		{
			logger.error("Caught an exception... ", e);
			DBInterface.close(dbi, conn, false);
			throw new RemoteException(e.getMessage());
		}
		DBInterface.close(dbi, conn);	
	}

	public static void renameColumn(String catalog, String table, String columnName, 
		String newColumnName, String user, String password) throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			dbi.renameColumn(catalog, table, columnName, newColumnName);
		}
		catch(SQLException e)
		{
			logger.error("Caught an exception... ", e);
			DBInterface.close(dbi, conn, false);
			throw new RemoteException(e.getMessage());
		}
		DBInterface.close(dbi, conn);	
	}


	public static void setColumnDescription(String catalog, String table, String column,
		String description, String user, String password) throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			dbi.setAttributeDescription(catalog, table, column, description);
		}
		catch(SQLException e)
		{
			logger.error("Caught an exception... ", e);
			DBInterface.close(dbi, conn, false);
			throw new RemoteException(e.getMessage());
		}
		DBInterface.close(dbi, conn);	
	}

	public static void setColumnInfo(String catalog, String table, String column,
		String info, String user, String password) throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			dbi.setAttributeInfo(catalog, table, column, info);
		}
		catch(SQLException e)
		{
			logger.error("Caught an exception... ", e);
			DBInterface.close(dbi, conn, false);
			throw new RemoteException(e.getMessage());
		}
		DBInterface.close(dbi, conn);	
	}


	public static void setTableDescription(String catalog, String table,
		String description, String user, String password) throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			dbi.setTableDescription(catalog, table, description);
		}
		catch(SQLException e)
		{
			logger.error("Caught an exception... ", e);
			DBInterface.close(dbi, conn, false);
			throw new RemoteException(e.getMessage());
		}
		DBInterface.close(dbi, conn);	
	}

	public static void setTableInfo(String catalog, String table,
		String info, String user, String password) throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			dbi.setTableDescription(catalog, table, info);
		}
		catch(SQLException e)
		{
			logger.error("Caught an exception... ", e);
			DBInterface.close(dbi, conn, false);
			throw new RemoteException(e.getMessage());
		}
		DBInterface.close(dbi, conn);	
	}


	public static void setCatalogDescription(String catalog,
		String description, String user, String password) throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			dbi.setCatalogDescription(catalog, description);
		}
		catch(SQLException e)
		{
			logger.error("Caught an exception... ", e);
			DBInterface.close(dbi, conn, false);
			throw new RemoteException(e.getMessage());
		}
		DBInterface.close(dbi, conn);	
	}

	public static void setCatalogInfo(String catalog, String info,
		String user, String password) throws java.rmi.RemoteException
	{
		Connection conn = null;
		DBInterface dbi = null;
		try
		{
			conn = DBConnection.getPooledPerUserConnection(user, password);
			dbi = new DBInterface(conn, user);
			dbi.setCatalogInfo(catalog, info);
		}
		catch(SQLException e)
		{
			logger.error("Caught an exception... ", e);
			DBInterface.close(dbi, conn);
			throw new RemoteException(e.getMessage());
		}
		DBInterface.close(dbi, conn);	
	}
}


