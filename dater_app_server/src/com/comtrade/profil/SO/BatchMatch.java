package com.comtrade.profil.SO;

import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domain.GeneralDomain;
import com.comtrade.domain.Matches;
import com.comtrade.sysops.GeneralSystemOperation;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.comtrade.domain.Constants.DBWRITTEN;
import static com.comtrade.domain.Constants.RDYFORDB;

public class BatchMatch extends GeneralSystemOperation
{
    @Override
    public void executeConcreteOperation(Object obj) throws SQLException {
        HashMap<String, List<GeneralDomain>> ul = (HashMap<String, List<GeneralDomain>>) obj;
        IBroker ib = new Broker();
        ib.saveListMessage(ul);

//        for (Map.Entry<String, List<GeneralDomain>> entry : ul.entrySet()) {
//            List<GeneralDomain> listentry = entry.getValue();
//            for (GeneralDomain temp : listentry) {
//                Matches m = (Matches) temp;
//                if(m.getReadyForSql() == RDYFORDB){
//                    m.setReadyForSql(DBWRITTEN);
//                }
//            }
//        }
    }
}
