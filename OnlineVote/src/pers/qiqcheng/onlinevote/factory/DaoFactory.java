package pers.qiqcheng.onlinevote.factory;

import pers.qiqcheng.onlinevote.dao.IVoteDao;
import pers.qiqcheng.onlinevote.proxy.VoteDaoProxy;

public class DaoFactory {
	public static IVoteDao getVoteDaoInstance() throws Exception{
		return new VoteDaoProxy();
	}

}
