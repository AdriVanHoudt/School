/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.repaircafemodel.persistence.impl;

import be.kdg.repaircafemodel.dom.repairs.Repair;
import be.kdg.repaircafemodel.dom.users.User;
import be.kdg.repaircafemodel.service.exceptions.RepairServiceException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author wouter
 */
//@Repository("repairDAO")
//public class RepairDAOMapImpl implements RepairDAO
public class RepairDAOMapImpl 
{
    private final Map<Integer, Repair> repairsById = new ConcurrentHashMap<>();
    private final Map<String, Set<Repair>> repairsByCategory = new ConcurrentHashMap<>();
    private final Map<String, Set<Repair>> repairsByDefect = new ConcurrentHashMap<>();
    private final Map<User,Set<Repair>> repairsByUser = new ConcurrentHashMap<>();
    
    private final Set<String> allCategories = new HashSet<>();
    private final Set<String> allDefects = new HashSet<>();
    private final Set<String> allBrands = new HashSet<>();

    //@Override
    public synchronized void saveRepair(Repair repair)
    {
        // check if sets are available         
        if(!this.repairsByUser.containsKey(repair.getClient()))
            this.repairsByUser.put(repair.getClient(),new HashSet<>());
        if(!this.repairsByCategory.containsKey(repair.getItem().getCategory()))
            this.repairsByCategory.put(repair.getItem().getCategory(), new HashSet<>());
        if(!this.repairsByDefect.containsKey(repair.getDetails().getDefect()))
            this.repairsByDefect.put(repair.getDetails().getDefect(), new HashSet<>());

        // add to maps
        this.repairsById.put(repair.getRepairId(), repair);
        this.repairsByUser.get(repair.getClient()).add(repair);
        this.repairsByCategory.get(repair.getItem().getCategory()).add(repair);
        this.repairsByDefect.get(repair.getDetails().getDefect()).add(repair);
        
        // keep category, defects and brands for later use
        this.allCategories.add(repair.getItem().getCategory());
        this.allDefects.add(repair.getDetails().getDefect());
        this.allBrands.add(repair.getItem().getBrand());
        
    }
    
    //@Override
    public synchronized void deleteRepair(Repair repair)
    {
        // check if sets are available         
        if(!this.repairsByUser.containsKey(repair.getClient()))
            this.repairsByUser.get(repair.getClient()).remove(repair);
        if(!this.repairsByCategory.containsKey(repair.getItem().getCategory()))
            this.repairsByCategory.put(repair.getItem().getCategory(), new HashSet<Repair>());
        if(!this.repairsByDefect.containsKey(repair.getDetails().getDefect()))
            this.repairsByDefect.put(repair.getDetails().getDefect(), new HashSet<Repair>());
    }
    
    //@Override
    public Repair getRepairByID(int id)
    {
        return repairsById.get(id);
    }

    //@Override
    public Set<Repair> getRepairsByUser(User user) throws RepairServiceException
    {
        if(!repairsByUser.containsKey(user))
            throw new RepairServiceException("No repairs found for this user: " + user.getUsername());
        return repairsByUser.get(user);
    }
    
    //@Override
    public Set<Repair> getRepairsByCategory(String category) throws RepairServiceException
    {
        if(!repairsByCategory.containsKey(category))
            throw new RepairServiceException("No repairs found for this category: " + category);
        return repairsByCategory.get(category);
    }

    //@Override
    public Set<Repair> getRepairsByDefect(String defect) throws RepairServiceException
    {
        if(!repairsByDefect.containsKey(defect))
            throw new RepairServiceException("No repairs found for this defect: " + defect);
        return repairsByDefect.get(defect);
    }

    //@Override
    public Set<String> getAllDefects()
    {
        return allDefects;
    }

    //@Override
    public Set<String> getAllCategories()
    {
        return allCategories;
    }

    //@Override
    public Set<String> getAllBrands()
    {
        return allBrands;
    }
    
}
