package plotPackage;


public class ManagementCompany {

	  private final int MAX_PROPERTY = 5;
	  private final int MGMT_WIDTH = 10;
	  private final int MGMT_DEPTH = 10;
	  private Property[] properties;
	  private double mgmFeePer;
	  private String name;
	  private String taxID;
	  private Plot plot;

	  public ManagementCompany() {
	    this.name = "";
	    this.taxID = "";
	    this.mgmFeePer = 0;
	    this.plot = new Plot();
	    this.properties = new Property[MAX_PROPERTY];
	  }

	  public ManagementCompany(String name, String taxID, double mgmFee) {
	    this.name = name;
	    this.taxID = taxID;
	    this.mgmFeePer = mgmFee;
	    this.plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
	    this.properties = new Property[MAX_PROPERTY];
	  }

	  public ManagementCompany(String name, String taxID, double mgmFee, 
	      int x, int y, int width, int depth) {
	    this.name = name;
	    this.taxID = taxID;
	    this.mgmFeePer = mgmFee;
	    this.plot = new Plot(x,y,width,depth);
	    this.properties = new Property[MAX_PROPERTY];
	  }

	  
	  public int addProperty(Property property) {
	    if (property == null) {
	      return -2;
	    }
	    
	    if (!plot.encompasses(property.getPlot())) {
	      //System.out.println(plot.getWidth() + " " + plot.getDepth());
	      //System.out.println(property.getPlot().getWidth() + " " + property.getPlot().getDepth());
	      return -3;
	    }
	    
	    for (int i = 0;i < properties.length;i++) {
	      if (properties[i] != null) {
	        if (properties[i].getPlot().overlaps(property.getPlot())) {
	          return -4;
	        }
	      } else {
	        properties[i]=property;
	        return i;
	      } 
	    }
	      return -1;
	  }
	  
	  public int addProperty(String name, String city, double rent, String owner) {
	    return addProperty(new Property(name, city, rent, owner));
	  }
	  
	  public int addProperty(String name, String city, double rent, String owner,
	      int x, int y, int width, int depth) {
	    return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	  }
	  
	  public double totalRent() {
	    double total = 0;
	    for (int i=0;i<properties.length;i++) {
	      if (properties[i]==null) {
	        break;
	      }
	      total += properties[i].getRentAmount();
	    }
	    return total;
	  }
	  
	  private int maxRentPropertyIndex() {
	    int index = -1;
	    double max = 0;
	    for (int i = 0;i<properties.length;i++) {
	      if (properties[i]==null) {
	        break;
	      }
	      if (properties[i].getRentAmount() > max) {
	        max = properties[i].getRentAmount();
	        index = i;
	      }
	    }
	    return index;
	  }
	  
	  public double maxRentProp() {
	    return properties[maxRentPropertyIndex()].getRentAmount();
	  }
	  
	  private String displayPropertyAtIndex(int i) {
	    return properties[i].toString();
	  }
	  
	   
	  /* (non-Javadoc)
	   * @see java.lang.Object#toString()
	   */
	  @Override
	  public String toString() {

	    String listOfProperties = "";
	    for (int i = 0; i < MAX_PROPERTY; i++) {
	      if (properties[i]==null) {
	        break;
	      } 
	      listOfProperties += properties[i] + "\n"; 
	    }
	    return "List of the properties for " + name + ", taxID: " + taxID
	        + "\n__________________________________________________\n"
	        + listOfProperties +  "__________________________________________________\n"
	        + "total management Fee: " + (totalRent() * mgmFeePer / 100);
	  }

	  /**
	   * @return the MAX_PROPERTY
	   */
	  public int getMAX_PROPERTY() {
	    return MAX_PROPERTY;
	  }

	  public Plot getPlot() {
	    return plot;
	  }

	  public String getName() {
	    return name;
	  }
}
