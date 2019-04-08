package com.comtrade.broker;

import com.comtrade.connection.Connection;
import com.comtrade.domain.GeneralDomain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class Broker implements IBroker {
	private static Broker instance;
	private static final Object mutex = new Object();

	public Broker() {

	}


	public static Broker getInstance() {
		Broker result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null) {
					result = instance = new Broker();
				}
			}

		}
		return instance;
	}


	public void save(GeneralDomain gd) {
		String query = "INSERT INTO " + gd.returnTableName() + " " + gd.returnTableRows() + " " + gd.returnInsertFormat();
		try {
			Statement st = Connection.getInstance().getConn().createStatement();
			st.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(GeneralDomain gd) {
		String statement = "DELETE FROM " + gd.returnTableName() + gd.delete(gd);
		try {
			Statement st = Connection.getInstance().getConn().createStatement();
			st.executeUpdate(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<GeneralDomain> getAll(GeneralDomain gd) {
		String upit = "select * from " + gd.returnTableName();
		List<GeneralDomain> list = null;
		try {
			Statement st = Connection.getInstance().getConn().createStatement();
			ResultSet rs = st.executeQuery(upit);
			list = gd.fixSelect(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

    @Override
    public HashMap<String, GeneralDomain> getInnerJoinUser(GeneralDomain gd) {
        String hello = "";
        String upit = "select * from " + gd.returnTableName();
        HashMap<String, GeneralDomain> userHash = new HashMap<>();
        try {
            Statement st = Connection.getInstance().getConn().createStatement();
            ResultSet rs = st.executeQuery(upit);
            userHash = gd.fixInnerSelect(rs);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userHash;
    }

    @Override
    public HashMap<String, GeneralDomain> getInnerJoinNewUser(GeneralDomain gd) {
        return null;
    }


}
