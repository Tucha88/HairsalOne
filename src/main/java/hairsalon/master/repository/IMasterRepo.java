package hairsalon.master.repository;

import hairsalon.master.Master;
import hairsalon.master.MasterAuthType;

import java.util.List;

/**
 * Created by Boris on 01.04.2017.
 */
public interface IMasterRepo {
    public Master registerMaster(Master addMaster);
    public Master getMasterInfo(Master master);
    public Master loginMaster(MasterAuthType updateMaster);
    public String deliteMaster(Master removeMaster);
    public List<Master> getAllMastersInfo();
    public Master updateMasterInfo(Master master);
}
