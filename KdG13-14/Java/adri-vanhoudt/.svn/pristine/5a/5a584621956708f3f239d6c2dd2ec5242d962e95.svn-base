/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.repaircafemodel.persistence.api;

import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.users.Client;
import be.kdg.repaircafemodel.dom.users.Repairer;
import java.util.List;

/**
 *
 * @author wouter
 */
public interface RepairDAO
{
    public void saveRepair(Repair repair);
    public void deleteRepair(Repair repair);
    
    public Repair getRepairByID(int id);
    public List<Repair> getRepairsByClient(Client client);
    public List<Repair> getRepairsByRepairer(Repairer repairer);    
    public List<Repair> getClosedRepairsByUser(Client client);
    public List<Repair> getOpenRepairsByUser(Client client);
    public List<Repair> getAllRepairs();
    public List<Repair> getAllClosedRepairs();
    public List<Repair> getAllOpenRepairs();
    public List<Repair> getRepairsByBrand(String brand);
    public List<Repair> getRepairsByCategory(String category);
    public List<Repair> getRepairsByDefect(String defect);
    public List<String> getAllCategories();
    public List<String> getAllDefects();
    public List<String> getAllBrands();

    public void removeAllRepairs();

    public List<Repair> getRepairsByKeyword(String keyword);

    
    
}
