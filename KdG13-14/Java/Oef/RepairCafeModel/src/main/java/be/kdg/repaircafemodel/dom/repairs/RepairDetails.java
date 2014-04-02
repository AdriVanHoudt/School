/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafemodel.dom.repairs;

import be.kdg.repaircafemodel.service.exceptions.RepairServiceException;
import java.util.Objects;
import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 * Contains details about a repair.
 *
 * Details are: problem description, defect type, optional rebuttal by repairer,
 * pricing model, timestamps (submit and due date), time to expiration.
 *
 * @link(be.kdg.repaircafemodel.dom.repairs.Repair) details
 * @author wouter
 */
public class RepairDetails
{
    public enum PriceModel
    {
        PER_HOUR("Per Hour"), FIXED("Fixed");
        private final String str;

        private PriceModel(String str)
        {
            this.str = str;
        }

        @Override
        public String toString()
        {
            return str;
        }
    }

    private String defect;
    private String description;
    private String evaluation;
    private String rebuttal;
    private Rating rating;
    private Status status;
    private PriceModel priceModel;
    private DateTime dueDate;
    private final DateTime submitDate;
    private boolean assigned;

    public RepairDetails()
    {
        this.submitDate = new DateTime();
        this.dueDate = new DateTime().plusWeeks(2);
        this.rating = Rating.NotSet;
        this.status = Status.Broken;
    }

    public RepairDetails(String defect, String description, PriceModel priceModel, DateTime dueDate)
    {
        this();
        this.defect = defect;
        this.description = description;
        this.priceModel = priceModel;
        this.dueDate = dueDate;
    }

    public String getDefect()
    {
        return defect;
    }

    public void setDefect(String defect)
    {
        this.defect = defect;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getEvaluation()
    {
        return evaluation;
    }

    public void setEvaluation(String evaluation)
    {
        this.evaluation = evaluation;
    }

    public String getRebuttal()
    {
        return rebuttal;
    }

    public void setRebuttal(String rebuttal)
    {
        this.rebuttal = rebuttal;
    }

    public Rating getRating()
    {
        return rating;
    }

    public void setRating(Rating rating)
    {
        this.rating = rating;
    }

    public Status getStatus()
    {
        return status;
    }

    /**
     * Don't use this method directly.     
     * Change the status of repairs through the RepairService.
     * 
     * @see(be.kdg.repaircafemodel.service.api.RepairService#updateRepairStatus)
     * @param newStatus new Status for repair. Stati Fixed and Broken will only 
     * be accepted when Repair is assigned to Repairer
     *      
     */
    public void setStatus(Status newStatus)
    {
        if((newStatus.equals(Status.Fixed) || newStatus.equals(Status.Irreparable)) && !isAssigned())
            this.status = Status.Broken;
        else
            this.status = newStatus;
    }

    public PriceModel getPriceModel()
    {
        return priceModel;
    }

    public void setPriceModel(PriceModel priceModel)
    {
        this.priceModel = priceModel;
    }

    public DateTime getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(DateTime dueDate)
    {
        this.dueDate = dueDate;
    }

    public DateTime getSubmitDate()
    {
        return submitDate;
    }
    
    public boolean isAssigned()
    {
        return assigned;
    }

    public void setAssigned(boolean assigned)
    {
        this.assigned = assigned;
    }
    
    /**
     * How much time is left for bidding on this repair
     *
     * @return Period. Represents time period
     */
    public Period getExpirationTime()
    {
        return new Period(new DateTime(),dueDate);
    }

    @Override
    public String toString()
    {
        return "RepairDetails{defect=" + defect + ", description=" + description + ", priceModel=" + priceModel + ", dueDate=" + dueDate + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.defect);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.priceModel);
        hash = 59 * hash + Objects.hashCode(this.dueDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final RepairDetails other = (RepairDetails) obj;
        if (!Objects.equals(this.defect, other.defect))
        {
            return false;
        }
        if (!Objects.equals(this.description, other.description))
        {
            return false;
        }
        if (this.priceModel != other.priceModel)
        {
            return false;
        }
        if (!Objects.equals(this.dueDate, other.dueDate))
        {
            return false;
        }
        return true;
    }

    /**
     * A repair is rated by the client. This rating is used to update the
     * repairers overall rating.
     */
    public enum Rating
    {
        NotSet(0), VeryPoor(1), Poor(2), OK(3), Good(4), Excellent(5);

        private final int rating;

        private Rating(int rating)
        {
            this.rating = rating;
        }

        public static Rating toOrdinal(int rating)
        {
            switch (rating)
            {
                case 1:
                    return Rating.VeryPoor;
                case 2:
                    return Rating.Poor;
                case 3:
                    return Rating.OK;
                case 4:
                    return Rating.Good;
                case 5:
                    return Rating.Excellent;
                default:
                    return Rating.NotSet;
            }
        }
    };

    /**
     * Status of a repair.
     */
    public enum Status
    {
        Broken, Fixed, Irreparable;
    }

}
